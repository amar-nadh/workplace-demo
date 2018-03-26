package testNgExamples;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
			Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
			
			Set<ITestResult> skipedTests = context.getSkippedTests().getAllResults();
			
			
			for (ITestResult temp : skipedTests) {
				
				ITestNGMethod method = temp.getMethod();
				
			if (context.getSkippedTests().getResults(method).size() > 0)
				{
				skipedTests.remove(temp);
				}
			}
				
				
			for (ITestResult temp : failedTests) {
			
			ITestNGMethod method = temp.getMethod();
			
			if (context.getFailedTests().getResults(method).size() > 1) {
				
				
				failedTests.remove(temp);
			} 
			
			else 
			{
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
				
							
			}
		}
	}
	
}



	

