package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBest;

public class CheckoutPage1 extends TestBest
{
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstnameTxtbox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnameTxtbox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCodeTxtbox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	public CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURLOfCheckOutPage1()
	{
		return driver.getCurrentUrl();	
	}
	public String inputInfo()
	{
		firstnameTxtbox.sendKeys("Sagar");
		lastnameTxtbox.sendKeys("Pawar");
		postalCodeTxtbox.sendKeys("425412");
		continueBtn.click();
		return driver.getCurrentUrl();		
	}
	public String verifyLabelOfApplication()
	{
		return driver.getTitle();
	}
}
