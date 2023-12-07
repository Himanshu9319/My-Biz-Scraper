package utilities;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class CommonFunctionsAPI {
    public static String getKeyFromResponseJson(Response response, String key) {
        JsonPath jsonPath = new JsonPath(response.asString());
        return jsonPath.getString(key);
    }

    public static <T> String convertDtoToJson(T obj) {
        return new Gson().toJson(obj);
    }

    public static Long getTime(int addMinutes) {
        Date date1 = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.MINUTE, addMinutes);
        return c.getTime().getTime();
    }

    public static double centralLatitude = 28.46025; // Replace with your central latitude
    public static double centralLongitude = 77.00355; // Replace with your central longitude
    public static double maxRadiusKm = 3.0;
    public static double generateRandomCoordinate(double min, double max) {
        return min + (max - min) * Math.random();
    }

    public static double getRandomLatitude(double centralLat, double maxRadius) {
        double latInRadians = Math.toRadians(centralLat);
        double latOffset = maxRadius / 111.32; // 1 degree of latitude is approximately 111.32 km
        double minLat = centralLat - latOffset;
        double maxLat = centralLat + latOffset;

        return generateRandomCoordinate(minLat, maxLat);
    }
    public static double getRandomLongitude(double centralLon, double centralLat, double maxRadius) {
        double lonInRadians = Math.toRadians(centralLon);
        double lonOffset = maxRadius / (111.32 * Math.cos(centralLat));
        double minLon = centralLon - lonOffset;
        double maxLon = centralLon + lonOffset;

        return generateRandomCoordinate(minLon, maxLon);
    }
    public static void main(String[] args) {
        Faker faker = new Faker();

        double randomLat = getRandomLatitude(centralLatitude, maxRadiusKm);
        double randomLon = getRandomLongitude(centralLongitude, centralLatitude, maxRadiusKm);

        System.out.println("Random Latitude: " + randomLat);
        System.out.println("Random Longitude: " + randomLon);
    }
    public static double getLat(double centralLon, double centralLat, double maxRadius){
        double lonInRadians = Math.toRadians(centralLon);
        double lonOffset = maxRadius / (111.32 * Math.cos(centralLat));
        double minLon = centralLon - lonOffset;
        double maxLon = centralLon + lonOffset;
        return generateRandomCoordinate(minLon, maxLon);
    }







    public static double getPickUpLat() {
        Faker faker = new Faker();
        double randomLat = getRandomLatitude(centralLatitude, maxRadiusKm);
        return faker.number().randomDouble(6, (long) 28.3905, (long) 28.5300);
    }

    public static double getPickUpLong(){
        Faker faker = new Faker();
        return faker.number().randomDouble(6, (long) 76.9400, (long)77.0471);
    }

    public static double getDropLat() {
        Faker faker = new Faker();
        return faker.number().randomDouble(6, (long) 28.3905, (long) 28.5300);
    }

    public static double getDropLong() {
        Faker faker = new Faker();
        return faker.number().randomDouble(6, (long) 76.9400, (long) 77.0471);
    }

    public static long getTimeStampInMiliSeconds(int hours) {
        // Get the current epoch timestamp in milliseconds
        long currentTimestampMillis = System.currentTimeMillis();
        // Convert to Instant and add 6 hours
        Instant currentInstant = Instant.ofEpochMilli(currentTimestampMillis);
        if (hours > 0) {
            Instant newInstant = currentInstant.plus(6, ChronoUnit.HOURS);
            // Get the new epoch timestamp in milliseconds
            long newTimestampMillis = newInstant.toEpochMilli();
            return newTimestampMillis;
        } else {
            return currentTimestampMillis;
        }
    }

    public static String getRandomVehicleNumber() {
        final String[] STATE_CODES = {"DL", "MH", "UP", "TN", "KA"};
        Faker faker = new Faker();
        String stateCode = STATE_CODES[faker.random().nextInt(STATE_CODES.length)];
        String pdigits = faker.regexify("\\d{2}");
        String letters = faker.regexify("[A-Z]{2}");
        String sdigits = faker.regexify("\\d{4}");

        return stateCode + pdigits + letters + sdigits;
    }

    public static String getTimeStampForLeaseUpload(long timeStampInMiliSeconds){
        String timestamp = String.valueOf(timeStampInMiliSeconds);
        if(timestamp.length()>12)
            timestamp = timestamp.substring(0,timestamp.length()-5)+"00000";
        return timestamp;
    }
}

