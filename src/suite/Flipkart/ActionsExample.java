package suite.Flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {
	
	
public static void main(String[] args) throws InterruptedException {
		
	 	System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");
	 
	 	WebDriver driver = new ChromeDriver();
	
	 	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	 	
	 	driver.get("https://www.nseindia.com/");
	
	 	driver.manage().window().maximize();
		
		// Importing Actions
		Actions a=new Actions(driver);
		
		// Creating Webelement for Products Menu
		//WebElement products=driver.findElement(By.xpath("html/body/div[2]/div[1]/div[4]/ul/li[3]/a"));
		WebElement products = driver.findElement(By.xpath("//*[@id=\"main_prd\"]/a"));
		
				
		// Action  - -  Moving Cursor to Products 
		a.moveToElement(products).build().perform();
		
		Thread.sleep(500);
			
		/*// Clicking on Mutual Funds link under products menu
		driver.findElement(By.xpath("html/body/div[2]/div[1]/div[4]/ul/li[3]/div/ul/li[1]/ul/li[3]/a")).click();*/
		
		// Creating webelement for menu
		WebElement menu=driver.findElement(By.xpath("html/body/div[2]/div[1]/div[4]/ul/li[3]/div/ul/li[1]/ul"));
		// Counting number of links under menu
		
		List<WebElement> lc=menu.findElements(By.tagName("li"));
		
		String xpath1="html/body/div[2]/div[1]/div[4]/ul/li[3]/div/ul/li[1]/ul/li[";
		
		String xpath2="]/a";
		
		for(int i=1; i<=lc.size(); i++){
		//	System.out.println(driver.findElement(By.xpath("html/body/div[2]/div[1]/div[4]/ul/li[3]/div/ul/li[1]/ul/li[" + i + "]/a")).getText());
			System.out.println(driver.findElement(By.xpath(xpath1+i+xpath2)).getText());
		}
		
		
		driver.close();
		
		

	}

}
