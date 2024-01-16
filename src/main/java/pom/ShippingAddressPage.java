package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	
	@FindBy (xpath="//select[@id='fktitle_id']")private WebElement title;
	@FindBy (xpath="//input[@id='firstName']")private WebElement firstName;
	@FindBy (xpath="//input[@id='lastName']")private WebElement lastName;
	@FindBy (xpath="//textarea[@id='address']")private WebElement address;
	@FindBy (xpath="//input[@id='landmark']")private WebElement landMark;
	@FindBy (xpath="//input[@id='pincode']")private WebElement pincode;
	@FindBy (xpath="//select[@id='state']")private WebElement state;
	@FindBy (xpath="//select[@id='city']")private WebElement city;
	@FindBy (xpath="//input[@id='mobile']")private WebElement mobileNo;
	@FindBy (xpath="//input[@id='landline']")private WebElement landLineNo;
	@FindBy (xpath="//a[@id='addEditButton']")private WebElement saveAndProceed;
	
	public ShippingAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectTitle(String Title)
	{
		Select select = new Select(title);
		select.selectByVisibleText(Title);
	}
	public void enterFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
		
	}
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public void enterAddress(String addr)
	{
		address.sendKeys(addr);
	}
	public void enterLandMark(String land)
	{
		landMark.sendKeys(land);
	}
	public void enterPincode(String pin)
	{
		pincode.sendKeys(pin);
	}
	public void selectState(String stat)
	{
		Select select = new Select(state);
		select.selectByVisibleText(stat);
	}
	
	public void selectCity(String City)
	{
		Select select = new Select(city);
		select.selectByVisibleText(City);
	}
	
	public void enterMobileNo(String Mobile)
	{
		mobileNo.sendKeys(Mobile);
	}
	public void enterLandLineNo(String Landline)
	{
		mobileNo.sendKeys(Landline);
	}
	public void clickOnSaveAndProceed()
	{
		saveAndProceed.click();
	}
	
	
	

}
