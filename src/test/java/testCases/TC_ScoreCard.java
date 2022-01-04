package testCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.LoginPage;
import pageObjects.ScoreCard;
import utilities.ScreenshotCustom;

public class TC_ScoreCard extends BaseClass{
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Test
	public void scoreCard_TC_01() {
		
		test = report.createTest("Scorecard_TC_01");
		SoftAssert soft=new SoftAssert();	
		LoginPage lp=new LoginPage(driver);
		lp.enterName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		
		ScoreCard sc=new ScoreCard(driver);
		sc.clickScoreCard();
		String details=sc.getScoreCard();
		System.out.println(details);
		
		if(details.equalsIgnoreCase("My Performance - GIC_OND21_TEST_JAVA_SELENIUM_1")) {
			soft.assertTrue(true);
			soft.assertAll();		
		}
		else {
			soft.assertTrue(false);
			soft.assertAll();	
		}
	

}
	@BeforeMethod
	public void beforeMethod() {
		reporter = new ExtentHtmlReporter("./test-output/ScoreCard.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("SampleReport");
		reporter.config().setReportName("Score Card Module Report");
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	@AfterMethod
	public void tearDownAfterClass(ITestResult result) throws Exception {
	if(result.getStatus()==ITestResult.FAILURE)
	{
	test.log(Status.FAIL, "Test Case Failed is" +result.getName());
	test.log(Status.FAIL, "TestCase Failed due to"+result.getThrowable());
	String ScrnShot = ScreenshotCustom.capture(result.getName());
	test.addScreenCaptureFromPath(ScrnShot);
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, "Test Case is Skipped"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, "TestCase is Passed" +result.getName());
	}
	report.flush();
	}
	
	

}