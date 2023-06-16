package pages;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SubscribtionPage extends Base {

	WebDriver driver=null;
	@FindBy(xpath="//div[@class='package-wrapper sa']//div[@class='package']")
	WebElement  sa_packages; 
	@FindBy(xpath="//div[@class='package-wrapper kw']//div[@class='package']")
	WebElement  kw_packages; 
	@FindBy(xpath="//div[@class='package-wrapper bh']//div[@class='package']")
	WebElement  bh_packages; 
	

	@FindBy(xpath="(//div[@class='plan-names'])[1]/div/strong") List<WebElement> sa_type;
	@FindBy(xpath="(//div[@class='plan-names'])[2]/div/div/b") List<WebElement> sa_Price;
	@FindBy(xpath="(//div[@class='plan-names'])[2]/div/div/i") List<WebElement> sa_Currency;

    ArrayList<String> Actual_SA_Type = new ArrayList<String>();
    ArrayList<String> Actual_SA_Price = new ArrayList<String>();
    ArrayList<String> Actual_SA_Currency= new ArrayList<String>();

	public SubscribtionPage(WebDriver driver) {
		super(driver);	
	}



	public void GetSA()   {
		implicitlyWait(1000);
		for (int i = 0; i < sa_type.size(); i++) {
		    String Type = sa_type.get(i).getText();
		    System.out.println(Type);
		    Actual_SA_Type.add(Type);

		    String Price = sa_Price.get(i).getText();
		    System.out.println(Price);
		    Actual_SA_Price.add(Price);
		    
		    String Currency = sa_Currency.get(i).getText();
		    System.out.println(Currency);
		    Actual_SA_Currency.add(Currency);
		
		
		    
		    
		}
		
	}



}
