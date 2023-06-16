package TestRunner;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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


//	public static WebDriver Driver = null;
	public static  RemoteWebDriver Driver = null;

    @Parameters({ "browser" })
	@Before
	public static void SetUp(String browser) throws InterruptedException, MalformedURLException {
	 
		if (browser.equals("Firefox") ){
			
			WebDriverManager.firefoxdriver().setup();
			Driver= new FirefoxDriver();
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("browser.privatebrowsing.autostart", true);
		}
		else if (browser.equals("Chrome") ){
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			Driver = new ChromeDriver(options); 

		}
		
		else if (browser.equals("Edge") ){
			
		    // Download and setup Edge WebDriver
		    WebDriverManager.edgedriver().setup();
		    
		    // Create a new instance of EdgeDriver
		    Driver = new EdgeDriver();
		}
		
		else if (browser.equals("ChromeDocker") ){
			
		   	ChromeOptions options = new ChromeOptions();
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");

	        Driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		}
		
		Driver.manage().window().maximize(); 

		Driver.get("https://subscribe.stctv.com/sa-en");

	}
}


