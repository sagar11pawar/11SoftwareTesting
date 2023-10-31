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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CartPageTest extends TestBest
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initializaion();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new CartPage();
		login.LoginToApplication();
		invent.add6Product();
		invent.ClickcartCount();
	}
	@Test
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 7);//(0, 7)https://www.saucedemo.com/checkout-step-one.html
		String actURL=cart.verifyOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of cart page = "+ actURL);
	}
	@Test
	public void VerifyverifyTitleCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 6);//Your Cart(0, 6)
		String actTitle=cart.verifyTitleCartPage();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of cart page = "+ actTitle);
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
