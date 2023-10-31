package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBest;
import utility.HandleDropDown;

public class Inventory_Page extends TestBest
{
	@FindBy(xpath="//span[@class='title']") private WebElement ProductTitleText;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement LinkedinLogo;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProduct;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortDropDown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement shoppingCartLink;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikeLightProduct;
	public Inventory_Page()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyProductLable()
	{
		return ProductTitleText.getText();	
	}
	public boolean verifyTwitterLogo()
	{
		return TwitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return FacebookLogo.isDisplayed();		
	}
	public boolean verifyLinkedinLogo()
	{
		return LinkedinLogo.isDisplayed();	
	}
	public String add6Product()
	{	
		HandleDropDown.handleSelectClass(productSortDropDown, ("Price (low to high)"));
		backpackProduct.click();
		bikeLightProduct.click();
		boltTshirtProduct.click();
		fleeceJacketProduct.click();
		onesieProduct.click();
		redTshirtProduct.click();
		return cartCount.getText();		
	}
	public boolean addToCart()
	{
		return shoppingCartLink.isDisplayed();		
	}
	public String remove2Products() throws InterruptedException
	{
		add6Product();
		Thread.sleep(3000);
		removebackpackProduct.click();
		removebikeLightProduct.click();
		return cartCount.getText();
		
	}
	public boolean verifyTitle()
	{
		return appLogo.isDisplayed();
	}
	public void ClickcartCount()
	{
		cartCount.click();
	}
}
