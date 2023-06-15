package stepDefinations;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class StepDefination 
{
    private WebDriver driver;
    @Before
    public void shouldAnswerWithTrue() throws MalformedURLException {
    	WebDriverManager.firefoxdriver().setup();
    	driver= new FirefoxDriver();
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability("browser.privatebrowsing.autostart", true);
    	driver.manage().window().maximize();
    	driver.get("https://subscribe.stctv.com/");

    /*	
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
        driver.get("https://subscribe.stctv.com/sa-en");
   */
    
    }


    	@Given("Navigate to URL")
    	public void navigate_to_url() {

    		System.out.println("ssss");
    	}






}
