package utilities;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLocators {

    static Logger log = LoggerFactory.getLogger(FindLocators.class);

    /**
     * Store all locators methods of selenium: {@link By} and Appium {@link MobileBy}
     * in map using key as method of By and value as a full method name
     */
    private static Map<String, Method> methods = new HashMap<String, Method>();

    public FindLocators() {
        storeAllAvailableLocatorMethods();
    }

    private static void storeAllAvailableLocatorMethods() {
        try {
            Method[] mobByMeths = (MobileBy.class).getMethods();
            List<Method> methList = new ArrayList<Method>();
            for (Method meth : mobByMeths)
                methList.add(meth);
            for (Method byMeth : methList) {
                String methName = byMeth.toString();
                methName = methName.split("[(]")[0];
                int len = methName.split("[.]").length;
                methName = methName.split("[.]")[len - 1];
                methods.put(methName, byMeth);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    protected static Method getByMethod(String locator) {
        storeAllAvailableLocatorMethods();
        Method retMethod = null;
        try {
            if (methods.containsKey(locator)) {
                retMethod = methods.get(locator);
            } else if (methods.containsKey(locator.toLowerCase())) {
                retMethod = methods.get(locator);
            } else {
                throw new Exception("Given locator: " + locator + " is not available in Selenium or Appium methods");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return retMethod;
    }
}
