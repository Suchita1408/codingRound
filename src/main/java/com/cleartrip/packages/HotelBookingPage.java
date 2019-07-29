package com.cleartrip.packages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.base.TestBase;

public class HotelBookingPage extends TestBase {

	//Page Factory
	@FindBy(xpath="//a[@href='/hotels' and @title='Find hotels in destinations around the world']")
	public WebElement lnkHotel;
	
	@FindBy(xpath="//input[@id='Tags']")
	public WebElement txtWhere;
	
	
	@FindBy(xpath="//select[@id='travellersOnhome']")
	public WebElement selectTravellers;
	
	@FindBy(xpath="//input[@id='SearchHotelsButton']")
	public WebElement btnSearch;
	
	
	@FindBy(xpath="//a[contains(text(),'Indiranagar, Bangalore, Karnataka, India')]")
	public WebElement lstInddiranagar;
	
	
	//Initializing the Page Objects
	public HotelBookingPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void hotelBooking()
	{
		lnkHotel.click();
		txtWhere.clear();
		txtWhere.sendKeys(prop.getProperty("HotelLocation"));
		selectLocation();
		selectValueFromDropDown();
		btnSearch.click();
	}
	
	public void selectLocation()
	{
		txtWhere.sendKeys(prop.getProperty("HotelLocation"));
		List<WebElement> list = driver.findElements(By.xpath("//a[contains(text(),'Indiranagar, Bangalore, Karnataka, India')]"));
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText().contains("Indiranagar"));
			list.get(i).click();
			break;
			
		}
	}
	
	
	public boolean selectValueFromDropDown()
	{
		try{
			Select select = new Select(selectTravellers);
			select.selectByVisibleText("1 room, 2 adults");
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;	
			
		}
	
	}
	
}



















