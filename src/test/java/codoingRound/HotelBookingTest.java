package codoingRound;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cleartrip.base.TestBase;
import com.cleartrip.packages.HotelBookingPage;

public class HotelBookingTest extends TestBase{
	
	HotelBookingPage hotelbooking;
	
	
	public HotelBookingTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp()
	{
		setDriverPath();
		hotelbooking =new HotelBookingPage();
		
	}
	
	@Test
    public void shouldBeAbleToSearchForHotels() 
	{
	
		hotelbooking.hotelBooking();
	}
	


	@AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
