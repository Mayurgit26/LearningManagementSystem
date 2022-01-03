package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScoreCard {
	
	public WebDriver driver;
	
	public ScoreCard (WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Score Card']")
	WebElement scorecard;
	
	@FindBy(xpath="//h4[text()='My Performance - GIC_OND21_TEST_JAVA_SELENIUM_1']")
	WebElement detailscorecard;
	
	public void clickScoreCard() {
		scorecard.click();
	}
	
	public String getScoreCard() {
		return detailscorecard.getText();
	}
	

}
