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
public class LoanAppTests
{
	
	private DmFunnelPage dmFunnelPage;
	private BasicInformationPage basicInformationPage;
	private AnnualIncomePage annualIncomePage;
	private CreateAccountPage createAccountPage;
	private OfferPage offerPage;
	private final Address address = RandomAddress.get().next();
	private final Dimension dimension = new Dimension(1920, 1080);
	private final Faker faker = new Faker();
	private final GoogleStartPage googleStartPage = new GoogleStartPage();
	private final GoogleResultsPage googleResultsPage = new GoogleResultsPage();
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser)
	{
		DriverManager.getInstance().setDriver(new TargetFactory().createInstance(browser));
		DriverManager.getInstance().getDriver().get(configuration().url());
		DriverManager.getInstance().getDriver().manage().window().setSize(dimension);
		DriverWait.turnOnImplicitWaits();
	}
	
	@Test(testName = "Google search test")
	public void searchAndGetFirstLink()
	{
		String text = "Riga weather now";
		googleStartPage.setSearchTextAndSearch(text);
		assertEquals(googleResultsPage.returnTextOfTheFirstLink(), "Riga");
	}
	
	@AfterMethod()
	public void postCondition()
	{
		DriverManager.getInstance().getDriver().quit();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(testName = "Coding challenge UI test")
//	public void createLoanApp()
//	{
//		String loanAmount = "2000";
//		int individualAnnualIncomeMin = 120000;
//		int individualAnnualIncomeMax = 125000;
//		int additionalAnnualIncomeMin = 5000;
//		int additionalAnnualIncomeMax = 10000;
//		String email = "candidate+".concat(faker.number().digits(10).concat("@upgrade-challenge.com"));
//		String password = faker.internet().password(8, 17, true, false, true);
//		Faker faker = new Faker();
//		//String dateOfBirth = DateHelper.getRandomDateFromInterval("01/01/1930", "01/01/2000");
//
//		dmFunnelPage = new DmFunnelPage();
//		dmFunnelPage.setLoanAmount(loanAmount);
//		//dmFunnelPage.setLoanPurpose(DataHelper.randomEnum(LoanPurpose.class).getValue());
//		basicInformationPage = dmFunnelPage.checkYourRate();
//
//		basicInformationPage.setFirstName(faker.name().firstName());
//		basicInformationPage.setLastName(faker.name().lastName());
//		basicInformationPage.setHomeAddress(address.getStreet());
//		basicInformationPage.setCity(address.getCity());
//		basicInformationPage.setState(address.getState());
//		basicInformationPage.setZipCode(address.getPostalCode());
//		//basicInformationPage.setDateOfBirth(dateOfBirth);
//		annualIncomePage = basicInformationPage.onContinue();
//
//		annualIncomePage.setIndividualAnnualIncome(String.valueOf(
//				faker.random().nextInt(individualAnnualIncomeMin, individualAnnualIncomeMax)));
//		annualIncomePage.setAdditionalAnnualIncome(String.valueOf(
//				faker.random().nextInt(additionalAnnualIncomeMin, additionalAnnualIncomeMax)));
//		createAccountPage = annualIncomePage.onContinue();
//
//		createAccountPage.setEmail(email);
//		createAccountPage.setPassword(password);
//		createAccountPage.setStateForAgreements(Boolean.TRUE);
//		offerPage = createAccountPage.checkYourRate();
//
//		Integer loanAmountBeforeLogout = offerPage.getLoanAmount();
//		OfferPayment defaultPayment = offerPage.getDefaultPayment();
//
//		offerPage.openMenu();
//		offerPage.getRightMenuPanel().signOut();
//
//		DriverManager.getInstance().getDriver().get(configuration().loginUrl());
//		LoginPage loginPage = new LoginPage();
//		loginPage.setEmail(email);
//		loginPage.setPassword(password);
//		offerPage = loginPage.login();
//
//		OfferPayment defaultPaymentAfterLogin = offerPage.getDefaultPayment();
//		assertEquals(defaultPaymentAfterLogin, defaultPayment,
//				"Default payment after login does not equal default payment");
//		assertEquals(offerPage.getLoanAmount(), loanAmountBeforeLogout,
//				"Loan amount values are not equal");
//	}
}
