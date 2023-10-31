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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class Inventory_Page_Test extends TestBest
{	
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initializaion();
		login=new LoginPage();
		invent=new 	Inventory_Page();
		login.LoginToApplication();
	}
	@Test
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0, 3);//(0, 3)Products
		String actLable=invent.verifyProductLable();
		Assert.assertEquals(expLable,actLable);
		Reporter.log("Applications Lable ="+ actLable);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of twitter logo ="+ result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean result=invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of facebook logo ="+ result);
	}
	@Test
	public void verifyLinkedinLogoTest()
	{
		boolean result=invent.verifyLinkedinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of linkedin logo ="+ result);
	}
	@Test
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 4);//6
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products added in to the cart ="+ actCount);
	}
	@Test
	public void addToCartTest()
	{
		boolean result=invent.addToCart();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of add to cart ="+ result);
	}
	@Test
	public void verifyTitleTest()
	{
		boolean result=invent.verifyTitle();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of title ="+ result);
	}
	@Test
	public void remove2Products() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 5);//4
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count of product after removing =" + actCount);
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
