package suite.Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String url="https://www.flipkart.com";
  		driver.get(url);
  		driver.manage().window().maximize();
  		
  		 
  		WebElement uname= driver.findElement( By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(1) > input"));
  			
  		uname.sendKeys("bharathi0850@gmail.com");

  		WebElement pwd=driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(2) > input"));
  		pwd.sendKeys("Bharathi@123");

  		WebElement login=driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div._1avdGP > button"));
  		login.click();

  		System.out.println("page name: " + driver.getCurrentUrl() + "handle" + driver.getWindowHandle() );

  		Actions act=new Actions(driver);
  		WebElement electronics=driver.findElement(By.cssSelector("#container > div > header > div.zi6sUf > div > ul > li:nth-child(1) > a > span"));

  		Thread.sleep(1000);

  		act.moveToElement(electronics).moveToElement(driver.findElement(By.cssSelector("#container > div > header > div.zi6sUf > div > ul > li:nth-child(1) > a > span")));
  		act.click().build().perform();
	}

}
