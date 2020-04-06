package utility.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {

		if (extent == null) {
			// Set HTML reporting file location
			String workingDir = System.getProperty("user.home") + "\\git\\NemSac\\nemsac\\TestExecutionOutputReport";
			extent = new ExtentReports(workingDir + "\\ExtentReportResults.html", true);

		}
		return extent;
	}

}
