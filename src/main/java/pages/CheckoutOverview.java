package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBest;

public class CheckoutOverview extends TestBest
{
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutOverviewTitle;
	@FindBy(xpath = "(//div[@class='summary_info_label'])[1]") private WebElement paymentInfoLabel;
	@FindBy(xpath = "(//div[@class='summary_info_label'])[2]") private WebElement shoppingInfoLabel;
	@FindBy(xpath = "(//div[@class='summary_info_label'])[3]") private WebElement priceTotalLabel;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	
	public CheckoutOverview()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLabelOfApplication()
	{
		return checkoutOverviewTitle.getText();
	}
	public String verifypaymentInfoLabel()
	{
		return paymentInfoLabel.getText();	
	}
	public String verifyshoppingInfoLabel()
	{
		return shoppingInfoLabel.getText();		
	}
	public String verifypriceTotalLabel()
	{
		return priceTotalLabel.getText();		
	}
	public String verifyfinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();		
	}
	public String verifycancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
}
