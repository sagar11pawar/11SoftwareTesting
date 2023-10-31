package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBest;

public class ExtentReportManager extends TestBest
{	
	static ExtentReports report;
	public static ExtentReports getReportInstance() 
	{	
		if(report==null)
		{
			String reportName=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\sagar\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\\\"+reportName+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Environment", "SIT");
		report.setSystemInfo("Build Number", "102.02.02.123");
		report.setSystemInfo("Browser", "chrome");
		htmlReporter.config().setDocumentTitle("UI Testing Document");
		htmlReporter.config().setReportName("UI Test Report");
		}
		return report;
		
	}
	
}
