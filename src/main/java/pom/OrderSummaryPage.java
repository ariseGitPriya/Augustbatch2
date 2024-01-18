package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryPage {

	@FindBy (xpath="(//td//p)[2]")private WebElement productNameFinal;
	@FindBy (xpath="//td[text()='699']")private WebElement productPrice;
	@FindBy (xpath="(//td[@align='center'])[4]")private WebElement shipping;
	@FindBy (xpath="(//td//span)[6]")private WebElement totalAmount;
	
	public OrderSummaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getProductPrice()
	{

	   String product= productPrice.getText() ;
	   return product;
	   // String [] charge = charges.split(" ");
	   //return Double.parseDouble(charge[1]);
	}
	public void getShippingCharges()
	{
		shipping.getText();
	}
	
	public double getTotalAmount()
	{
		String amount= totalAmount.getText();
		String [] totalAmount = amount.split(" ");
		return Double.parseDouble(totalAmount[0]);
	
	}
	public String getProductName()
	{
		return productNameFinal.getText();
		
	}
	
}
