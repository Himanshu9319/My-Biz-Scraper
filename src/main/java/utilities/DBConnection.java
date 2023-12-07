//package utilities;
//
//import lombok.Getter;
//import lombok.Setter;
//import utilsDB.mySQL_Utils.connection.ConnectionManagerMySQL;
//
//import java.util.Properties;
//
//@Getter
//@Setter
//public class DBConnection {
//    public static void useMySQL_Database(String countryCode, String database, String env) {
//        Properties properties = TestUtilities.addConfigProperties(countryCode,database, env);
//        ConnectionManagerMySQL.dbHost = properties.getProperty("dbHost");
//        ConnectionManagerMySQL.dbUser = properties.getProperty("dbUser");
//        ConnectionManagerMySQL.dbPassword = properties.getProperty("dbPassword");
//        ConnectionManagerMySQL.dbName = properties.getProperty("dbName");
//    }
//}
//
