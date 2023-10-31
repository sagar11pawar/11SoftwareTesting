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
import pages.CheckoutOverview;
import pages.CheckoutPage1;
import pages.CheckoutPage3;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckoutPage3Test extends TestBest
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutOverview check2;
	CheckoutPage3 check3;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initializaion();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new CartPage();
		check1 = new CheckoutPage1();
		check2 =new CheckoutOverview();		
		check3 =new CheckoutPage3();
		login.LoginToApplication();
		invent.add6Product();
		invent.ClickcartCount();
		cart.clickcheckOutBtn();
		check1.inputInfo();
		check2.verifyfinishBtn();
	}
	@Test
	public void verifytitleOfCheckoutCompleteTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(4, 0);//(4, 0)Checkout: Complete!
		String actTitle=check3.verifytitleOfCheckoutComplete();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Checkout page of title = " + actTitle);
	}
	@Test
	public void verifythankYouTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(4, 1);//Thank you for your order!
		String actTxt=check3.verifythankYouTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Thank you for your order text = " + expTxt);
	}
	@Test
	public void verifyyourOrderTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(4, 2);
		String actTxt=check3.verifyyourOrderTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Your order Text = " + actTxt);
	}
	@Test
	public void verifyimageTest()
	{
		boolean result=check3.verifyimage();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Right image = " + result);		
	}
	@Test
	public void verifybackHomeBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(4,3);//https://www.saucedemo.com/
		String actURL=check3.verifybackHomeBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Back to Home page = " + actURL);
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
