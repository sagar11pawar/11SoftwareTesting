package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBest;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class VerifyMultipleCredentialsTest extends TestBest
{
	LoginPage Login;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initializaion();
		Login=new LoginPage();		
	}
	@Test(dataProvider = "credentials")
	public void LoginToApplicationWithMultipleDataTest(String un,String pass) throws IOException
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=Login.LoginToApplicationWithMultipleData(un, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll();
	}
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]
		{
		{"standard_user","secret_sauce"},
		{"locked_out_user","secret_sauce"},
		{"problem_user","secret_sauce"},
		{"performance_glitch_user","secret_sauce"},
		{"error_user","secret_sauce"},
		{"visual_user","secret_sauce"},
		};	
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenshot(it.getName());
		}
		driver.close();
	}
}
