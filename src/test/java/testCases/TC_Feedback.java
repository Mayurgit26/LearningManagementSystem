package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.Feedback;
import pageObjects.LoginPage;

public class TC_Feedback extends BaseClass{
	
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	SoftAssert soft=new SoftAssert();
	
	@Test
	public void feedback_TC_01() throws InterruptedException {
		test = report.createTest("Feedback_TC_01");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		Feedback fd=new Feedback(driver);
		
		fd.clickFeedback();
		fd.selectCourse();
		fd.selectTrainer();
		fd.givecomment3();
		
		fd.clickSubmit();
		
		String alertMsg=driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		
		
		soft.assertEquals(alertMsg, "Please fill all the fields which marked with red labels");
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		driver.switchTo().alert().accept();
		test.log(Status.PASS, "Test Case passed as per expected result");
		
	}
	
	@Test
	public void feedback_TC_02() throws InterruptedException {
		test = report.createTest("Feedback_TC_02");

		Feedback fd=new Feedback(driver);
		driver.navigate().refresh();
		fd.selectCourse();
		fd.selectWeekNo();
		fd.selectTrainer();
		fd.giveTrainerRatings();
		fd.givecomment1();
		fd.giveContentRatings();
		fd.givecomment2();
		fd.giveSoftwareRatings();
		fd.givecomment3();
		fd.clickSubmit();
		
		String title=driver.getTitle();
		
		soft.assertEquals(title, "My Dashboard");
		test.log(Status.PASS, "Test Case passed as per expected result");
	}
		
	@BeforeMethod
	public void beforeMethod() {
			reporter = new ExtentHtmlReporter("./test-output/Feedback.html");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setDocumentTitle("SampleReport");
			reporter.config().setReportName("Feedback Module Report");
			reporter.setAppendExisting(true);
			report = new ExtentReports();
			report.attachReporter(reporter);
		}
		
	@AfterMethod
	public void afterMethod() {
			report.flush();
		}

}
