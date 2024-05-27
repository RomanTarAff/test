package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static DriverManager instance  = new DriverManager();

    private DriverManager() {}

    public static DriverManager getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driverOb) {
       driver.set(driverOb);
    }

    public void getSessionId() {
        System.out.println("Session id: " + ((RemoteWebDriver) getDriver()).getSessionId());
    }

    public void closeBrowser() {
        getDriver().quit();
        driver.remove();
    }
}
