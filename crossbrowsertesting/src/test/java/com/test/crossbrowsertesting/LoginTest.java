package com.test.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.LoginPage;

public class LoginTest {

	private LoginPage loginPage;
	WebDriver driver;
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
		
	}
	
	
    @Parameters({"browser"})
	@BeforeMethod
	public void initalize(String browser) {
		System.out.println("initalize - Thread ID : "+ Thread.currentThread().getId());
		driver=BrowserFactory.createInstance(browser);
		DriverFactory.getInstatnce().setDriver(driver);
		driver=DriverFactory.getInstatnce().getDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage=new LoginPage(driver);
	}
	
	@Test
	public void verify_page_title() {
		System.out.println("verify_page_title - Thread ID : "+ Thread.currentThread().getId());
      		String title= driver.getTitle();
      		Assert.assertTrue(title.contains("Login - My Store"));
	}
	
	@Test
	public void forgetPasswordLinkShouldDisplay()
	{
		System.out.println("forgetPasswordLinkShouldDisplay - Thread ID : "+ Thread.currentThread().getId());
	  Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
		
	}	
	
	@Test
	public void loginToAccount()
	{
		System.out.println("loginToAccount - Thread ID : "+ Thread.currentThread().getId());
	 AccountPage accountPage=	 loginPage.doLogin("polo123@gmail.com", "Test20@Test09");
	 Assert.assertEquals(accountPage.getPageTitle(), "My account - My Store");
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("teardown - Thread ID : "+ Thread.currentThread().getId());
		driver.close();
		DriverFactory.getInstatnce().removeDriver();
	}
}
