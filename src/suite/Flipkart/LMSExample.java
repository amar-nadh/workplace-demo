package suite.Flipkart;

import java.time.MonthDay;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LMSExample {
	
	WebDriver driver = null;
	
	WebDriverWait wait = null;
	
	 @BeforeTest 
	 public void Initialisation() {
			
			System.setProperty("webdriver.chrome.driver","D:\\Users\\abongu\\Downloads\\chromedriver.exe");	
		   
			driver = new ChromeDriver();
			  
			wait = new WebDriverWait(driver, 50);
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	 
	 @Test(priority = 1)
	 public void LaunchLMS() {
		 
		 driver.get("https://lms.in.capgemini.com/"); 
		 
		 String _exp_HomePage_Title = "Leave Management System";
		 
		 Set<String> Win_Handls = driver.getWindowHandles();
		 
		 System.out.println(Win_Handls);
		 
		 Assert.assertEquals(driver.getTitle().toLowerCase(), _exp_HomePage_Title.toLowerCase(), "LMS page is not open") ;
	 }
	 
	 @Test(priority = 2)
	 public void ApplyLeaveForTwoDays() throws InterruptedException 
	 {
		 
		 	WebElement leave_bal = driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div/div[1]/div[1]/div/strong"));
			 
			int available_bal = Integer.parseInt(leave_bal.getText());
			 		
			System.out.println("Current avilable balance is: " +available_bal + " days");
			
			//click on the Apply leave button
			
			driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div/div[1]/div[3]/a")).click();
			
			//Select the type of the leave to apply	
			WebElement leave_type = driver.findElement(By.id("LeaveTypeList"));
			
			Select SelectLeaveType = new Select(leave_type);
			SelectLeaveType.selectByVisibleText("Privilege Leave");
			
			/**********Select the leave start date****************************/
			
			//Wait until the start date element to be visible and then select
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ALStartDate"))).click(); 
			
			List<WebElement> Leave_Start_Date = driver.findElements(By.xpath("/html/body/div[3]/div[1]/table/tbody/*/td"));
			
		    for(WebElement we: Leave_Start_Date )
				{
		    		   		
		    	
					int dd = Integer.parseInt(we.getText());
					
					MonthDay m = MonthDay.now();
				    int n = m.getDayOfMonth();
				    
				    if (dd == n)
				    {
				    	we.click();
				    	break;
				    }
				   
				}
				
		    /************Select leave End date ************************/
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ALEndDate"))).click();
		
		    List<WebElement> Leave_End_Date = driver.findElements(By.xpath("/html/body/div[3]/div[1]/table/tbody/*/td"));
		    
		    for(WebElement we: Leave_End_Date)
		    {
		    	int dd = Integer.parseInt(we.getText());
		    		
		    	MonthDay m = MonthDay.now();
			    int n = m.getDayOfMonth();
			    
			    if (dd == n + 2)
			    {
			    	we.click();
			    	break;
			    }
		    	
		    }
			
		      
			driver.findElement(By.name("ALDescription")).sendKeys("Privilegae Leave");
			
			//			driver.findElement(By.id("submitleavebtn")).submit();
			
	 }

		
			
				
		@AfterTest
		public void Teardown()	{
			
			driver.close();
		    driver.quit();
		}
		 
		    
	}

