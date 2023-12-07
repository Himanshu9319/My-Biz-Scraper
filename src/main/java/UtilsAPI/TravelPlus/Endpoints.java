package UtilsAPI.TravelPlus;

import utilities.Base;
import utilities.Constants;
import utilities.TestUtilities;

import java.util.Properties;

public class Endpoints {

    public static final String TRAVEL_PLUS_LOGIN = "/company/v1/corporate/admin/auth/login";
    public static final String TRAVEL_PLUS_AUTH_OTP = "/company/v1/corporate/admin/auth/otp/validate";

    public static  final  String TRAVEL_SEARCH_API= "/company/v3/corporate/admin/flight/search";

    public static final String BOOK_FLIGHTS_API="/company/v3/corporate/admin/flight/booking/checkout/initial";

    public static final String PAYMENT_API = "/company/v3/corporate/admin/flight/booking/checkout/resolve";
    public static final String CONFIRM_API="/company/v3/corporate/admin/flight/booking/confirm";

    public static final String DETAILS_API="/company/v2/corporate/admin/flight/booking/details";

    public static final String CREATE_API="/company/v3/corporate/admin/flight/booking/create";

}
