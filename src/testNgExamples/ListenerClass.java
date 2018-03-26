package testNgExamples;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.IClass;

public class ListenerClass extends TestListenerAdapter{
	
	@Override
	public void onTestStart(ITestResult tr)
	{
		log("Test Started...");
	}

	@Override
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("Test.." +tr.getName() + "Passed");
		log(tr.getTestClass());
		log("Priority of this method is " +tr.getMethod().getPriority());
		
		System.out.println(".................");
	}
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		log("Test" +tr.getName() + "Failed.." );
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".............");
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test.." +tr.getName() + "Skipped..");
		System.out.println("..........");
	}
	
	private void log(String methodName) {
		System.out.println(methodName);
	}
	
	
	private void log(IClass testClass)
	{
		System.out.println(testClass);
	}
	
	
	
}
