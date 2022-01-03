package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Feedback {
	
	public WebDriver driver;

	public Feedback(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Feedback']")
	WebElement feedback; 
	
	@FindBy(id="crs")
	WebElement course;
	
	@FindBy(xpath="//select[@id='wks']")
	WebElement weekNo;
	
	@FindBy(id="trn")
	WebElement trainer;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[5]")
	WebElement tRating1;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[10]")
	WebElement tRating2;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[15]")
	WebElement tRating3;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[20]")
	WebElement tRating4;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[25]")
	WebElement tRating5;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[30]")
	WebElement tRating6;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[35]")
	WebElement tRating7;
	
	@FindBy(id="tc")
	WebElement comment1;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[39]")
	WebElement cRating1;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[44]")
	WebElement cRating2;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[49]")
	WebElement cRating3;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[54]")
	WebElement cRating4;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[59]")
	WebElement cRating5;
	
	@FindBy(id="cc")
	WebElement comment2;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[64]")
	WebElement lRating1;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[69]")
	WebElement lRating2;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/input[74]")
	WebElement lRating3;
	
	@FindBy(id="lc")
	WebElement comment3;
	
	@FindBy(id="id_submitbutton")
	WebElement btnSubmit;
	
	public void clickFeedback() {
		feedback.click();
	}
	
	public void selectCourse() {
		Select s1=new Select(course);
		s1.selectByVisibleText("Testing");
	}
	
	public void selectWeekNo() {
		Select s2=new Select(weekNo);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);	
		s2.selectByVisibleText("Week2");
	}
	
	public void selectTrainer() {
		Select s3=new Select(trainer);
		s3.selectByVisibleText("Suvitha");
	}
	
	public void giveTrainerRatings() {
		tRating1.click();
		tRating2.click();
		tRating3.click();
		tRating4.click();
		tRating5.click();
		tRating6.click();
		tRating7.click();
	}
	
	public void givecomment1() {
		comment1.sendKeys("Excellent");
	}
	
	public void giveContentRatings() {
		cRating1.click();
		cRating2.click();
		cRating3.click();
		cRating4.click();
		cRating5.click();
	}
	
	public void givecomment2() {
		comment2.sendKeys("Good");
	}
	
	public void giveSoftwareRatings() {
		lRating1.click();
		lRating2.click();
		lRating3.click();
	}
	
	public void givecomment3() {
		comment3.sendKeys("Good");
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	

}
