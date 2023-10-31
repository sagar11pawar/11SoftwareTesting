package base;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;

public class TestBest 
{	
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public static ChromeDriver driver;
	public void initializaion() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("URL"));
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
	}
}
