package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.LaunchBrawser;
import pom.NaptoolHomePage;
import pom.ProductResultPage;

public class ProductSearchTest extends BaseTest{
	
	@BeforeMethod
	public void openApplication()
	{
		driver=LaunchBrawser.chrome();
	}
	@Test
	public void verifyIfProductsAreDisplayedOnValidSearch()
	{
		NaptoolHomePage naptoolhomepage = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.ClickOnSearchIcon();
		String currentTitle=driver.getTitle();
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(currentTitle.contains(" Mobiles"));
		softassert.assertEquals(naptoolhomepage.getCategoryHeading(),"Search Results For : Mobiles");
		ProductResultPage productresultpage = new ProductResultPage(driver);
		softassert.assertTrue(productresultpage.getNumberOfProducts()>0);
		softassert.assertAll();
	}
	@Test
	public void verifyIfProductsAreNotDisplayedOnInvalidSearch()
	{
		NaptoolHomePage naptoolhomepage = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("iphones");
		naptoolhomepage.ClickOnSearchIcon();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("iphones"));
		ProductResultPage productresultpage = new ProductResultPage(driver);
		Assert.assertTrue(productresultpage.getNumberOfProducts()==0);
		
		
	}

}

