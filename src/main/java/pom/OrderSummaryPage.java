package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

	@FindBy (xpath="//td[@align='center']")private WebElement productPrice;
	@FindBy (xpath="(//td[@align='center'])[4]")private WebElement shipping;
	@FindBy (xpath="(//span[@class='font-bold'])[4]")private WebElement totalAmount;
	
	public OrderSummaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public double getProductPrice(int index)
	{

		 String charges=productPrice.getText();
		 String [] charge = charges.split(" ");
	     return Double.parseDouble(charge[1]);
	}
	public void getShippingCharges()
	{
		shipping.getText();
	}
	public double getTotalAmount(int index)
	{
		String charges=totalAmount.getText();
		 String [] charge = charges.split(" ");
	     return Double.parseDouble(charge[1]);
	}
	
}
