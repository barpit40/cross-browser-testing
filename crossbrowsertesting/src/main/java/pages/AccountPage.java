package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	private WebDriver driver;
	
	@FindBy(css = "div#center_column span")
	private List<WebElement> accounts;
	
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return accounts.size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountsList= new ArrayList<>();
		for(WebElement e:accounts) {
			accountsList.add(e.getText());
		}
		return accountsList;
	}

}
