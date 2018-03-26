package suite.Flipkart;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\\\Users\\\\abongu\\\\Downloads\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html5demos.com/drag/");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

		WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));

		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(From)

		.moveToElement(To)

		.release(To)

		.build();

		dragAndDrop.perform();
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
