package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bookmark {
	
	public WebDriver driver;
	
	public Bookmark(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement logo; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle fi-bookmark']")
	WebElement bookmarklogo;

	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/form[1]/a[1]")
	WebElement bookmarkpage;
	
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[2]/a[1]")
	WebElement bookmarks;
	
	@FindBy(xpath="//h2[contains(text(),'My bookmarks')]")
	WebElement seeBookmarks;
	
	@FindBy(xpath="//a[contains(text(),'HCL TSS: Edit profile')]")
	WebElement clickURL;
	
	public void clicklogo() {
		logo.click();
	}
	
	public void clickBookmarkLogo() {
		bookmarklogo.click();
	}
	
	public void clickBookmarkPage() {
		bookmarkpage.click();
	}
	
	public void clickSeeMyBookmarks() {
		bookmarks.click();
	}
	
	public String seeBookMarks() {
		return seeBookmarks.getText();
	}
	
	public void checkURL() {
		clickURL.click();
	}
	
}
