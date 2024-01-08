package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptoolHomePage {
	
	@FindBy (xpath=("//a[@id='login-panel-link']"))private WebElement login;
	@FindBy (xpath="//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy (xpath="//span[@class='arrowNav']")private WebElement shopingCategory;
	@FindBy(xpath="//span[@class='arrowNav']")private WebElement shoppingCategoriesDropdown;
	@FindBy (xpath="//ul[@id='mainMenu_UL']//li")private List<WebElement> categories;
	@FindBy (xpath="(//a[text()='Mobile Handsets'])[1]")private WebElement subCategories;
	@FindBy (xpath="//li[@class='head']//h1")private WebElement categoryHeadings;
	@FindBy (xpath="//input[@name='header_search_text']")private WebElement searchTab;
	@FindBy (xpath="(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement searchIcon;
	@FindBy (xpath="(//a[@id='cart-panel-link'])[2]")private WebElement addToCart;
	
	public NaptoolHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	public void clickOnTrack()
	{
		trackOrder.click();
	}
	public void clickonshoppingCategoriesdropdown() 
	{
		shoppingCategoriesDropdown.click();
	}
	public void selectShopingCategories(WebDriver driver,int index)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(categories.get(index));
		actions.perform();
		subCategories.click();
	}
	public String getCategoryHeading()
	{
		return categoryHeadings.getText();
	}
	public void clickOnShopingCategory()
	{
		shopingCategory.click();
	}
	public void enterProductName(String product)
	{
		searchTab.sendKeys(product);
	}
	
	public void ClickOnSearchIcon()
	{
		searchIcon.click();
	}
	public void clickOnAddToCart()
	{
		addToCart.click();
	}

}
