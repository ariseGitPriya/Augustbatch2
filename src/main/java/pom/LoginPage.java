package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="(//input[@class='input-new'])[4]")private WebElement mobileNumber;
	@FindBy (xpath="(//input[@value='Continue'])[2]")private WebElement continueButton;
	@FindBy (xpath="(//input[@class='input-new'])[4]")private WebElement OTP;
	@FindBy (xpath="//input[@id='gc-registration-otp-panel-submit']")private WebElement submit;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterMobileNo(String MOB)
	{
		mobileNumber.sendKeys(MOB);
		
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void enterOTP(String otp)
	{
		OTP.sendKeys(otp);
	}
	
	public void clickOnsubmit()
	{
		submit.click();
	}

}
