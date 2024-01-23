package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrawser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.OrderSummaryPage;
import pom.ProductDescriptionPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class AddToCartTest extends BaseTest {
	
	ExtentReports extentReports;
	ExtentTest test;
	@BeforeTest
	public void configureReports() {
	extentReports=Reports.generateReports();
	}
	
	
	ProductResultPage productResultPage;
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;

	//@Parameters({"browser"})
	@BeforeMethod
	public void openApplication()
	{
		driver=LaunchBrawser.browser("chrome");
	}
	
	@Test
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption()
	{
		test=extentReports.createTest("verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption");
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.ClickOnSearchIcon();
		
		ProductResultPage productresultpage = new ProductResultPage(driver);
		productresultpage.clickOnQuickView(driver, 0);
		
		ProductQuickViewPage productquickviewpage = new ProductQuickViewPage(driver);
		productquickviewpage.clickHereToBuy();
		
		CartPage cartpage = new CartPage(driver);
		Assert.assertEquals(cartpage.getNumberOfProductPresentInCart(driver), 1);
		
		
	}
	
	@Test
	public void verifyIfUserIsAbleToAddMultipleProductToCart()
	{
		test=extentReports.createTest("verifyIfUserIsAbleToAddMultipleProductToCart");
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.ClickOnSearchIcon();
		 
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
	    cartPage = new CartPage(driver);
	    cartPage.clickOnContinueShopping();
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		
		productQuickViewPage.clickHereToBuy();
		cartPage=new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductPresentInCart(driver),2);
		
		
	}
	
	@Test
	public void verifyIfUserAbleToRemoveProductFromCart()
	{
		test=extentReports.createTest("verifyIfUserAbleToRemoveProductFromCart");
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.ClickOnSearchIcon();
		
		ProductResultPage productresultpage = new ProductResultPage(driver);
		productresultpage.clickOnQuickView(driver, 0);
		
		ProductQuickViewPage productquickviewpage = new ProductQuickViewPage(driver);
		productquickviewpage.clickHereToBuy();
		
		CartPage cartpage = new CartPage(driver);
		Assert.assertEquals(cartpage.getNumberOfProductPresentInCart(driver),1);
		cartpage.clickOnRemove(driver);
		
		
	}
	
	@Test
	public void verifyIfUserAbleToAddToCartUsingProductDescription()
	{
		test=extentReports.createTest("verifyIfUserAbleToAddToCartUsingProductDescription");
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.ClickOnSearchIcon();
		
		ProductResultPage productresultpage = new ProductResultPage(driver);
		String productTitle=productresultpage.getProductName(0);
		productresultpage.clickOnProduct(0);
		productresultpage.switchPage(driver,productTitle);
		
		ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
		productDescriptionPage.clickOnClickHereToBuy();
		
	}
	//9 
	@Test
	public void VerifyProdutsDetailsDisplayedInProductSearchResultIsSimilarToDetailsDisplayedInQuickViewTab()
	{
		test=extentReports.createTest("VerifyProdutsDetailsDisplayedInProductSearchResultIsSimilarToDetailsDisplayedInQuickViewTab");
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("mobile");
		naptoolHomePage.ClickOnSearchIcon();
		
		productResultPage = new ProductResultPage(driver);
		String expectedProductName=productResultPage.getProductName(0);
	    double expectedPrice=productResultPage.getPrice(0);
		
	    productResultPage.clickOnQuickView(driver, 1);
	    
	    ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
	    Assert.assertEquals(productQuickViewPage.getPrice(),expectedPrice );
	   // Assert.assertEquals(productQuickViewPage.getProductName(1),expectedProductName);
	
		
	}
	//10
	@Test
	public void verifyIfProductDetailOnShoppingCartAreSimilarToProductAddedFromQuickViewTab()
	{
		test=extentReports.createTest(" verifyIfProductDetailOnShoppingCartAreSimilarToProductAddedFromQuickViewTab");
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("mobile");
		naptoolHomePage.ClickOnSearchIcon();
		
	    productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		
		ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
		String expectedProductName=productQuickViewPage.getProductName(0);
		double expectedPrice=productQuickViewPage.getPrice();
		double expectedShippingCharges=productQuickViewPage.getShippingCharges();
		
		productQuickViewPage.clickHereToBuy();
		
		cartPage= new CartPage(driver);
		Assert.assertEquals(cartPage.getProductName(0, driver), expectedProductName);
		Assert.assertEquals(cartPage.getUnitPrice(1), expectedPrice);
		Assert.assertEquals(cartPage.getShippingPrice(1), expectedShippingCharges);
		
	}
	
	//11
	@Test
	public void addSingleProductToCartAndVerifyIfUnitPricePlusShippingPriceIsEqualToOrderAmount()throws InterruptedException{
		test=extentReports.createTest("addSingleProductToCartAndVerifyIfUnitPricePlusShippingPriceIsEqualToOrderAmount");
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("mobile");
		naptoolHomePage.ClickOnSearchIcon();
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		cartPage = new CartPage(driver);
		double unitPrice=cartPage.getUnitPrice(1);
		System.out.println(unitPrice);
		
		double shippingPrice=cartPage.getShippingPrice(1);
		System.out.println(shippingPrice);
		
		double orderAmount=cartPage.getOrderAmount(driver,1);
		System.out.println(orderAmount);
		
		Assert.assertTrue(unitPrice+shippingPrice==orderAmount);
	
	}
	
	//12
	
	@Test
	public void addTwoProductToCartAndVerifyIfUnitPricePlusShippingPriceIsEqualToOrderAmountAndVerifyIfSumOfOrderAmountIsEqualToCartAmount() throws InterruptedException
	{
		test=extentReports.createTest("addTwoProductToCartAndVerifyIfUnitPricePlusShippingPriceIsEqualToOrderAmountAndVerifyIfSumOfOrderAmountIsEqualToCartAmount");
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("cooker");
		naptoolHomePage.ClickOnSearchIcon();
		
		productResultPage= new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		cartPage = new CartPage(driver);
		cartPage.clickOnContinueShopping();
		productResultPage.clickOnQuickView(driver, 1);
		productQuickViewPage.clickHereToBuy();
		
		double orderAmount1=cartPage.getOrderAmount(driver,0);
		System.out.println(orderAmount1);
		double orderAmount2= cartPage.getOrderAmount(driver,1);
		System.out.println(orderAmount2);
        double expectedCartAmount=cartPage.getCartAmount();
		Assert.assertTrue(orderAmount1+orderAmount2==expectedCartAmount);
			
		
	}

	

	/*
	@AfterTest
	public void publishReports() {
		extentReports.flush();
	}
	*/	
	
	
	
	
	

}
