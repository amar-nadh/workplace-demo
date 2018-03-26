package guru99.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.pageFactory.Guru99HomePage;
import com.pageFactory.Guru99Login;

public class Test99GuruLoginWithPageFactory {
  
	WebDriver driver;
	
	Guru99Login objLogin;

    Guru99HomePage objHomePage;
	
	 @BeforeTest
	 public void setup(){
		 
		 System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");	
	     
		 driver = new ChromeDriver();
	     
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  
	     driver.get("http://demo.guru99.com/V4/");
	     }
  
	 @Test
	 public void test_Home_Page_Appear_Correct(){

		 //Create Login Page object
	    objLogin = new Guru99Login(driver);

	    //Verify login page title
	    String loginPageTitle = objLogin.getLoginTitle();

	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

	    //login to application
	    objLogin.loginToGuru99("mngr96403", "EsAsaja");

	    // go the next page
	    objHomePage = new Guru99HomePage(driver);
	    
	    //Verify home page
	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr96403"));
	    }

	 @AfterTest
	 public void tearDown()
	 {
	  driver.close();
	 }
}
