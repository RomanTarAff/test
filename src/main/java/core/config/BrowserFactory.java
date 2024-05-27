package core.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static core.config.ConfigurationManager.configuration;

public class BrowserFactory
{
	
	public static WebDriver createDriver()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\test\\chromedriver.exe"); //121
		WebDriverManager.chromedriver().clearDriverCache().setup();
		return new ChromeDriver(getOptions());
	}
	
	public static ChromeOptions getOptions()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--dns-prefetch-disable");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--lang=us");
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.setHeadless(configuration().headless());
		return chromeOptions;
	}
}
