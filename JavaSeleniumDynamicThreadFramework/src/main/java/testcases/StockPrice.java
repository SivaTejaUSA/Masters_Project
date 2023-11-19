package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.DatabaseReader;
import mainpackage.TestRunner;
import base.BasePage; 

public class StockPrice {
	
	DatabaseReader reader=TestRunner.getDatabaseReader();
    BasePage basePage;  // Declare BasePage instance
    
    public StockPrice(WebDriver driver) {
        basePage = new BasePage(driver);  // Initialize BasePage instance
    }
	
    public boolean stockPriceSearch(WebDriver driver, String testCaseName) throws InterruptedException {
    	driver.manage().window().maximize();
        basePage.navigateToUrl("https://www.google.com");  // Using BasePage method
        Thread.sleep(5000);

        // Using BasePage method to send keys
        String stockName = this.reader.getValue("TestData", testCaseName, "stockname")+ " Stock Price";
        By searchBoxLocator = By.name("q");
        basePage.sendKeys(searchBoxLocator, stockName);  
        Thread.sleep(3000);

        // Submitting the form using BasePage
        
        basePage.pressEnter(searchBoxLocator); 
        Thread.sleep(5000);
        

        WebElement table = driver.findElement(By.className("CYGKSb"));

        // Locate the rows within the table
        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Loop through the rows to find and print the "Open," "High," and "Low" prices
        for (WebElement row : rows) {
            // Locate the cells within each row
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));

            // Check if the row contains data
            if (cells.size() == 2) {
                // Extract the text content of the first cell (label)
                String label = cells.get(0).getText()+"Price";

                // Extract the text content of the second cell (value)
                String value = cells.get(1).getText().replace(",", "");

                // Print the label and value
                this.reader.updateValue("TestData", testCaseName, label, value);
                Thread.sleep(2000);
            }
        }
        
        return true;
    }

}
