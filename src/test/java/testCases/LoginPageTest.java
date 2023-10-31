package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import base.TestBest;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class LoginPageTest extends TestBest
{	
	LoginPage Login;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initializaion();
		Login=new LoginPage();		
	}
	@Test(enabled=true,priority=3)
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 0);//(0, 0)https://www.saucedemo.com/
		String actURL=Login.verifyURLOfApplication();
		Assert.assertEquals(expURL,actURL);
	}
	@Test(enabled=true,priority=1,dependsOnMethods = "verifyURLOfApplicationTest")
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 1);//Swag Labs(0, 1)
		String actTitle=Login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
	}
	@Test(enabled=true,priority=2,dependsOnMethods = "verifyURLOfApplicationTest")
	public void LoginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2);//https://www.saucedemo.com/inventory.html(0,2)
		String actURL=Login.LoginToApplication();
		Assert.assertEquals(expURL,actURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}
}
