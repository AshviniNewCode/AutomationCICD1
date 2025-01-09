package AshviniPakhare.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{ 

	public static ExtentReports getReportObject()
	{
		//Need two objects 1. ExtentReports 2.ExtentSparkReporter
				String path=System.getProperty("user.dir")+ "\\reports\\index.html";
				ExtentSparkReporter reporter=new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Report");
				reporter.config().setDocumentTitle("Test Results");
				
				ExtentReports extent=new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("TesterName", "Ashvini");
				
				return extent;
	}

}
