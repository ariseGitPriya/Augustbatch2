package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public void switchPage(WebDriver driver,String expectedTitle)
	{
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		while(i.hasNext())
		{
			String handle=i.next();
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(expectedTitle))
			{
				break;
			}
		}
	}

}
