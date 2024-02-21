package utilities;

import java.text.SimpleDateFormat;

import static utilities.Constants.Project_Name;

public class EmailConfig {
    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";
    public static final String FROM = "himanshu.shukla1@fabhotels.com";
    public static final String PASSWORD = "netd bxzh wxmm ftdr";

    /* "**********@gmail.com", */
    public static final String[] TO = {"abhishek.singh@fabhotels.com", "swapnil.srivastava@fabhotels.com", "sahil.malhan@fabhotels.com", "akshay.kumar@travelplusapp.com"};
    public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
    public static final String SUBJECT = Project_Name + "-" + timeStamp;
}
