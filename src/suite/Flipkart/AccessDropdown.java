package suite.Flipkart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;


public class AccessDropdown {
  
	WebDriver driver =null;
	String baseurl = "http://newtours.demoaut.com/";
	
	@Test
    public void selectDropdownList() throws InterruptedException {
	
		WebElement mailing_country = driver.findElement(By.name("country"));
		
		Select country_name = new Select(mailing_country);
		
		country_name.selectByVisibleText("INDIA");
							
		List<WebElement> all_options = country_name.getOptions();
		
		for (WebElement options: all_options)
		{
			System.out.println(options.getText());
		}
		
	}
	
	  @BeforeTest
	  public void Init() {
		 
		 System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");
		 
		 System.out.println("Property: " +System.getProperty("webdriver.chrome.driver"));
		 System.out.println("Java Version: " +System.getProperty("java.runtime.version"));
		 
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 
		 driver.get(baseurl);
	  }
	  
	    
	  @AfterTest
	  public void Logout() {
		  
		  driver.close();
		  driver.quit();
	  }

}
