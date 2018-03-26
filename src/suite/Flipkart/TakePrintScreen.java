/*
 This class is used to print the screen in local D:Drive
 * 
 * Navigate to 
 */
package suite.Flipkart;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author abongu
 *
 */
public class TakePrintScreen {

	/**
	 * @param args
	 */
	@Test
	public void test() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\abongu\\Downloads\\chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("D:\\screenshot.png"));

		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	driver.close();	
}

}

