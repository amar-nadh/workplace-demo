package testNgExamples;

import org.testng.annotations.Test;


public class LoggingClass {
  
	@Test
  public void methodAdding() {
	  
	  System.out.println("i am in methodAdding, Executed by default");
  }
  
  /*
    - We can use as  '@Test(expectedExceptions=ArithmeticException.class)' 
   	  to catch the exception and then that method will result as 'PASSED'. 
    - Otherwise this would fail with arithmeticExceptio / Zero   
   */
	@Test
  public void divisibleByZero()
  {
	  System.out.println("I am in divisible by Zero");
	  
	  int z = 10/0;
	  
	  System.out.println("Print z after divisible by zero" +z);
 
  }
  
  @Test(dependsOnMethods = {"divisibleByZero"})
  public void methodskip()
  {
	
	  System.out.println("I am in Method skip");  
  }
  
}
