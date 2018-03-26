package testNgExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RetryFailedTestCases {
  
	WebDriver driver;
	
	String baseUrl = "https://www.linkedin.com/";
	
	
  @BeforeTest
	  public void beforeTest() {
		  
		  System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");	
		  
		  driver = new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		  driver.manage().window().maximize();
	  }
	
  @Test (priority = 1)
  public void verifyLoginPageTex() {
	  
	 driver.navigate().to(baseUrl);
	  
	 System.out.println("Verify Login page test started");
	  
	 WebElement element = driver.findElement(By.className("subtitle"));
	  
	 String hearderText = element.getText();
	  
	 Assert.assertEquals("Get started - it's free.", hearderText);
	  
  }
  
  @Test (priority = 2)
  public void verifyForgotPage() {
	  
	  driver.navigate().to(baseUrl);
	  	 		
	  System.out.println("Verify Forgot password page test started");
	  
	  driver.findElement(By.linkText("Forgot password?")).click();
	  
	  String passwordForgotPageText = driver.findElement(By.className("flow-h2")).getText();
	  
//	  String actualText = "Please enter your email or phone";
	  
	  Assert.assertEquals("Wrong Text", passwordForgotPageText);

  }
  
  
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
