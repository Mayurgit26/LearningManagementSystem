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

import pageObjects.ChangePassword;
import pageObjects.Dashboard;
import pageObjects.EditProfile;
import pageObjects.LoginPage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.ScreenshotCustom;

public class TC_ChangePassword extends BaseClass {
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Test
	public void changePassword_TC_02() throws Exception {
		ExcelUtils.setExcelFile(Constant.filename, "Change Password");
//		test = report.createTest("Change Password Test Case ");
		SoftAssert soft=new SoftAssert();	
		LoginPage lp=new LoginPage(driver);
		lp.enterName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		
		EditProfile ep=new EditProfile(driver);
		ep.clickDropDownUserName();
		ep.clickMyProfile();
		
		ChangePassword cp=new ChangePassword(driver);
		cp.clickUserAccount();
		cp.clickChangePasword();

for(int i=1;i<ExcelUtils.getRowCount();i++)
{
	test = report.createTest("Change Password Test Case "+ i);
	cp.enterCurrentPassword(ExcelUtils.getCellData(i, 0));
	cp.enterNewPassword(ExcelUtils.getCellData(i, 1));
	cp.ReNewPassword(ExcelUtils.getCellData(i, 2));
	cp.clickSavePassword();
	String errorMessage=cp.getErrorMessage();
	
if(errorMessage.equalsIgnoreCase("These passwords do not match"))
{	
	ExcelUtils.setCellData("match not found",i ,4 );
}

else
{
	ExcelUtils.setCellData("criteria not matched",i ,4 );
	
}
String actualResult=ExcelUtils.getCellData(i, 4);
String expectedResult=ExcelUtils.getCellData(i, 3);
soft.assertEquals(actualResult, expectedResult);
}
    soft.assertAll();
}
		
	@BeforeMethod
	public void beforeMethod() {
			reporter = new ExtentHtmlReporter("./test-output/Change Password.html");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setDocumentTitle("SampleReport");
			reporter.config().setReportName("Change Password Module Report with Boundary Value Analysis");
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

