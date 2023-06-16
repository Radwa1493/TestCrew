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


	@FindBy(xpath="(//div[@class='plan-names'])[1]/div/strong") List<WebElement> element_type;
	@FindBy(xpath="(//div[@class='plan-names'])[2]/div/div/b") List<WebElement> element_Price;
	@FindBy(xpath="(//div[@class='plan-names'])[2]/div/div/i") List<WebElement> element_Currency;

	ArrayList<String> Actual_Info = new ArrayList<String>();
	// ArrayList<String> Actual_Kuwait = new ArrayList<String>();
	//  ArrayList<String> Actual_Baharin= new ArrayList<String>();

	ArrayList<String> Expected_SA = new ArrayList<String>() {{
		add("apple");
		add("banana");
		add("orange");
	}};
	ArrayList<String> Expected_Kuwait = new ArrayList<String>() {{
		add("apple");
		add("banana");
		add("orange");
	}};
	ArrayList<String> Expected_Baharin = new ArrayList<String>() {{
		add("apple");
		add("banana");
		add("orange");
	}};


	public SubscribtionPage(WebDriver driver) {
		super(driver);	
	}



	public void GetSubscrition_data()   {
		implicitlyWait(1000);
		for (int i = 0; i < element_type.size(); i++) {
			String Type = element_type.get(i).getText();
			System.out.println(Type);
			Actual_Info.add(Type);

			String Price = element_Price.get(i).getText();
			System.out.println(Price);
			Actual_Info.add(Price);

			String Currency = element_Currency.get(i).getText();
			System.out.println(Currency);
			Actual_Info.add(Currency);
		}

	}

	public boolean   check_Subscribtion(String c)   {

		if (c.equals("SA")) {
			System.out.println("Subscription Actual Data "+ Actual_Info);
			System.out.println("Subscription Expected Data "+ Expected_SA);

			if (Expected_SA.equals(Actual_Info)) {
			
				System.out.println("Subscription Data for SA is correct");
				return true;
	
			} else {
				System.out.println("Subscription Data for SA no correct");
	
				return false;
			}
			}
		else if (c.equals("Kuwait")) {
			System.out.println("Subscription Actual Data "+ Actual_Info);
			System.out.println("Subscription Expected Data "+ Expected_Kuwait);

			if (Expected_Kuwait.equals(Actual_Info)) {
				System.out.println("Subscription Data for Kuwait is correct");
				return true;
	
			} else {
				System.out.println("Subscription Data for Kuwait no correct");
	
				return false;
			}
		}
		
		else if (c.equals("Baharin")) {
			System.out.println("Subscription Actual Data "+ Actual_Info);
			System.out.println("Subscription Expected Data "+ Expected_Baharin);

			if (Expected_Baharin.equals(Actual_Info)) {
				System.out.println("Subscription Data for Baharin is correct");
				return true;
	
			} else {
				System.out.println("Subscription Data for Baharin no correct");
	
				return false;
			}
		}
		System.out.println("Subscription Data no compared correctly");
	
		Actual_Info.clear();

		return false;



	}

}
