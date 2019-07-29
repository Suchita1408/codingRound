package codoingRound;

import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.TestBase;

import com.cleartrip.packages.SignInPage;

public class SignInTest extends TestBase {
	
	SignInPage signin;
	
	public SignInTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp()
	{
		setDriverPath();
		signin = new SignInPage();
	}
	
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() 
	{
		signin.signIn();
		
	}
	
	@AfterMethod
    public void tearDown(){
        driver.quit();
    }
	
	

}
