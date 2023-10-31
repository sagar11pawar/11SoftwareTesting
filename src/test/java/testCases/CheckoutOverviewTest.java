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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckoutOverviewTest extends TestBest
{	
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutOverview check2;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initializaion();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new CartPage();
		check1 = new CheckoutPage1();
		check2 =new CheckoutOverview();		
		login.LoginToApplication();
		invent.add6Product();
		invent.ClickcartCount();
		cart.clickcheckOutBtn();
		check1.inputInfo();
		
	}
	@Test
	public void verifyLabelOfApplicationTest() throws EncryptedDocumentException, IOException 
	{
		String expLabel=ReadData.readExcel(0,10);//(0, 10)
		String actLabel=check2.verifyLabelOfApplication();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("label of application = " + actLabel);

	}
	@Test
	public void verifypaymentInfoLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel1=ReadData.readExcel(0, 11);//Payment Information
		String actLabel1=check2.verifypaymentInfoLabel();
		Assert.assertEquals(expLabel1, actLabel1);
		Reporter.log("Label of payment infotmation = " + actLabel1);

	}
	@Test
	public void verifyshoppingInfoLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel2=ReadData.readExcel(0, 12);//Shipping Information
		String actLabel2=check2.verifyshoppingInfoLabel();
		Assert.assertEquals(expLabel2, actLabel2);
		Reporter.log("Label of shopping infotmation = " + actLabel2);

	}
	@Test
	public void verifypriceTotalLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel3=ReadData.readExcel(0, 13);//Price Total(0,13)
		String actLabel3=check2.verifypriceTotalLabel();
		Assert.assertEquals(expLabel3, actLabel3);
		Reporter.log("Label of price total = " + actLabel3);

	}@Test
	public void verifyfinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,14);//https://www.saucedemo.com/checkout-complete.html
		String actURL=check2.verifyfinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL Thank you for your order! = " + actURL);
	}
	@Test
	public void verifycancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,15);//https://www.saucedemo.com/inventory.html
		String actURL=check2.verifycancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Back to product URL  = " + actURL);
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
