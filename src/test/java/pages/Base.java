package pages;

import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	WebDriver driver= null;
	Random rand = new Random();
	public Select select = null;
	public Actions action = null;

	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String SysDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return formatter.format(date);
		
	}
	
	public String SysDatewithdays(int days) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");            
    	Calendar c = Calendar.getInstance();        
    	c.add(Calendar.DATE, days);  // number of days to add can be negative     
    	String date = (String)(formattedDate.format(c.getTime()));
    	return date;
	}
	
	public void MouseHover(WebElement element) {
		// TODO Auto-generated method stub
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void MouseClick(WebElement element) {

		action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public int GetNumberOfWebElement(By elementLocation) {
		List<WebElement> NumWebelemnt = driver.findElements(elementLocation);
		return NumWebelemnt.size();
	}

	protected void clickButton(WebElement button) {
		button.click();
	}

	protected void setTextElementText(WebElement txtElement, String value) {
		txtElement.sendKeys(value);
	}

	public void scrollToButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}
	public void scrollToveryButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10450)", "");
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	public void scrollToElement(WebElement element) {
		//	JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void clearText(WebElement element) {
		element.clear();
	}

	public String GetText(WebElement element) {
		return element.getText();
	}

	public String generateID() {
		Random rnd = new Random();
		String x = "784";

		char[] digits = new char[12];
		digits[0] = (char) (rnd.nextInt(9) + '1');

		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(10) + '0');
		}

		String str = new String(digits);
		str = x + str;

		return str;
	}

	public String getString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public void refreshPage() throws InterruptedException {
		driver.navigate().refresh();
	}
	public boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	public String reverseIt(String source) {
		// not used in the framework 

		System.out.println("base " + source);
		byte[] strAsByteArray = source.getBytes();
		byte[] result = new byte[strAsByteArray.length];
		for (int i = 0; i < strAsByteArray.length; i++)
			result[i] = strAsByteArray[strAsByteArray.length - i - 1];
		return new String(result);
	}
	public String DateFormate(String source) throws ParseException {
		//change date format from "yyyy/MM/dd" to "dd/MM/yyyy"
		
		final String OLD_FORMAT = "yyyy/MM/dd";
		final String NEW_FORMAT = "dd/MM/yyyy";
		// August 12, 2010
		String oldDateString = source;
		String newDateString;
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = sdf.parse(oldDateString);
		sdf.applyPattern(NEW_FORMAT);
		return newDateString = sdf.format(d);
	}
	public String DateFormate2(String source) throws ParseException {
		//change date format from "yyyy-MM-dd" to "dd/MM/yyyy"
		
		String oldFormatData = source;
    	String newFormatData;

    	SimpleDateFormat old = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat new1 = new SimpleDateFormat("dd/MM/yyyy");
    	Date old1 = old.parse(oldFormatData);
    	newFormatData = new1.format(old1);
    	return newFormatData;
	}
	
	
	
	public String GetTodayDate()  {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);  
	}
	public String AddtoTodayDate(int days)  {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, days); // Adding  days
		String output = sdf.format(c.getTime());		
		return output;

	}
	public String dischargeDatetValue() {
		// not used in the framework 
		// return
		// jse.executeScript("document.querySelector(\"[formControlName='dischargeDate']
		// input\").value").toString();
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		String text = js.
				executeScript("return document.getElementById('datepicker-2-input').textContent" ).toString();
		System.out.println("Text written on the login button is- " +
				text); 
		return text;
		// return
		// jse.executeScript("document.querySelector(\"[formControlName='dischargeDate']
		// input\").innerText").toString();
	}
	public void MousClick(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public void StartNewTab() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
	}
	public void MoveToTab(int tab) {
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 

		driver.switchTo().window(availableWindows.get(tab)); 
	}
	public void GoURL(String URl) {
		driver.navigate().to(URl);
	}
	public void implicitlyWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS) ;	}
	public void refresh() {
		driver.navigate().refresh();	}

	public void ExplectWait(int sec, By Element) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));		
	}
	public void ExplectWaitClicableBy(int sec, By Element) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.elementToBeClickable(Element));		
	}
	
	public void ExplectWaitvisibilityBy(int sec, By Element) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Element));		
	}
	
	

	public void ExplectWaitClicable(int sec, WebElement Element)
	// don't use this one 
	{
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.elementToBeClickable(Element));		
	}
	public String getfristwindow() {
		String winHandleBefore = null;
		winHandleBefore = driver.getWindowHandle();
		//	System.out.println(winHandleBefore);
		return	 winHandleBefore ;

	}
	public void switchtoSecondwindow() {
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle); }
		//	System.out.println(driver.getTitle());
	}
	public void switchtofristwindow(String winHandleBefore) {
		Set<String> AllWindows =driver.getWindowHandles();
		driver.switchTo().window(winHandleBefore);
		//	System.out.println(driver.getTitle());

	}
	public void Closewindow() {
		driver.close();
	}
	public int GetRandFromList(List<WebElement> List) {
		List.remove(0);
		int rand_int = rand.nextInt(List.size());
		return rand_int-1;
	}

}