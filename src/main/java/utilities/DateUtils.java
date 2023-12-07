package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtils {

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static String generateRandomCheckInDate() {
        Calendar calendar = Calendar.getInstance();
        // Set the minimum date for check-in (e.g., today)
        calendar.setTime(new Date());

        // Set the maximum date for check-in (e.g., 30 days from today)
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Minimum 1 day in advance
        int maxDaysInFuture = 1; // Maximum 30 days in advance
        calendar.add(Calendar.DAY_OF_MONTH, new Random().nextInt(maxDaysInFuture));

        Date checkInDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(checkInDate);
    }

    public static String generateRandomCheckOutDate(String checkInDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(checkInDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Set the maximum duration of stay (e.g., 1 to 7 days)
            int minDuration = 1; // Minimum 1 day stay
            int maxDuration = 1; // Maximum 7 days stay
            int duration = minDuration + new Random().nextInt(maxDuration - minDuration + 1);

            calendar.add(Calendar.DAY_OF_MONTH, duration);

            Date checkOutDate = calendar.getTime();
            return dateFormat.format(checkOutDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
