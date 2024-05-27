import core.selenium.DriverManager;
import core.selenium.TargetFactory;
import core.selenium.wait.DriverWait;
import listener.TestListener;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;

import static core.config.ConfigurationManager.configuration;
import static org.testng.Assert.assertEquals;

@Listeners(value = TestListener.class)
public class DashboardTests {

    private final Dimension dimension = new Dimension(1920, 1080);

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverManager.getInstance().setDriver(new TargetFactory().createInstance(browser));
        DriverManager.getInstance().getDriver().get(configuration().url());
        DriverManager.getInstance().getDriver().manage().window().setSize(dimension);
        DriverWait.turnOnImplicitWaits();
    }

    @Test(testName = "Dashboard")
    public void dashboard() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @Test(testName = "Dashboard admin user")
    public void dashboardAdminUser() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @Test(testName = "Dashboard super admin user")
    public void dashboardSuperAdminUser() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @Test(testName = "Dashboard manager user")
    public void dashboardManagerUser() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @AfterMethod()
    public void postCondition() {
        DriverManager.getInstance().getDriver().quit();
    }
}
