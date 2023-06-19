package pages;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.readExcel;


public class SubscribtionPage extends Base  {

	WebDriver driver;
	@FindBy(xpath="//div[@class='package-wrapper sa']//div[@class='package']")
	WebElement  sa_packages; 
	@FindBy(xpath="//div[@class='package-wrapper kw']//div[@class='package']")
	WebElement  kw_packages; 
	@FindBy(xpath="//div[@class='package-wrapper bh']//div[@class='package']")
	WebElement  bh_packages; 

	readExcel excel = new readExcel();

	String Type = null;
	String Price = null;
	String Currency = null;

	ArrayList<String> Actual_Type = new ArrayList<String>();
	ArrayList<String> Actual_Price = new ArrayList<String>();
	ArrayList<String> Actual_Currency= new ArrayList<String>();


	public SubscribtionPage(WebDriver Driver){
		this.driver = Driver;

	}


	public void GetSubscrition_data() throws IOException   {

		List<WebElement> element_type  = driver.findElements(By.xpath("(//div[@class='plan-names'])[1]/div/strong"));
		List<WebElement> element_Price  = driver.findElements(By.xpath("(//div[@class='price'])/b"));
		List<WebElement> element_Currency  = driver.findElements(By.xpath("(//div[@class='price'])/i"));

		for (int i = 0; i < element_type.size(); i++) {
			Type = element_type.get(i).getText();
			Actual_Type.add(Type);

			Price = element_Price.get(i).getText();
			Actual_Price.add(Price);

			Currency = element_Currency.get(i).getText();
			Actual_Currency.add(Currency);

		}



	}
	int sheet = 0;
	public boolean   check_Subscribtion(String c) throws IOException   {
		if (c.equals("KW")) {sheet=1;} 
		else if (c.equals("BH")) {sheet=2;} 
		System.out.println("Actual Type"+Actual_Type);
		System.out.println("Actual Currency"+Actual_Currency);
		System.out.println("Actual Price"+excel.convert(Actual_Price));
		System.out.println("Expected  Price"+excel.readColumnFromExcel("TestDate.xlsx", sheet, 1));

		if (

				(excel.readColumnFromExcel("TestDate.xlsx", sheet, 0).equals(Actual_Type))
				&&

				(excel.readColumnFromExcel("TestDate.xlsx", sheet, 2).equals(Actual_Currency))

				&&
				(excel.convert(excel.readColumnFromExcel("TestDate.xlsx", sheet, 1)).equals(excel.convert(Actual_Price))	)
				)	 {

			System.out.println("Subscription Type Data for "+c+" is correct");
			Actual_Type.clear();
			Actual_Currency.clear();
			Actual_Price.clear();

			return true;

		} else {
			System.out.println("Subscription Type Data for "+c+" not correct");
			Actual_Type.clear();
			Actual_Currency.clear();
			Actual_Price.clear();

			return false;
		}



	}
	public void   OpenKuwait()   {
		WebElement country_btn  = driver.findElement(By.id("country-btn"));
		WebElement kw  = driver.findElement(By.id("kw"));
		WebElement bh  = driver.findElement(By.id("bh"));

		clickButton(country_btn);
		clickButton(kw);
		implicitlyWait(1000,driver);


	}
	public void   Openbahrin()   {
		WebElement country_btn  = driver.findElement(By.id("country-btn"));
		WebElement bh  = driver.findElement(By.id("bh"));

		clickButton(country_btn);
		clickButton(bh);
		implicitlyWait(1000,driver);


	}



}
