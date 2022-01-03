package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
public WebDriver driver;
public Dashboard(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
WebElement welcome;

@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]")
WebElement logout;

public void clickLogout(){
welcome.click();
driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
logout.click();
}
}
