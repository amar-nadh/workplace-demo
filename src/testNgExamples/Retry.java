package testNgExamples;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private static int retry_count = 0;
	
	public int max_retry_count = 2;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if (retry_count < max_retry_count) {
			
//			System.out.println("Retrying Test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the "+
//			 + (retry_count + 1) + " times . . .  ");
			
			retry_count++;
			
			return true;
		}
		return false;
	}
	
	/*
	public String getResultStatusName(int status) {
		
		String result_name = null;
		
		if(status == 1)
			 result_name = "success";
		
		if (status == 2)
			result_name = "Failure";
			
		if(status == 3)
			result_name = "Skipped";
		
		return result_name;
		
	}
	
	*/
	

}
