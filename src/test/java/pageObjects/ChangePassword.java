package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
	public WebDriver driver;
	public ChangePassword (WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/aside[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[1]/p[1]/span[1]")
	WebElement userAccount;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/aside[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[2]/p[1]/a[1]")
	WebElement changePassword;
	
	@FindBy(id="id_password")
	WebElement currPswd;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[1]/div[4]/div[2]/input[1]")
	WebElement newPwd;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[1]/div[5]/div[2]/input[1]")
	WebElement reNewPsd;
	
	@FindBy(xpath="//input[@id='id_submitbutton']")
	WebElement savePassword;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[1]/div[4]/div[2]/span[1]")
	WebElement errormsg;
	
	public void clickUserAccount() {
	    userAccount.click();
	    }
	
	public void clickChangePasword() {
		changePassword.click();
		}
	
	public void enterCurrentPassword(String currpwd) {
		currPswd.clear();
		currPswd.sendKeys(currpwd);
		}
	
	public void enterNewPassword(String newpwd) {
		newPwd.clear();
		newPwd.sendKeys(newpwd);
		}
	
	public void ReNewPassword(String reNewpwd) {
		reNewPsd.clear();
		reNewPsd.sendKeys(reNewpwd);
		}
	
	public void clickSavePassword() {
		savePassword.click();
		}
	
	public String getErrorMessage() {
		String msg=errormsg.getText();
		return msg;
	}

}
	
	

