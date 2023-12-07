//package utilsDB.mySQL_Utils.operations;
//
//import net.sf.saxon.functions.DynamicContextAccessor;
//import utilsDB.mySQL_Utils.dataMapper.DataMapper;
//import utilsDB.mySQL_Utils.deserializer.DeserializerUtil;
//
//import java.sql.*;
//import java.time.Instant;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static utilities.CommonFunctionsAPI.*;
//import static utilsDB.mySQL_Utils.connection.ConnectionManagerMySQL.dbConnection;
//import static utilsDB.mySQL_Utils.connection.ConnectionManagerMySQL.dbName;
//
//public class DatabaseOperations {
//    private static int generatedId;
//
//    private static LocalTime localTime = LocalTime.now();
//    public static <T> List<T> selectData(String tableName, Class<T> clazz) {
//        List<T> result = new ArrayList<>();
//        String sql = "SELECT * FROM " + tableName;
//        try (
//                Statement statement = dbConnection.createStatement();
//                ResultSet resultSet = statement.executeQuery(sql)) {
//            while (resultSet.next()) {
//                T object = DeserializerUtil.fromResultSet(resultSet, clazz);
//                result.add(object);
//            }
//            System.out.println(result);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static <T> boolean insertData(List<T> dataList, String tableName, DataMapper<T> mapper) {
//        boolean isSuccess = false;
//        try {
//            String sql = generateInsertStatement(tableName, mapper);
//            PreparedStatement statement = null;
//            statement = dbConnection.prepareStatement(sql);
//            for (T data : dataList) {
//                mapper.mapData(statement, data);
//                statement.addBatch();
//            }
//
//            int[] batchResult = statement.executeBatch();
//            statement.close();
//
//            // If no exceptions occurred, check if all statements were executed successfully
//            for (int result : batchResult) {
//                if (result == PreparedStatement.EXECUTE_FAILED) {
//                    isSuccess = false;
//                    break;
//                }
//            }
//
//            isSuccess = true; // All statements executed successfully
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            isSuccess = false;
//            throw new RuntimeException(e);
//        }
//
//        return isSuccess;
//    }
//
//
//    private static <T> String generateInsertStatement(String tableName, DataMapper<T> mapper) {
//        StringBuilder columnNames = new StringBuilder();
//        StringBuilder placeholders = new StringBuilder();
//
//        String[] columns = mapper.getColumnNames();
//        for (int i = 0; i < columns.length; i++) {
//            if (i > 0) {
//                columnNames.append(", ");
//                placeholders.append(", ");
//            }
//            columnNames.append(columns[i]);
//            placeholders.append("?");
//        }
//
//        return "INSERT INTO " + tableName + " (" + columnNames + ") VALUES (" + placeholders + ")";
//    }
//
//    public static <T> void deleteData(String tableName, String conditionColumn, Object conditionValue) {
//        try {
//            String sql = "DELETE FROM " + tableName + " WHERE " + conditionColumn + " = ?";
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//
//            if (conditionValue instanceof String) {
//                statement.setString(1, (String) conditionValue);
//            } else if (conditionValue instanceof Integer) {
//                statement.setInt(1, (Integer) conditionValue);
//            } else if (conditionValue instanceof Long) {
//                statement.setLong(1, (Long) conditionValue);
//            }
//            // You can add more type checks and corresponding setXXX methods for other data types if needed.
//
//            int rowsAffected = statement.executeUpdate();
//            System.out.println("Successfully deleted " + rowsAffected + " row(s) from the table.");
//
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Object> selectDataWithQuery(String query) {
//        List<Object> result = new ArrayList<>();
//        try (
//                Statement statement = dbConnection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query)) {
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            int columnCount = metaData.getColumnCount();
//
//            while (resultSet.next()) {
//                Map<String, Object> row = new HashMap<>();
//                for (int i = 1; i <= columnCount; i++) {
//                    String columnName = metaData.getColumnName(i);
//                    Object value = resultSet.getObject(i);
//                    row.put(columnName, value);
//                }
//                result.add(row);
//            }
//
////            System.out.println(result);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static int executeInsertQueryAndGetGeneratedId(String insertQuery) {
//        int generatedId = -1;
//
//        try (
//                Statement statement = dbConnection.createStatement();
//        ) {
//            int affectedRows = statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
//
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        generatedId = generatedKeys.getInt(1);
//                    }
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return generatedId;
//    }
//    public static void insertLeaseRecord(int driverID) {
//
//
////        String updateQuery = "INSERT INTO blusmartDevDb.lease (lease_config_id, lease_start_timestamp, lease_end_timestamp, duty_start_time, duty_end_time, lease_duration, duty_duration, cut_off_start_time, cut_off_end_time, other_flags, is_lease_expired, is_active, created_timestamp, last_updated_timestamp, created_by, last_updated_by,gst_percent, commission_percent, minimum_guarantee, lease_cost, available_slots, max_slots, trip_earning_incentive_model_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,5,12,272,140, 0,0, 'GENERAL')";
//        String updateQuery = "INSERT INTO "+dbName+".lease (lease_config_id, lease_start_timestamp, lease_end_timestamp, duty_start_time, duty_end_time, lease_duration, duty_duration, cut_off_start_time, cut_off_end_time, is_lease_expired, is_active, created_timestamp, last_updated_timestamp, created_by, last_updated_by,gst_percent, commission_percent, minimum_guarantee, lease_cost, available_slots, max_slots, trip_earning_incentive_model_name, late_duty_start_penalty_config, early_duty_end_penalty_config, trip_incentive_config, feedback_incentive_config, absent_penalty_config, late_duty_end_penalty_config, trip_earning_incentive_config, overtime_incentive_config, vehicle_variant) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,5,12,272,140, 0,0, 'GENERAL', '{\"0\":0.0,\"1800\":108.0,\"3600\":216.0,\"5400\":324.0}', '{\"0\":0.0,\"1800\":108.0,\"3600\":216.0,\"5400\":324.0}' , '{\"0\":0.0}' , '{\"0.0\":0.0}' , '{\"vehicleVariant\":\"Tigor XM\",\"singleSlotPenalty\":120.0,\"doubleSlotPenalty\":240.0,\"isActive\":true}' , '{\"0\":0.0,\"1800\":60.0,\"3600\":120.0,\"5400\":180.0,\"7200\":240.0,\"9000\":300.0,\"10800\":360.0,\"12600\":420.0,\"14400\":480.0,\"16200\":540.0,\"18000\":600.0}' , '{\"8001\":500.00000000,\"9001\":1000.00000000,\"10001\":1500.00000000,\"11001\":2100.00000000,\"12001\":2750.00000000,\"13001\":3400.00000000,\"14001\":4000.00000000,\"15001\":4750.00000000,\"16001\":5500.00000000,\"17001\":6500.00000000,\"18001\":7200.00000000,\"20001\":8000.00000000}' , '{\"0\":1.0}', 'Tigor XM')";
//
//        try (Connection connection = dbConnection;
//             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS)) {
//
//            int leaseConfigId = 0;
//            ZonedDateTime now = ZonedDateTime.now();
//
//            // Start of the day
//            ZonedDateTime leaseStart = now.toLocalDate().atStartOfDay(now.getZone());
//
//            // End of the day - 1 second
//            ZonedDateTime leaseEnd = now.toLocalDate().plusDays(1).atStartOfDay(now.getZone()).minus(1, ChronoUnit.MILLIS);
//
//
//            LocalTime dutyStartTime = LocalTime.parse("01:30");
//            LocalTime dutyEndTime = LocalTime.parse("22:30");
//            long leaseDuration = ChronoUnit.SECONDS.between(leaseStart, leaseEnd);
//            long dutyDuration = ChronoUnit.SECONDS.between(dutyStartTime, dutyEndTime);
//            LocalTime cutOffStartTime = dutyStartTime.plus(1, ChronoUnit.HOURS);
//            LocalTime cutOffEndTime = dutyEndTime.plus(1, ChronoUnit.HOURS);
////            String otherFlags = "{\"vehicleVariant\":\"XM+\",\"singleSlotPenalty\":150.0,\"doubleSlotPenalty\":300.0,\"isActive\":true}";
//            int isLeaseExpired = 0;
//            int isActive = 1;
//            long createdTimestamp = now.toInstant().toEpochMilli();
//            long lastUpdatedTimestamp = now.toInstant().toEpochMilli();
//            int createdBy = 119;
//            int lastUpdatedBy = 119;
//
//            preparedStatement.setInt(1, leaseConfigId);
//            preparedStatement.setLong(2, leaseStart.toInstant().toEpochMilli());
//            preparedStatement.setLong(3, leaseEnd.toInstant().toEpochMilli());
//            preparedStatement.setString(4, dutyStartTime.toString());
//            preparedStatement.setString(5, dutyEndTime.toString());
//            preparedStatement.setLong(6, leaseDuration);
//            preparedStatement.setLong(7, dutyDuration);
//            preparedStatement.setString(8, cutOffStartTime.toString());
//            preparedStatement.setString(9, cutOffEndTime.toString());
////            preparedStatement.setString(10, otherFlags);
//            preparedStatement.setInt(10, isLeaseExpired);
//            preparedStatement.setInt(11, isActive);
//            preparedStatement.setLong(12, createdTimestamp);
//            preparedStatement.setLong(13, lastUpdatedTimestamp);
//            preparedStatement.setInt(14, createdBy);
//            preparedStatement.setInt(15, lastUpdatedBy);
//
//            preparedStatement.executeUpdate();
//
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    generatedId = generatedKeys.getInt(1);
//                    System.out.println("Generated ID: " + generatedId);
//                }
//            }
//
//            System.out.println("Lease record inserted successfully.");
//
//            String leaseDriverInsertQuery = "INSERT INTO "+dbName+".lease_driver_daily_stats (lease_id,driver_id,record_date,lease_driver_daily_stats_state,total_online_duration,total_paused_duration,total_duty_duration,total_trip_duration,checkin_checkout_ids,ride_ids,trips_count,vehicles_count,vehicles_number,sum_of_feedback,number_of_rated_rides,trip_earnings,estimated_lease_cost,actual_lease_cost,estimated_minimum_guarantee,actual_minimum_guarantee,driver_earnings,lease_cost_penalty,lease_cost_penalty_breakup,minimum_guarantee_penalty,minimum_guarantee_penalty_breakup,duty_start_timestamp,duty_end_timestamp,is_driver_present,is_active,created_timestamp,last_updated_timestamp,created_by,last_updated_by,commission,gst,driver_take_home,total_overtime_duration,overtime_earnings,has_overlapping_happened,overlapped_id,official_duty_end_timestamp,latest_hub_reach_timestamp,payout_id,total_paused_breakup_duration,duty_day,check_in_timestamp,check_in_hub,vehicle_handover_epochs,official_duty_start_timestamp,total_pre_overtime_duration,total_post_overtime_duration,pre_overtime_earnings,post_overtime_earnings,slot,slot_wise_payout_id,attendance_state,other_flags,total_planned_mbg_duration,total_actual_mbg_duration,total_paid_mbg_duration,total_actual_supply_duration,total_paid_supply_duration,total_early_duty_start_duration,total_late_duty_start_duration,total_early_duty_end_duration,total_late_duty_end_duration,total_paid_buffer,application_source,lease_agreement_status,signed_lease_agreement) VALUES({lease_id},{driver_id},{record_date},'CREATED',0,0,0,0,NULL,NULL,0,0,NULL,0,0,0.00000000,240.00000000,0.00000000,432.00000000,0.00000000,0.00000000,0.00000000,NULL,0.00000000,NULL,NULL,NULL,0,1,1693288667585,1693288667585,119,119,0.00000000,0.00000000,0.00000000,0,0.00000000,NULL,NULL,{official_duty_end_timestamp},NULL,NULL,NULL,0,NULL,NULL,NULL,{official_duty_start_timestamp},0,0,0.00000000,0.00000000,{slot},508867,NULL,NULL,7200,0,0,0,0,0,0,0,0,0,'DRIVER',NULL,NULL)";
//            leaseDriverInsertQuery = leaseDriverInsertQuery.replace("{lease_id}", String.valueOf(generatedId));
//            leaseDriverInsertQuery = leaseDriverInsertQuery.replace("{driver_id}", String.valueOf(driverID));
//            leaseDriverInsertQuery = leaseDriverInsertQuery.replace("{record_date}", getTimeStampForLeaseUpload(leaseStart.toInstant().toEpochMilli()));
//            leaseDriverInsertQuery = leaseDriverInsertQuery.replace("{slot}", "1");
//            leaseDriverInsertQuery = leaseDriverInsertQuery.replace("{official_duty_start_timestamp}", getTimeStampForLeaseUpload(leaseStart.toInstant().toEpochMilli()));
//            leaseDriverInsertQuery = leaseDriverInsertQuery.replace("{official_duty_end_timestamp}", getTimeStampForLeaseUpload(leaseEnd.toInstant().toEpochMilli()));
//            DatabaseOperations.executeInsertQueryAndGetGeneratedId(leaseDriverInsertQuery);
//
//            System.out.println("Lease Successfully Uploaded for Driver : " + driverID);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void insertVehicleRecordIntoVehicle(int noOfVehicles) {
//        for(int i=1;i<=noOfVehicles;i++){
//            String vehicleNumber = getRandomVehicleNumber();
////            System.out.println("Onboarding Vehicle : " + vehicleNumber);
//            String updateQueryVehicle = "INSERT INTO "+dbName+".vehicles (vehicle_number, is_active, model_name, display_name, hub_name, capacity, created_timestamp, last_updated_timestamp, created_by, last_updated_by, km_range, vehicle_name, is_rfid, vehicle_category) VALUES('{vehicleNumber}', 1, 'ZS', 'MG ZS', '7', '5', 1689316435507, 1689316435507, 119, 119, 380, 'MG ZS', 0, 'PREMIUM')";
//            updateQueryVehicle = updateQueryVehicle.replace("{vehicleNumber}", vehicleNumber);
//            DatabaseOperations.executeInsertQueryAndGetGeneratedId(updateQueryVehicle);
//            String updateQueryVehicleState = "INSERT INTO blusmartDevDb.vehicle_state (vehicle_number, colour, vehicle_state, is_active, created_timestamp, last_updated_timestamp, created_by, last_updated_by, current_hub, other_flags, vehicle_maintenance_status, odometer_reading, last_odometer_timestamp, application_source, is_aka_enabled) VALUES('{vehicleNumber}', NULL, 'UNASSIGNED', 1, 1669969563271, 1691431382006, 119, 150376, 2, '{\"parkingStatus\":\"FAST_CHARGING\"}', 'ACTIVE', 1000.00000000, 1687848509258, 'HUBPLUS', 1)";
//            updateQueryVehicleState = updateQueryVehicleState.replace("{vehicleNumber}", vehicleNumber);
//            DatabaseOperations.executeInsertQueryAndGetGeneratedId(updateQueryVehicleState);
//            System.out.println(i + " . Onboarded Vehicle : " + vehicleNumber);
//        }
//    }
//
//    public static void insertVehiclehandoverItems(String driverId, String vehicleNumber)
//    {
//       String leaseVehiclehandoveritems =  "INSERT INTO "+dbName+".vehicle_handover_items(id, vehicle_item_id, vehicle_handover_id, serial_number, status, is_active, created_timestamp, last_updated_timestamp, created_by, last_updated_by, submitted_by, was_ok_earlier)VALUES (1, 1, 14, NULL, 'OK', 1, 1621338649672, 1621338649672, 26029, NULL, 'DRIVER', 0)";
//
//        String leaseVehiclehandover =  "INSERT INTO "+dbName+".vehicle_handover(id, from_id, to_id, vehicle_number, handover_type, handover_status, soc_reading, odometer_reading, is_active, created_timestamp, last_updated_timestamp, created_by, last_updated_by, comments, hub_id, other_flags, handover_notes) VALUES(1, 119, {punchId}, '{vehicleNumber}', 'USER_TO_DRIVER', 'COMPLETED', NULL, 0.00000000, 1, 1616234379509, 1640689939470, 119, 329, NULL, NULL, NULL, NULL)";
//    }
//    public static void updateDriverLeaseToCompleted(String driverId) {
//            String updateQueryVehicle = "UPDATE lease_driver_daily_stats SET lease_driver_daily_stats_state = 'COMPLETED' WHERE driver_id='"+driverId+"'";
//            DatabaseOperations.executeInsertQueryAndGetGeneratedId(updateQueryVehicle);
//            System.out.println("Lease marked as Completed for driver : " + driverId);
//    }
//}
