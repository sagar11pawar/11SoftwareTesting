package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBest;

public class CartPage extends TestBest
{
	@FindBy(xpath = "//span[@class='title']") private WebElement titleOfCartPage;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkOutBtn;
	
	public CartPage ()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyOfApplication()
	{
		return driver.getCurrentUrl();	
	}
	public String verifyTitleCartPage()
	{
		return titleOfCartPage.getText();		
	}
	public void clickcheckOutBtn()
	{
		checkOutBtn.click();
	}
}
