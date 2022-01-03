package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginbtn")
	WebElement loginbtn;
	
	public void enterName(String name) {
		userName.click();
		userName.sendKeys(name);
	}
	
	public void enterPassword(String passwrd) {
		password.click();
		password.sendKeys(passwrd);
	}
	
	public void clickLogin() {
		loginbtn.click();
	}
	
}
