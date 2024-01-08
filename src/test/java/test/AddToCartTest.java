package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
	CartPage cartpage;

	
	@BeforeMethod
	public void openApplication()
	{
		driver=LaunchBrawser.chrome();
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
		productquickviewpage.clickOnClickHereToBuy();
		
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
		productQuickViewPage.clickOnClickHereToBuy();
		
	    cartpage = new CartPage(driver);
	    cartpage.clickOnContinueShopping();
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		
		productQuickViewPage.clickOnClickHereToBuy();
		cartpage=new CartPage(driver);
		Assert.assertEquals(cartpage.getNumberOfProductPresentInCart(driver),2);
		
		
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
		productquickviewpage.clickOnClickHereToBuy();
		
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
		String productTitle=productresultpage.getProductTitle(0);
		productresultpage.clickOnProduct(0);
		productresultpage.switchPage(driver,productTitle);
		
		ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
		productDescriptionPage.clickOnClickHereToBuy();
		
		
		
		
	}
	

}
