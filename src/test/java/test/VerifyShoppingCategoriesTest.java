package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrawser;
import pom.NaptoolHomePage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class VerifyShoppingCategoriesTest extends BaseTest {
	
	ExtentReports extentReports;
	ExtentTest test;
	@BeforeTest
	public void configureReports() {
		extentReports=Reports.generateReports();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver=LaunchBrawser.chrome();
	}
	@Test
	public void verifyIfUserIsAbleToAccessShoppingCategories()
	{
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.clickOnShopingCategory();
		naptoolHomePage.selectShopingCategories(driver, 3);
		String currentTitle=driver.getTitle();
		Assert.assertTrue(currentTitle.contains(" Mobile Handsets"));
		Assert.assertEquals(naptoolHomePage.getCategoryHeading(),"Mobiles : Mobile Handsets");
	}
	
	@Test
	public void verifyIfUserIsAbleToSearchProduc()
	{
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("cooker");
		naptoolHomePage.ClickOnSearchIcon();
		String currentTitle=driver.getTitle();
		Assert.assertTrue(currentTitle.contains(" cooker"));
		Assert.assertEquals(naptoolHomePage.getCategoryHeading(),"Search Results For : cooker");
	
	
	}
	
	/*
	
	@AfterMethod
	public void postTest()
	{
		driver.close();
	}
	
*/
}
