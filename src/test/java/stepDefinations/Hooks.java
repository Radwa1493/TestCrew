
package stepDefinations;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	//public static WebDriver Driver = null;
	public static  RemoteWebDriver Driver = null;


	@Before
	public static void SetUp() throws InterruptedException, MalformedURLException {
/*
    	WebDriverManager.firefoxdriver().setup();
    	Driver= new FirefoxDriver();
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability("browser.privatebrowsing.autostart", true);
    	Driver.manage().window().maximize();
    	Driver.get("https://subscribe.stctv.com/sa-en");
    	*/
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        Driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
        Driver.get("https://subscribe.stctv.com/sa-en");

	}

	
}
