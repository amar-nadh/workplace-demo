package suite.Flipkart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Flipkart {
	
	WebDriver driver = null;
	
	String Url = "https://www.flipkart.com/";
	String username = "amarnadhbongu@gmail.com";
	String password = "India@604";
	
  @BeforeTest
  public void Init() {
	 
	 System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");	
	 
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 
	 driver.get(Url);
  }
	
 //Login to Flipkart
  
  @Test
  public void Home() {
	  
	  Set<String> handle = driver.getWindowHandles();
	  
	  Iterator<String> itr = handle.iterator();
	  
	   while(itr.hasNext())
	   {
		   System.out.println((String)itr.next());
	   }
	  
	  	Actions act = new Actions(driver);
	  	act.sendKeys(Keys.chord(username));
	  	act.sendKeys(Keys.TAB);
	  	act.sendKeys(Keys.chord(password));
	  	
	  	act.build().perform();
	  	
 }
  
/*  
  @Test
  public void Login() {
	  
	 driver.findElement(By.partialLinkText("Log In")).click();
	  
	 WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
	 userName.clear();
	 userName.sendKeys(username);
	 
	 WebElement passWd = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
	 passWd.clear();
	 passWd.sendKeys(password);
	 
	 driver.findElement(By.xpath("//button[@type='submit']")).submit();
	
	 } */
  
//  @Test
//  public void searchAndSelectProduct() 
//  {
//	  driver.findElement(By.name("q")).clear();
//	  driver.findElement(By.name("q")).sendKeys("Moto g3");
//	  
//	  driver.findElement(By.className("vh79eN")).submit();
//
//		// select the first item in the search results
//		
//	List<WebElement> SearchLinks = driver.findElements(By.className("_3BTv9X"));
//	 
//	//System.out.println("Type of the SearchLinks: " +SearchLinks);
//	
//	for (WebElement loop: SearchLinks)
//	{
//		System.out.println(loop.getTagName());
//	}
//} 
  
   
  @AfterTest
  public void Logout() {
	  
	  driver.close();
	  driver.quit();
  	}
}


