package suite.Flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseInterations {

	WebDriver driver = null;
	
			
	@BeforeTest
	public void Init()
	{
		 System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
	}
	
	
	@Test
	public void MouseCal() throws InterruptedException
	{
		driver.get("http://www.calculator.net/");
		
		WebElement one = driver.findElement(By.xpath("//*[@id=\"sciout\"]/tbody/tr[2]/td[2]/div/div[3]/span[1]"));
			one.click();
			
		Thread.sleep(2000);
			
		Actions action = new Actions(driver);
		
		Point loc = one.getLocation();
		
		action.moveByOffset(loc.getX() + 52, loc.getY());
		
		action.click();
		
		Thread.sleep(2000);
		
					
		
	}
	
	/*@Test
	public void checkClickAndDrag() throws InterruptedException
	{
		
		driver.get("http://demo.automationtesting.in/Static.html");
		
		WebElement dragable = driver.findElement(By.cssSelector("#node"));
		WebElement dropable = driver.findElement(By.cssSelector("#droparea"));
		
		Actions action = new Actions(driver);
	
		Point loc = dragable.getLocation();
		
		System.out.println(dropable.getLocation());
		
		action.moveByOffset(loc.getX() + 5, loc.getY()+5);
		action.clickAndHold();
		action.moveByOffset(442, 170);
		
		action.release();
		
		//action.dragAndDrop(dragable, dropable);
		
				
		action.build().perform();
				
} */
	
	
	
	
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
	
}
