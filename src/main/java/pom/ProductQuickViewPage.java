package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {
	
	@FindBy (xpath="//div[@id='square_Details']//h1")private List<WebElement> productName;
	@FindBy (xpath="//span[text()='Click here to Buy']")private WebElement clickHereToBuy;
	@FindBy (xpath="//span[@class='offer-price']")private WebElement price;
	@FindBy (xpath="//span[@class='ship-price']")private WebElement shippingCharges;
	
	public ProductQuickViewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName(int product)
	{
		return productName.get(product).getText();
	}
	
	public double getPrice()
	{
		return Double.parseDouble(price.getText());
	}
	
	public double getShippingCharges()
	{
	    String charges=shippingCharges.getText();
		String [] charge = charges.split(" ");
		return Double.parseDouble(charge[1]);
	}
	 
	public void clickHereToBuy()
	{
		clickHereToBuy.click();
	}

}
