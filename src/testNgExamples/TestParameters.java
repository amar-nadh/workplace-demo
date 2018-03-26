package testNgExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
  
@Parameters({"browser"})
  @Test
  public void testcaseOne(String browser) {
	System.out.println("browser passed as:- " +browser);
	
	System.out.println("Testcase Running on Thread ID: " +Thread.currentThread().getId());
	
  }

 @Parameters({"username", "password"})
 @Test
 public void testcaseTwo(String username, String password)
 {
	 System.out.println("Parameter for UserName as:- " + username);
	 System.out.println("Parameter for Password as:- " +password);
	 
	 System.out.println("Testcase Running on Thread ID: " +Thread.currentThread().getId());
 }

}
