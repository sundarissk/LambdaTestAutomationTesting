package ModulePackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPageAuto {

	WebDriver driver;

	// Element Locator
	static final By seeallint = By.xpath("//a[contains(text(),'See All Integrations')]//img");

	public MainPageAuto(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void SeeAllIntScrollClick() {

		try {
			WebElement ele = driver.findElement(seeallint);
			Actions action = new Actions(driver);
			action.moveToElement(ele).click().build().perform();

			System.out.println(driver.getCurrentUrl()+"********" + driver.getTitle());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void switchTabsUsingPartOfUrl() {
		String currentHandle = null;
		String platform = "https://www.lambdatest.com/integrations";
		try {
			final Set<String> handles = driver.getWindowHandles();
			if (handles.size() > 1) {
				currentHandle = driver.getWindowHandle();
			} else {
				System.out.println("No Child Window: URL For Main Window *** " + driver.getCurrentUrl());
				if(driver.getCurrentUrl().contains(platform))
				{
					System.out.println("Expected URL Passed but No Child Window Opens");
				}
				else {
					System.out.println("Expected URL Failed but No Child Window Opens");
				}
				
			}
			if (currentHandle != null) {
				for (final String handle : handles) {
					driver.switchTo().window(handle);
					if (driver.getCurrentUrl().contains(platform) && !currentHandle.equals(handle)) {
						break;
					}
				}
			} else {
				for (final String handle : handles) {
					driver.switchTo().window(handle);
					if (driver.getCurrentUrl().contains(platform)) {
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Switching tabs failed");
		}
	}
}
