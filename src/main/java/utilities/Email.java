package utilities;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.ArrayList;
import java.util.Properties;

import static utilities.Constants.Project_Name;
import static utilities.EmailConfig.*;

public class Email {
    static Properties properties = TestUtilities.loadConfigProperties();

    /**
     * sendEmail_WithAttachmentsAndFormattedBodyText_ToManyUsersRajat
     */
    public static void sendEmail(int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

        if (properties.getProperty("sendEmailToUser").equalsIgnoreCase("YES")) {
            //    System.out.println("File name: " + FrameworkConstants.getExtentReportFilePath());
            String messageBody = getTestCasesCountInFormat(count_totalTCs, count_passedTCs, count_failedTCs,
                    count_skippedTCs);
            System.out.println(messageBody);

            /*
             * String attachmentFile_ExtentReport = Constants.REPORTS_Folder +
             * "All_Automation_Report_Fri_Sep_10_03_47_17_IST_2021.html";
             */

            //String attachmentFile_ExtentReport = FrameworkConstants.getExtentReportFilePath();

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
                        "/Users/fabhotels/Downloads/FabHotels/testResults/extentReports/extentReport.html");
                System.out.println("****************************************");
                System.out.println("Email sent successfully.");
                System.out.println("****************************************");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    }

    private static String getTestCasesCountInFormat(int count_totalTCs, int count_passedTCs, int count_failedTCs,
                                                    int count_skippedTCs) {
        System.out.println("count_totalTCs: " + count_totalTCs);
        System.out.println("count_passedTCs: " + count_passedTCs);
        System.out.println("count_failedTCs: " + count_failedTCs);
        System.out.println("count_skippedTCs: " + count_skippedTCs);

        return "<html>\r\n" + "\r\n" + " \r\n" + "\r\n"
                + "        <body> \r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n<tr align=\"center\"><td colspan=\"4\"><h2>"
                + Project_Name + "</h2></td></tr>\r\n<tr><td>\r\n\r\n"
                + "       <table style=\"background:#67c2ef;width:120px\" >\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_totalTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Total</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
                + "               \r\n" + "                 <table style=\"background:#79c447;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_passedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Passed</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
                + "                <table style=\"background:#ff5454;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_failedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Failed</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
                + "                <td>\r\n" + "                <table style=\"background:#fabb3d;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_skippedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Skipped</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
                + "                </tr>\r\n" + "               \r\n" + "                \r\n"
                + "            </table>\r\n" + "       \r\n" + "    </body>\r\n" + "</html>";
    }

    private static String getFailedIrl(ArrayList<Object> list, int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {
        return "<html>\r\n" + "\r\n" + " \r\n" + "\r\n"
                + "        <body> \r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n<tr align=\"center\"><td colspan=\"4\"><h2>"
                + list + "</h2></td></tr>\r\n<tr><td>\r\n\r\n"
                + "       <table style=\"background:#67c2ef;width:120px\" >\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_totalTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Total</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
                + "               \r\n" + "                 <table style=\"background:#79c447;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_passedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Passed</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
                + "                <table style=\"background:#ff5454;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_failedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Failed</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
                + "                <td>\r\n" + "                <table style=\"background:#fabb3d;width:120px\">\r\n"
                + "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
                + count_skippedTCs + "</td></tr>\r\n"
                + "                     <tr><td align=\"center\">Skipped</td></tr>\r\n" + "       \r\n"
                + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
                + "                </tr>\r\n" + "               \r\n" + "                \r\n"
                + "            </table>\r\n" + "       \r\n" + "    </body>\r\n" + "</html>";
    }


    public static void sendFailedEmail(ArrayList<Object> link, int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

        if (properties.getProperty("sendEmailToUser").equalsIgnoreCase("YES")) {
            //    System.out.println("File name: " + FrameworkConstants.getExtentReportFilePath());
            String messageBody = getFailedIrl(link, count_totalTCs, count_passedTCs, count_failedTCs,
                    count_skippedTCs);
            System.out.println(messageBody);

            /*
             * String attachmentFile_ExtentReport = Constants.REPORTS_Folder +
             * "All_Automation_Report_Fri_Sep_10_03_47_17_IST_2021.html";
             */

            //String attachmentFile_ExtentReport = FrameworkConstants.getExtentReportFilePath();

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
                        "");
                System.out.println("****************************************");
                System.out.println("Email sent successfully.");
                System.out.println("****************************************");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    }

    public static void emailSend(String error, BodyPart bosy) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM,
                                PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new
                    InternetAddress(FROM));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("abhishek.singh@fabhotels.com"));
            if (properties.getProperty("ismobileview").equalsIgnoreCase("no"))
                message.setSubject("WEB URL HEALTH CHECK");
            else
                message.setSubject("MOBILE URL HEALTH CHECK");

            BodyPart messageBodyPart1 = new MimeBodyPart();

            messageBodyPart1.setText(error);

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bosy);
            // multipart.addBodyPart(messageBodyPart1);
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }
    }


}
