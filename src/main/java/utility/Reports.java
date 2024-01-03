package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports generateReports()
	{
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter("ExtentReports.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("version","5.1.0");
		reports.setSystemInfo("Created By","Priyanka");
		reports.setSystemInfo("Testing Type","Regression");
		return reports;
	}
	
	

}
