// There is an issue in Identifing the User Login and Password


package suite.Flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompositActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "D:\\Users\\abongu\\Downloads\\chromedriver.exe" );
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("http://way2automation.com/way2auto_jquery/draggable.php");
			
			//driver.findElement(By.cssSelector("#load_form > div > div.span_3_of_4 > p > a")).click();
			
			driver.findElement(By.xpath("//*[@id=\"load_form\"]/div/div[1]/p/a")).click();
				
			driver.findElement(By.name("username")).sendKeys("abongu");
			driver.findElement(By.name("password")).sendKeys("India@604");
			driver.findElement(By.className("button")).click();
			
			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[1]/ul/li[1]/a/figure")).click();			
			
			Actions action = new Actions(driver);
			
			WebElement dragable = driver.findElement(By.cssSelector("#draggable"));
			
			
			Point location = dragable.getLocation();
			
						
			action.clickAndHold(dragable);
			
			
			for (int i = 0; i < 50; i++)
			{
			
				action.moveByOffset(location.getX() + i, location.getY() + i);
			
			}
			
			
			action.release();
			
			action.build().perform();
			
			driver.close();
			
			
			
	}

}
