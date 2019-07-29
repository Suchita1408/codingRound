package codoingRound;

import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.TestBase;
import com.cleartrip.packages.FlightBookingPage;

public class FlightBookingTest extends TestBase {

	FlightBookingPage flightbooking;
 
	public FlightBookingTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp()
	{
		setDriverPath();
		flightbooking =new FlightBookingPage();
		
	}
	

	@AfterMethod
    public void tearDown(){
        driver.quit();
    }
	
	
	@Test
	public void testThatResultsAppearForAOneWayJourney() 
	{
	
		flightbooking.flightBooking();
		//Assert.assertEquals(flightbooking.enterValueInTextBox(flightbooking.txtFrom, prop.getProperty("From")), true);
		//Assert.assertEquals(flightbooking.enterValueInTextBox(flightbooking.txtTo, prop.getProperty("To")), true);
	}
}
