package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

private WebDriver driver;
	
	@FindBy(id = "email")
	private WebElement emailID;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement login;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	private WebElement forgetPassword;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() { return driver.getTitle();}
	
	public boolean isForgotPasswordLinkExist() {
	  return forgetPassword.isDisplayed();
	}
	
	public void enterUserName(String userName) {
		emailID.sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickonSignIn()
	{
		login.click();
	}
	
	public AccountPage doLogin(String uname, String pwd) {
		emailID.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
		
	  return  new AccountPage(driver);
	}

	
	

}
