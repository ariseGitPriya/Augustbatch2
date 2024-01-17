package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrawser;
import pom.CartPage;
import pom.LoginPage;
import pom.NaptoolHomePage;
import pom.OrderSummaryPage;
import pom.ProductDescriptionPage;
import pom.ProductResultPage;
import pom.ShippingAddressPage;

public class ShippingAddressTest extends BaseTest{
	NaptoolHomePage naptoolHomePage;
	 ShippingAddressPage shippingAddressPage;
	
	@BeforeMethod
	public void openApplication()
	{
		driver=LaunchBrawser.browser("chrome");
	}
	
	@Test
	 public void verifyShippingAddress() throws InterruptedException
	 {
	    naptoolHomePage = new NaptoolHomePage(driver);
	    
		naptoolHomePage.enterProductName("mobile");
		naptoolHomePage.ClickOnSearchIcon();
		
		ProductResultPage productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
	    ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
	    productDescriptionPage.clickOnClickHereToBuy();
	    
	    CartPage cartPage = new CartPage(driver);
	    cartPage.clickOnProceedToCkeckOut();
	    
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterMobileNo("9881628329");
	    loginPage.clickOnContinueButton();
	    Thread.sleep(50000);
	    loginPage.enterOTP("");
	    loginPage.clickOnsubmit();
	    
	    shippingAddressPage = new ShippingAddressPage(driver);
	    shippingAddressPage.selectTitle("Mrs.");
	    shippingAddressPage.enterFirstName("Priyanka");
	    shippingAddressPage.enterLastName("Jadhav");
	    shippingAddressPage.enterAddress("Baramati");
	    shippingAddressPage.enterLandMark("School");
	    shippingAddressPage.enterPincode("413122");
	    //shippingAddressPage.selectState("MAHARASTRA");
	    shippingAddressPage.enterMobileNo("9730271269");
	    shippingAddressPage.clickOnSaveAndProceed();
	    shippingAddressPage.clickOnShipToThisAddress();
	    shippingAddressPage.clickOnCashOnDelivery();
	    shippingAddressPage.clickOnPlaceOrder();
	    
		OrderSummaryPage order = new OrderSummaryPage(driver);
		double o=order.getTotalAmount(0);
		System.out.println(o);   
		
		
	 }

}
