package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testCases.BaseClass;

public class ScreenshotCustom extends BaseClass{
	 
	public static String capture(String ScrShtName)
	{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File Screenshot = ts.getScreenshotAs(OutputType.FILE);
	String dest = System.getProperty("user.dir")+"/ErrorScreenShot/"+ScrShtName+".png";
	try {
	File dest1= new File(dest);
	FileUtils.copyFile(Screenshot, dest1);
	} catch (IOException e) {
	e.printStackTrace();
	}
	return dest;
	}
}
