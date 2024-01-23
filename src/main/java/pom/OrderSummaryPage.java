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
	
	@FindBy (xpath="(//td//span)[6]")private WebElement totalAmount;
	
	public OrderSummaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public double getTotalAmount()
	{
		return Double.parseDouble(totalAmount.getText().replace(",", "").replace("/-", ""));
	
	}
	public String getProductName()
	{
		return productNameFinal.getText();
		
	}
	
}
