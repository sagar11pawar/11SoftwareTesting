package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBest;
import utility.ReadData;

public class LoginPage extends TestBest
{
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String LoginToApplication() throws IOException
	{	
		logger=report.createTest("Login to sauce lab application");
		userNameTextBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO, "Username is entered");
		passwordTextBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login button clicked");
		logger.log(Status.PASS, "Login in successful");
		return driver.getCurrentUrl();		
	}
	public String LoginToApplicationWithMultipleData(String un,String pass)
	{
		userNameTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
		
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
		
	}
}
