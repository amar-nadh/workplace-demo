package suite.Flipkart;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerucuryToursDemo {

		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");
		 
		 WebDriver driver = new ChromeDriver();
		 
		 
		 
		 driver.get("http://newtours.demoaut.com/");
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 WebElement u_id = driver.findElement(By.name("userName"));
		 
		 WebElement pwd = driver.findElement(By.name("password"));
		 
		 WebElement signIn = driver.findElement(By.name("login"));
		 
		 		 	 	 
		 u_id.clear();
		 
		 u_id.sendKeys("tutorial");
		 
		 pwd.clear();
		 
		 pwd.sendKeys("tutorial");
		 
		 signIn.click();
		 
		 Thread.sleep(2000);
		 
		 driver.close();		 
		 
		Wait<WebDriver> F_wait = new FluentWait<WebDriver>(driver)
				 							.withTimeout(30, TimeUnit.SECONDS)
				 							.pollingEvery(5,TimeUnit.SECONDS)
				 							.ignoring(NoSuchElementException.class);
		Clock clock = new SystemClock();
		Sleeper sleeper =  Sleeper.SYSTEM_SLEEPER;
		WebDriverWait wait = new WebDriverWait(driver, clock, sleeper , 30, 5 );
		
		wait.until(ExpectedConditions.attributeContains(By.className(""), "attribute", "value"));
		 
		// F_wait.pollingEvery(5, TimeUnit.SECONDS);
		 F_wait.until(ExpectedConditions.elementToBeClickable(By.className("")));
		 
		 
		 }

}
