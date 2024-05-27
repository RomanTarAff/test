import com.arakelian.faker.model.Address;
import com.arakelian.faker.service.RandomAddress;
import com.github.javafaker.Faker;
import core.selenium.DriverManager;
import core.selenium.TargetFactory;
import core.selenium.wait.DriverWait;
import listener.TestListener;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui.page.AnnualIncomePage;
import ui.page.BasicInformationPage;
import ui.page.CreateAccountPage;
import ui.page.DmFunnelPage;
import ui.page.GoogleResultsPage;
import ui.page.GoogleStartPage;
import ui.page.OfferPage;

import static core.config.ConfigurationManager.configuration;
import static org.testng.Assert.assertEquals;

@Listeners(value = TestListener.class)
public class LoginTests {
    private final Dimension dimension = new Dimension(1920, 1080);

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverManager.getInstance().setDriver(new TargetFactory().createInstance(browser));
        DriverManager.getInstance().getDriver().get(configuration().url());
        DriverManager.getInstance().getDriver().manage().window().setSize(dimension);
        DriverWait.turnOnImplicitWaits();
    }

    @Test(testName = "Login")
    public void login() {
        String text = "Riga weather now";
        assertEquals("Tallin", "Riga");
    }

	@Test(testName = "Login admin user")
	public void loginAdminUser() {
		String text = "Riga weather now";
		assertEquals("Tallin", "Riga");
	}

	@Test(testName = "Login super admin user")
	public void loginSuperAdminUser() {
		String text = "Riga weather now";
		assertEquals("Tallin", "Riga");
	}

	@Test(testName = "Login manager user")
	public void loginManagerUser() {
		String text = "Riga weather now";
		assertEquals("Tallin", "Riga");
	}

    @AfterMethod()
    public void postCondition() {
        DriverManager.getInstance().getDriver().quit();
    }
}
