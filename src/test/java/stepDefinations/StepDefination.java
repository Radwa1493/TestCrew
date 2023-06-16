package stepDefinations;

import io.cucumber.java.en.Given;
import pages.Base;
import pages.SubscribtionPage;

/**
 * Unit test for simple App.
 */
public class StepDefination 
{
	SubscribtionPage SubscribtionP   = new SubscribtionPage(Hooks.Driver);
	Base base = new Base(Hooks.Driver);

    	@Given("Navigate to URL")
    	public void navigate_to_url()  {

    		System.out.println("ssss");
    		SubscribtionP.GetSA();
    		
    	}






}
