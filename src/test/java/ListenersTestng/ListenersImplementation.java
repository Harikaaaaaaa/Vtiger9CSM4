package ListenersTestng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		System.err.println("onTestSart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.err.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.err.println("onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.err.println("onTestSkipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.err.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.err.println("onFinish");
	}
      
}
