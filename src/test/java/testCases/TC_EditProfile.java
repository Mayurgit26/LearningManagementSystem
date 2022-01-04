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

import pageObjects.EditProfile;
import pageObjects.LoginPage;
import utilities.ScreenshotCustom;

public class TC_EditProfile extends BaseClass{
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	SoftAssert soft=new SoftAssert();	
	
	@Test
	public void editProfile_TC_01() {
		
		test = report.createTest("Edit_Profile TC_1");

		LoginPage lp=new LoginPage(driver);
		lp.enterName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		
		EditProfile ep=new EditProfile(driver);
		ep.clickDropDownUserName();
		ep.clickMyProfile();
		ep.clickEditProfile();
		ep.enterFirstName("Mona");
		ep.enterLastName("Basra");
		ep.clickUpdateProfile();
		
		Boolean message=driver.getPageSource().contains("Edit Profile Sucessfully");
		if(message==true) {
			soft.assertTrue(true);
			soft.assertAll();	
		}
		else
		{
			soft.assertTrue(false);
			soft.assertAll();
		}
		
		}
	
	@Test
	public void editProfile_TC_02() {
		
		test = report.createTest("Edit_Profile_TC_2");
		
		
		EditProfile ep=new EditProfile(driver);
		ep.clickEditProfile();
		ep.enterDOB("Mon@");
		ep.clickUpdateProfile();
		
		Boolean message=driver.getPageSource().contains("Enter DOB in correct format");
		if(message==true) {
			soft.assertTrue(true);
			soft.assertAll();	
		}
		else
		{
			soft.assertTrue(false);
			soft.assertAll();
		}
		
		}
		
	
	@BeforeMethod
	public void beforeMethod() {
			reporter = new ExtentHtmlReporter("./test-output/Edit Profile.html");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setDocumentTitle("SampleReport");
			reporter.config().setReportName("Edit Profile Module Report");
			reporter.setAppendExisting(true);
			report = new ExtentReports();
			report.attachReporter(reporter);
		}
		
	@AfterMethod
	public void tearDownAfterClass(ITestResult result) throws Exception {
	if(result.getStatus()==ITestResult.FAILURE)
	{
	test.log(Status.FAIL, "Test Case Failed is " +result.getName());
	test.log(Status.FAIL, "TestCase Failed due to "+result.getThrowable());
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

