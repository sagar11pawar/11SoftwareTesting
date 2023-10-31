package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBest;

public class CheckoutPage3  extends TestBest
{
	@FindBy(xpath = "//span[@class='title']") private WebElement titleOfCheckoutComplete;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement thankYouTxt;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement yourOrderTxt;
	@FindBy(xpath = "//img[@class='pony_express']") private WebElement image;
	@FindBy(xpath = "//button[@id='back-to-products']") private WebElement backHomeBtn;
	
	public CheckoutPage3()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifytitleOfCheckoutComplete()
	{
		return titleOfCheckoutComplete.getText();		
	}
	public String verifythankYouTxt()
	{
		return thankYouTxt.getText();		
	}
	public String verifyyourOrderTxt()
	{
		return yourOrderTxt.getText();		
	}
	public boolean verifyimage()
	{
		return image.isDisplayed();		
	}
	public String verifybackHomeBtn()
	{
		backHomeBtn.click();
		return driver.getCurrentUrl();	
	}
}
