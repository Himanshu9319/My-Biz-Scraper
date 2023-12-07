//package utilsDB.redis_Utils;
//
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import redis.clients.jedis.Jedis;
//
//public class ConnectionManagerRedis {
//    private static final String sshHost = "13.127.137.247";
//    private static final String sshUser = "SBQA0015";
//    private static final int sshPort = 22;
//    private static final String privateKeyPath = "src/test/resources/SBQA0015/SBQA0015"; // Update with your private key path
//    private static final String dbUser = "SBQA0015";
//    private static final String dbPassword = "acc7de52f5ede00";
//    private static final int dbPort = 6379;
//    private static final int CONNECTION_TIMEOUT = 30000;
//    private static final String dbHost = "dev-redis.gfevze.ng.0001.aps1.cache.amazonaws.com";
//    private static Jedis jedis;
//    private static Session sshSession;
//
//    private static void connectToSSHServer() {
//        try {
//            JSch jsch = new JSch();
//
//            // Load private key for public key authentication
//            jsch.addIdentity(privateKeyPath);
//
//            sshSession = jsch.getSession(sshUser, sshHost, sshPort);
//            sshSession.setConfig("StrictHostKeyChecking", "no"); // Disable host key checking for simplicity
//            sshSession.setConfig("PreferredAuthentications", "publickey");
//            sshSession.setConfig("ConnectTimeout", String.valueOf(CONNECTION_TIMEOUT));
//
//            sshSession.connect();
//            if (sshSession.isConnected()) {
//                System.out.println("SSH Connection successful");
//            } else {
//                System.out.println("SSH Connection failed!");
//            }
//
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void connectToDatabaseRedis() throws JSchException {
//        connectToSSHServer();
//        String redisHost = "127.0.0.1";
////            String redisHost = "dev-redis.gfevze.ng.0001.aps1.cache.amazonaws.com";
////            int redisPort = 6379;
//        int redisPort = sshSession.setPortForwardingL(dbPort, dbHost, dbPort);
//
//        String connectionString = "redis://" + redisHost + ":" + redisPort;
//        // Connect to Redis
//        try {
//            jedis = new Jedis(connectionString);
////                jedis.auth(dbUser,dbPassword);
//            System.out.println("Connected to Redis successfully!");
//
//            // Perform Redis operations
////                jedis.set("key", "value");
//            System.out.println(jedis.hgetAll("vehiclesStats:DL52GD1885"));
////                System.out.println("Value for key: " + value);
//        } catch (Exception e) {
//            System.err.println("Error connecting to Redis: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            connectToDatabaseRedis();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeConnectionRedis();
//
//        }
//    }
//
//    public static void closeConnectionRedis() {
//        try {
//            if (jedis != null) {
//                jedis.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            if (sshSession != null) {
//                sshSession.disconnect();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
