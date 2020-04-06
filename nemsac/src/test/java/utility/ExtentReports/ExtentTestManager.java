package utility.ExtentReports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {

	// Step1: An extentTestMap map is created. It holds the information of thread
	// ids and ExtentTest instances
	static Map extentTestMap = new HashMap();
	// ExtentReports instance is created by calling getReporter() method from
	// ExtentManager.

	static ExtentReports extent = ExtentManager.getReporter();

	// At startTest() method, an instance of ExtentTest created and put into
	// extentTestMap with current thread id.
	public static synchronized ExtentTest getTest() {

		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));

	}

	// At endTest() method, test ends and ExtentTest instance got from extentTestMap
	// via current thread id.
	public static synchronized void endTest() {

		extent.endTest(getTest());

	}

	// At getTest() method, return ExtentTest instance in extentTestMap by using
	// current thread id.
	public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        System.out.println("We are in startTest Method of ExtentTestManager" + test);
        return test;
    }
}
