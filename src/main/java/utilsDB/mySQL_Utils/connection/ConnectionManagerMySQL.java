//package utilsDB.mySQL_Utils.connection;
//
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import io.cucumber.java.DataTableType;
//import utilsDB.mySQL_Utils.model.Person;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Map;
//
//import static org.testng.AssertJUnit.assertNotNull;
//
//public class ConnectionManagerMySQL {
//    private static final String sshHost = "13.127.137.247";
//    private static final String sshUser = "SBQA0015";
//    private static final int sshPort = 22;
//    private static final String privateKeyPath = "src/test/resources/SBQA0015/SBQA0015";
//    public static String dbHost;
//    public static String dbUser;
//    public static String dbPassword;
//    public static String dbName;
//    private static final int dbPort = 3306; // Default MySQL port
//    private static final int CONNECTION_TIMEOUT = 30000;
//    private static final int MAX_CONNECTION_RETIES = 3;
//    private static final int CONNECTION_RETRY_DELAY_MS = 1000;
//    public static Connection dbConnection;
//    private static Session sshSession;
//
//    private static void connectToSSHServer() {
//        try {
//            JSch jsch = new JSch();
//
//            // Load private key for public key authentication
//            jsch.addIdentity(privateKeyPath);
//
//            for (int retry = 0; retry < MAX_CONNECTION_RETIES; retry++) {
//                try {
//                    sshSession = jsch.getSession(sshUser, sshHost, sshPort);
//                    sshSession.setConfig("StrictHostKeyChecking", "no"); // Disable host key checking for simplicity
//                    sshSession.setConfig("PreferredAuthentications", "publickey");
//                    sshSession.setConfig("ConnectTimeout", String.valueOf(CONNECTION_TIMEOUT));
//
//                    sshSession.connect();
//                    if (sshSession.isConnected()) {
//                        System.out.println("SSH Connection successful");
//                        break;
//                    } else {
//                        System.out.println("Retry: " + retry + " - Connection is not successful!");
//                    }
//
//                } catch (JSchException e) {
//                    if (retry < MAX_CONNECTION_RETIES - 1) {
//                        Thread.sleep(CONNECTION_RETRY_DELAY_MS);
//                    } else {
//                        System.out.println("SSH conneciton failed after multiple reties!");
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        } catch (JSchException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void connectToMySQLDatabase() throws JSchException {
//        boolean connected = false;
//
//        // JDBC connection through SSH tunnel
//        int assignedPort = sshSession.setPortForwardingL(0, dbHost, dbPort);
//        String jdbcHost = "127.0.0.1";
//        String jdbcUrl = "jdbc:mysql://" + dbUser + ":" + dbPassword + "@" + jdbcHost + ":" + assignedPort + "/"+dbName+"?serverTimezone=UTC&autoReconnect=true&useSSL=false";
//        int retryCount = 0;
//        while (!connected && retryCount < MAX_CONNECTION_RETIES) {
//            try {
//                DriverManager.setLoginTimeout(CONNECTION_TIMEOUT); // set connection timeout
//                dbConnection = DriverManager.getConnection(jdbcUrl);
//                connected = true;
//                System.out.println("DB Connection successful");
//            } catch (SQLException e) {
//                retryCount++;
//                System.out.println("Database connection failed on attempt " + retryCount + ", will retry...");
//                try {
//                    Thread.sleep(CONNECTION_RETRY_DELAY_MS);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        if (!connected) {
//            System.out.println("Failed to establish database connection after multiple retries!");
//        }
//    }
//
//    private static void verifyDatabaseConnection() {
//        assertNotNull("Database connection should not be null.", dbConnection);
//    }
//
//    protected static void closeConnections() {
//        if (dbConnection != null) {
//            try {
//                dbConnection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (sshSession != null) {
//            sshSession.disconnect();
//        }
//    }
//
//    public static void connectToDatabaseMySQL() throws JSchException {
//        connectToSSHServer();
//        connectToMySQLDatabase();
//        verifyDatabaseConnection();
//    }
//
//    public static void closeConnectionDatabaseMySQL() {
//        closeConnections();
//    }
//
//    @DataTableType
//    public Person convertToPerson(Map<String, String> entry) {
//        String name = entry.get("name");
//        int age = Integer.parseInt(entry.get("age"));
//        return new Person(name, age);
//    }
//
//    //    @And("Validate the data for {string} {string} {string} {string}")
//    private void validateData() {
//        if (dbConnection != null) {
//            try {
//                String sqlQuery = "SELECT id, rider_id, prive_key, is_membership_active, is_active, total_points FROM "+dbName+".rider_prive_details WHERE total_points >10000";
//                ResultSet resultSet = dbConnection.prepareStatement(sqlQuery).executeQuery();
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("id");
//                    String riderId = resultSet.getString("rider_id");
//                    String totalPoints = resultSet.getString("total_points");
//                    System.out.println("ID: " + id + ", Rider ID: " + riderId + ", Total Points: " + totalPoints);
//                }
//                dbConnection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (sshSession != null) {
//            sshSession.disconnect();
//        }
//    }
//}
