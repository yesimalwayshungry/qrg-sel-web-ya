package Common;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import TestCases.TC_TravelAgencySignUp;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TC_TravelAgencySignUp.class);
		
		for(Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}

}
