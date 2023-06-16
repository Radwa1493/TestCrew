package TestRunner;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;



@Test
@CucumberOptions(
		features = "src/test/java/features/TestCase.feature"
		, glue = {"stepDefinations","Hooks"}

		)public class RunnerTest extends AbstractTestNGCucumberTests {


	public static WebDriver Driver = null;
	//public static  RemoteWebDriver Driver = null;


	@Before
	public static void SetUp() throws InterruptedException, MalformedURLException {
	//	if (browser=="FIREFOX") {
			WebDriverManager.firefoxdriver().setup();
			Driver= new FirefoxDriver();
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("browser.privatebrowsing.autostart", true);
			Driver.manage().window().maximize();
			Driver.get("https://subscribe.stctv.com/sa-en");
	//	}


		/*
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        Driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
        Driver.get("https://subscribe.stctv.com/sa-en");
		 */
	}
}


