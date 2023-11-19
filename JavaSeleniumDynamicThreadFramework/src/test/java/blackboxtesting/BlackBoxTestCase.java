package blackboxtesting;

import org.openqa.selenium.WebDriver;

public class BlackBoxTestCase {
	
	public static boolean verifyUrlContainsStockName(WebDriver driver, String stockName) {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(stockName);
    }

}
