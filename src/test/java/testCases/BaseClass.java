package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String baseURL="http://www.hcltss-lms.com/login/index.php";
	public String username="GIC1021031";
	public String password="P@ssw0rd1";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
