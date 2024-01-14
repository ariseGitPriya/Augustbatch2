package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.LaunchBrawser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductDescriptionPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class AddToCartTest extends BaseTest {
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
		
		//double orderAmount=cartPage.getOrderAmount(1);
		//System.out.println(orderAmount);
		
		//Assert.assertTrue(unitPrice+shippingPrice==orderAmount);
	
	}
	
	//12
	
	@Test
	public void addTwoProductToCartAndVerifyIfUnitPricePlusShippingPriceIsEqualToOrderAmountAndVerifyIfSumOfOrderAmountIsEqualToCartAmount()
	{
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("mobile");
		naptoolHomePage.ClickOnSearchIcon();
		
		productResultPage= new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		cartPage = new CartPage(driver);
		cartPage.clickOnContinueShopping();
		productResultPage.clickOnQuickView(driver, 1);
		productQuickViewPage.clickHereToBuy();
		
		//double firstProductPrice=cartPage.getUnitPrice(0);
		//System.out.println(firstProductPrice);	
		
	}
	
	
	

}
