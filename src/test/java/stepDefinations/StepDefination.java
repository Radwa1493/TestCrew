package stepDefinations;

import java.io.IOException;

import TestRunner.RunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SubscribtionPage;

/**
 * Unit test for simple App.
 */
public class StepDefination 
{
	SubscribtionPage SubscribtionP   = new SubscribtionPage(RunnerTest.Driver);


	@Then("Check Subscrition SA data")
	public void Check_SA() throws IOException  {
	//	SubscribtionP.check_Subscribtion("SA");
		SubscribtionP.GetSubscrition_data();

		RunnerTest.softAssertion.assertTrue(SubscribtionP.check_Subscribtion("SA"));

	}
	@Then("Check Subscrition KW data")
	public void Check_KW() throws IOException  {
		SubscribtionP.OpenKuwait();
		SubscribtionP.GetSubscrition_data();

		RunnerTest.softAssertion.assertTrue(SubscribtionP.check_Subscribtion("KW"));

	}

	@Then("Check Subscrition BH data")
	public void Check_BH() throws IOException  {
		SubscribtionP.Openbahrin();
		SubscribtionP.GetSubscrition_data();

		RunnerTest.softAssertion.assertTrue(SubscribtionP.check_Subscribtion("BH"));

	}



}
