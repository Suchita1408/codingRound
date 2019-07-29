package com.cleartrip.packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.base.TestBase;

public class SignInPage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath="//a[@id='userAccountLink']")
	public WebElement yourTrip;
	
	@FindBy(xpath="//input[@id='SignIn']")
	public WebElement btnSignIn;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement txtPassword;
	

	@FindBy(xpath="//button[@id='signInButton']")
	public WebElement btnSignInToCleartrip;
	
	@FindBy(xpath="//div[@id='errors1']")
	public WebElement errorMessage;
	
	//Initializing the Page Objects
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void signIn()
	{
		yourTrip.click();
		btnSignIn.click();
		driver.switchTo().frame("modal_window");
		txtUsername.sendKeys(prop.getProperty("Username"));
		txtPassword.sendKeys(prop.getProperty("Password"));
		btnSignInToCleartrip.click();	
		String error = errorMessage.getText();
		System.out.println("The error message is : "+error);
	}
				
	}
	


