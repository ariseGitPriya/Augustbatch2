package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrawser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class AddToCartTest extends BaseTest {
	
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
	

}
