package com.cleartrip.packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.base.TestBase;

public class FlightBookingPage extends TestBase{
	
	//Page Factory
	
	@FindBy(xpath="//input[@id='OneWay']")
	public WebElement btnOneWay;
	

	@FindBy(xpath="//input[@id='FromTag']")
	public WebElement txtFrom;
	
	@FindBy(xpath="//ul[@id='ui-id-1']/li/a[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)')]")
	public WebElement valBangalore;
	

	@FindBy(xpath="//input[@id='ToTag']")
	public WebElement txtTo;
    
	@FindBy(xpath="//input[@id='DepartDate']")
	public WebElement txtDatePicker;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[7]//a[@class='ui-state-default ']")
	public WebElement txtDate;
	
	@FindBy(xpath="//input[@id='SearchBtn']")
	public WebElement btnSearch;
	
	
	//Initializing the Page Objects
	public FlightBookingPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void flightBooking()
	{
		btnOneWay.click();
		txtFrom.click();
		enterValueInTextBox(txtFrom, prop.getProperty("From"));
		enterValueInTextBox(txtTo, prop.getProperty("To"));
		txtDatePicker.click();
		selectDate();
		btnSearch.click();
	}
	
	public void selectDate()
	{
		Actions action = new Actions(driver);
		action.moveToElement(txtDate).build().perform();
		txtDate.click();
	}
	
	public boolean selectValueFromDropDown(WebElement element, String  value)
	{
		try{
			Select select = new Select(element);
			select.selectByVisibleText(value);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;	
			
		}
	
	}
	
	
	public boolean enterValueInTextBox(WebElement element, String text)
	{
		try{
			if(element.isEnabled()){
				element.sendKeys(text);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;	
			
		}
	}
	
}

