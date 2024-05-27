import core.selenium.DriverManager;
import core.selenium.TargetFactory;
import core.selenium.wait.DriverWait;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;

import static core.config.ConfigurationManager.configuration;
import static org.testng.Assert.assertEquals;

public class OrderTests {

    private final Dimension dimension = new Dimension(1920, 1080);

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverManager.getInstance().setDriver(new TargetFactory().createInstance(browser));
        DriverManager.getInstance().getDriver().get(configuration().url());
        DriverManager.getInstance().getDriver().manage().window().setSize(dimension);
        DriverWait.turnOnImplicitWaits();
    }

    @Test(testName = "order")
    public void order() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @Test(testName = "order admin user")
    public void orderAdminUser() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @Test(testName = "order super admin user")
    public void orderSuperAdminUser() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @Test(testName = "order manager user")
    public void orderManagerUser() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

    @AfterMethod()
    public void postCondition() {
        DriverManager.getInstance().getDriver().quit();
    }
}
