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

public class OrderSummaryTest extends BaseTest {
	
	NaptoolHomePage naptoolHomePage;
	ShippingAddressPage shippingAddressPage;

	    //@Parameters({"browser"})
		@BeforeMethod
		public void openApplication()
		{
			driver=LaunchBrawser.browser("chrome");
		}
		
		@Test
		public void verifyTotalAmountOnOrderSummaryEqualtoTotalAmountOnCartPage() throws InterruptedException
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
			    loginPage.enterMobileNo("9730271269");
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
			
			    OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
			    double totalAmount=orderSummaryPage.getTotalAmount();
			    System.out.println(totalAmount);
			    
			    String productName=orderSummaryPage.getProductName();
			    System.out.println(productName);
			    
			    
			    
		}
		
}
