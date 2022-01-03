package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.LoginPage;
import pageObjects.ScoreCard;

public class TC_ScoreCard extends BaseClass{
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Test
	public void scoreCard_TC_01() {
		
//		test = report.createTest("Score Card Test Case");
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
}
