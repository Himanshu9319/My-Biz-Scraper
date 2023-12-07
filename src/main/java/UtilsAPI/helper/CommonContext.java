package UtilsAPI.helper;

import io.cucumber.java.Scenario;

public class CommonContext {
    private static final CommonContext testContext = new CommonContext();
    private Scenario scenario;
    private CustomLogFilter filter;

    public CommonContext() {
    }

    public static CommonContext getInstance() {
        return testContext;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public CustomLogFilter getFilter() {
        return this.filter;
    }

    public void setFilter(CustomLogFilter filter) {
        this.filter = filter;
    }
}
