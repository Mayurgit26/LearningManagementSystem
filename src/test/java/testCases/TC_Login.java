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

import pageObjects.Dashboard;
import pageObjects.LoginPage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.ScreenshotCustom;

public class TC_Login extends BaseClass {
	
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Test
	public void login_TC() throws Exception {
		ExcelUtils.setExcelFile(Constant.filename, "Login");
		SoftAssert soft=new SoftAssert();	
		LoginPage lp=new LoginPage(driver);
		Dashboard db=new Dashboard(driver);

	for(int i=1;i<ExcelUtils.getRowCount();i++)
	{
		test = report.createTest("Login Test Case "+ i);
		lp.enterName(ExcelUtils.getCellData(i, 0));
		lp.enterPassword(ExcelUtils.getCellData(i, 1));
		lp.clickLogin();
		String currURl= driver.getCurrentUrl();
		
	if(currURl.equalsIgnoreCase("http://www.hcltss-lms.com/learner-landing.php?tcode="+ExcelUtils.getCellData(i, 0)))
	{	
		db.clickLogout();
		ExcelUtils.setCellData("Successfully login",i ,3 );
	}
	
	else
	{
		ExcelUtils.setCellData("Remains in login page",i ,3 );
		
	}
	String actualResult=ExcelUtils.getCellData(i, 3);
	String expectedResult=ExcelUtils.getCellData(i, 2);
	soft.assertEquals(actualResult, expectedResult);
//	test.log(Status.PASS, "Test Case passed as per expected result");
	
	}
	    soft.assertAll();
	}
	
//	@Test(priority=2,enabled=true)
//	public void login_TC_002() {
//		
//    SoftAssert soft=new SoftAssert();	
//	LoginPage lp=new LoginPage(driver);
//	
//	test = report.createTest("Login Test Case ");
//	lp.enterName(username);
//	lp.enterPassword(password);
//	lp.clickLogin();
//	String txtWelcome=lp.checkWelcomeMsg();
//	System.out.println(txtWelcome);
//	
//	if(txtWelcome.equalsIgnoreCase("Hello ! Mona")) {
//		soft.assertTrue(true);	
//		test.log(Status.PASS, "Test Case passed as per expected result");
//	}
//	else
//	{
//		soft.assertTrue(false);	
//		test.log(Status.FAIL, "Test Case failed as per expected result");
//	}
//	    soft.assertAll();
//	}
	
	@BeforeMethod
	public void beforeMethod() {
		reporter = new ExtentHtmlReporter("./test-output/Login.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("SampleReport");
		reporter.config().setReportName("Login Module Report");
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
