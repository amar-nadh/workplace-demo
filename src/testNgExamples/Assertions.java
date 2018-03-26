package testNgExamples;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assertions {
	
	WebDriver driver;
	
	@BeforeTest
	public void Initialisation() {
		
		driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");	
	     }
	
	
	
	@Test
	public void Assertionstest()
	{
		 
		 driver.get("http:/google.com");
		 
		 String _exp_HomePage_Title = "Google";
		 
		Assert.assertEquals(driver.getTitle().toLowerCase(), _exp_HomePage_Title.toLowerCase(), "Strings are not matching" );
			 
	}
	
	
	@Test
	public void Assertionstest2()
	{
		
		driver.navigate().to("https://wiki.perficient.com/confluence/login.action?os_destination=%2Fhomepage.action");
			
		 
		 String _exp_HomePage_Title = "Log In - Perficient Wiki";
		 
		 Assert.assertEquals(driver.getTitle(), _exp_HomePage_Title, "Home apge title doesnot match");
			 
	}
	
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}

}
