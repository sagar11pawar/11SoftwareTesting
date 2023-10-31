package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBest;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckoutPage1Test extends TestBest
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	
	@BeforeMethod
	public void setUP() throws IOException, InterruptedException
	{
		initializaion();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new CartPage();
		check1 = new CheckoutPage1();
		login.LoginToApplication();
		invent.add6Product();
		invent.ClickcartCount();
		cart.clickcheckOutBtn();
	}
	@Test
	public void verifyURLOfCheckOutPage1Test() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 9);//(0, 9)
		String actURL=check1.verifyURLOfCheckOutPage1();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of cart page = " + actURL);
	}
	@Test
	public void inputInfoTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 8);
		String actURL=check1.inputInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of cart page = " + actURL);
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
