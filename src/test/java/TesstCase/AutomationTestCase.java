package TesstCase;

import org.testng.annotations.Test;

import BasePackage.DriverClassAuto;
import ModulePackage.MainPageAuto;

public class AutomationTestCase extends DriverClassAuto {
	@Test
	public void TestScenario() {
		
		MainPageAuto ma = new MainPageAuto(driver);
		ma.SeeAllIntScrollClick();
		ma.switchTabsUsingPartOfUrl();
		
		
	}

}
