package com.test.crossbrowsertesting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.LoginPage;

public class AccountPageTest {
	
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected WebDriver driver;

	public AccountPageTest() {
		
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void initTests(String browser) {
		System.out.println("initTests - Thread ID : "+ Thread.currentThread().getId());
		driver=BrowserFactory.createInstance(browser);
		DriverFactory.getInstatnce().setDriver(driver);
		driver=DriverFactory.getInstatnce().getDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage=new LoginPage(driver);
		
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void verifyPageTitle(String uname,String passw) {
		System.out.println("verifyPageTitle - Thread ID : "+ Thread.currentThread().getId());
		accountPage= loginPage.doLogin(uname, passw);
		Assert.assertEquals(accountPage.getPageTitle(),"My account - My Store");
	}
	
	
	@Test(dataProvider ="itemDataProvider")
	public void verifyItemCounts(List<String> data ) {
		System.out.println("verifyItemCounts - Thread ID : "+ Thread.currentThread().getId());
	   List<String> pagedata= loginPage.doLogin("polo123@gmail.com","Test20@Test09").getAccountsSectionList();
	  // System.out.println(pagedata);
	   Assert.assertTrue(pagedata.size()==data.size());
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println(" tearDown - Thread ID : "+ Thread.currentThread().getId());
		driver.close();}
	
	@DataProvider
	public Object[][] loginDataProvider()
	{
		System.out.println("loginDataProvider - Thread ID : "+ Thread.currentThread().getId());
		Object[][] loginData= {{"polo123@gmail.com","Test20@Test09"}};
				
		return loginData;
	}
	
	@DataProvider
	public Object[] itemDataProvider()
	{
		System.out.println("itemDataProvider - Thread ID : "+ Thread.currentThread().getId());
		List<String> items= new ArrayList<>();
		items.add("ORDER HISTORY AND DETAILS");
		items.add("MY CREDIT SLIPS");
		items.add("MY ADDRESSES");
		items.add("MY PERSONAL INFORMATION");
		items.add("MY WISHLISTS");
		items.add("Home");
	
		Object[]  data= new Object[1]; 
		data[0]=items;
		return data;
	}

}
