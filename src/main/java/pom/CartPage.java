package pom;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	@FindBy (xpath="//ul[@id='cartData']")private List<WebElement>products;
	@FindBy (xpath="(//a[@onclick='cart.submitOrder()'])[1]")private WebElement proceedToCheckOut;
	@FindBy (xpath="(//a[@onclick='cart.continueShopping()'])[1]")private WebElement continueShopping;
	@FindBy (xpath="//a[@onclick='cart.remove(670762949)']")private  WebElement remove;
	@FindBy (xpath="//div[@class='cart_info']//h2//a")private List<WebElement> productName;
	@FindBy (xpath="(//li[@class='head_UPrice'])")private List<WebElement> unitPrice;
	@FindBy (xpath="//li[@class='head_ship']")private List<WebElement> shippingCharges;
	@FindBy (xpath = "//ul[@id='cartData']//li[5]")private List<WebElement> orderAmount;
	@FindBy (xpath = "(//ul[@id='cartTotal']//label)[1]") private WebElement cartAmount;
	@FindBy (xpath="//span[@id='totalPayableAmount']")private WebElement tatalPayableAmount;
	
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public int getNumberOfProductPresentInCart(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(9000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
		return products.size();
	}
	
	public void clickOnContinueShopping()
	{
		
		continueShopping.click();
	}
	
	public void clickOnRemove(WebDriver driver) 
	{
	    WebDriverWait wait=new  WebDriverWait(driver,Duration.ofMillis(5000));
	    wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
	    remove.click();
	    
	}
	
	public String getProductName(int index,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
	    wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
		return productName.get(index).getText();
	}
	
	public double getUnitPrice(int index)
	{
		return Double.parseDouble( unitPrice.get(index).getText().substring(3));
	   
	}
	
	public double getShippingPrice(int index)
	{
		return Double.parseDouble(shippingCharges.get(index).getText().substring(3));
	}
	
	public double getOrderAmount(WebDriver driver,int index) throws InterruptedException  {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(cartAmount));
//		Thread.sleep(2000);
		return Double.parseDouble(orderAmount.get(index).getText().replace(",", ""));
	}
	

	public double getCartAmount() {
		return Double.parseDouble(cartAmount.getText().substring(3).replace(",", ""));
//		String a=cartAmount.getText().substring(3).replace(",", "");
//		return Double.parseDouble(a);
	}
	
	public void clickOnProceedToCkeckOut()
	{
		proceedToCheckOut.click();
	}
	public double getTotalPayableAmount()
	{
		return Double.parseDouble(tatalPayableAmount.getText());
	}

}
