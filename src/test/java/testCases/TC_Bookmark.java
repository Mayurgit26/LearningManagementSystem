package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.Bookmark;
import pageObjects.Feedback;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;

public class TC_Bookmark extends BaseClass{
	

	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	SoftAssert soft=new SoftAssert();
	
  @Test
  public void bookmark_TC_01() {
	  
	    test = report.createTest("Bookmark Test Case 1");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		Bookmark bm=new Bookmark(driver);
		
		bm.clicklogo();
		bm.clickBookmarkLogo();
		bm.clickBookmarkPage();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.switchTo().alert().accept();
		bm.clickBookmarkLogo();
		bm.clickSeeMyBookmarks();
		String addedBookmarks=bm.seeBookMarks();
		
		soft.assertEquals(addedBookmarks, "My bookmarks");
		soft.assertAll();
		test.log(Status.PASS, "Test Case passed as per expected result");
	  
  }
  
  @Test
  public void bookmark_TC_02() {
	    test = report.createTest("Bookmark Test Case 2");
	  
	    Bookmark bm=new Bookmark(driver);
		
		bm.checkURL();
		String checkTitle=driver.getTitle();
		System.out.println(checkTitle);
		soft.assertEquals(checkTitle, "HCL TSS: Edit profile");
		soft.assertAll();
		test.log(Status.PASS, "Test Case passed as per expected result");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	    reporter = new ExtentHtmlReporter("./test-output/Bookmark.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("SampleReport");
		reporter.config().setReportName("Bookmark Module Report");
		report = new ExtentReports();
		report.attachReporter(reporter);
  }

  @AfterMethod
  public void afterMethod() {
	    report.flush();
  }

}
