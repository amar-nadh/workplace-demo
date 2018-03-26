package suite.Flipkart;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSExByOffshore {

	public static void main(String[] args) throws InterruptedException  {

						
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\abongu\\Downloads\\chromedriver.exe");
		
		WebDriver driver=null; 
		
		driver = new ChromeDriver();

		  
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
				
		driver.get("http://iconnect.fs.capgemini.com/");
		driver.manage().window().maximize();
				
		driver.findElement(By.xpath("//*[@id='TabbedPanels1']/ul/li[4]/table/tbody/tr[1]/td/img")).click();
		
		driver.findElement(By.xpath("//*[@id='ctl00_cphMainContent_hplnk_LMS']")).click();
		
//		ArrayList<String> a =new ArrayList<String>(driver.getWindowHandles()); 
//		 driver.switchTo().window(a.get(1));
		 
		 		
		Set<String> Win_Handles = new HashSet<String>(driver.getWindowHandles());
		
		Iterator<String> itr = Win_Handles.iterator();
		
		//String _parent_window = itr.next();
					
		while (itr.hasNext())
		{
			
			String _exp_HomePage_Title = "Leave Management System";
			
			String page_Title = driver.switchTo().window((String) itr.next()).getTitle();
						
			if (page_Title.equals(_exp_HomePage_Title.toLowerCase())) 
				break;
						
		}
		
		
        Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id='collapseTwo']/div/div[1]/div[3]/a")).click();
		
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('ALStartDate').value = '21-12-2017'");
		js.executeScript("document.getElementById('ALEndDate').value = '26-12-2017'");
		
		driver.findElement(By.xpath("//*[@id='ALDescription']")).sendKeys("This is for Training purpose. Please ignore/Don't approve leaves");
		
		//driver.findElement(By.xpath("//*[@id='submitleavebtn']")).click();
	
		//driver.switchTo().window(a.get(0));
		
		driver.close();
		driver.quit();
		
	}

}
