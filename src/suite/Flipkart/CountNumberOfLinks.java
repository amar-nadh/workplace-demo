package suite.Flipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountNumberOfLinks {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\Users\\\\abongu\\\\Downloads\\\\chromedriver.exe");
	    
		driver = new ChromeDriver();
	    
		String url = "https://google.com";
	    
		driver.get(url);
	    
		WebElement find = driver.findElement(By.id("lst-ib"));
	    
		find.sendKeys("Selenium");
		
		find.submit();
		
	    Thread.sleep(2000);
	    
	    WebElement click = driver.findElement(By.name("btnG"));
	    click.click();
	    Thread.sleep(2000);
	   
	//List<WebElement> listings = driver.findElements(By.tagName("div"));
	    
	  List<WebElement> Listing1 = driver.findElements(By.xpath("//cite[@class='_Rm']"));
	    	    	    
	//  System.out.println("Fetched URL's are as follows:-" + listings.size());
	    
	  System.out.println("Fetched URL's are as follows:-" + Listing1.size());

	    for (WebElement loop : Listing1) {
	    
	    	System.out.println(loop.getText());
	          
	             	        
	    } 
	    
	   driver.close();
	}

}
