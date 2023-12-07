package UtilsAPI.helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeSuite;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Before the Scenario: " + scenario.getName());
        CommonContextFactory.getCommonContext().setScenario(scenario);
        CommonContextFactory.getCommonContext().setFilter(new CustomLogFilter());
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After the Scenario: " + scenario.getName());
        // You can add teardown code here
    }

    @BeforeSuite
    public void beforeSuite(Scenario scenario) {

    }
}
