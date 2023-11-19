package testmain;

import org.openqa.selenium.WebDriver;
import base.WebDriverManager;
import blackboxtesting.BlackBoxTestCase;
import businessrequirementtesting.BusinessRequirementTestCase;
import performancerequirementtesting.PerformanceTestCase;
import testcases.StockPrice;
import whiteboxtesting.WhiteBoxTestCase;


 public class ProjectTestMain {

    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = WebDriverManager.getDriver();
        StockPrice stockPrice = new StockPrice(driver);
        
        // Test case: Verify URL after Search
        try {
        	stockPrice.stockPriceSearch(driver, "TestCase1");
            boolean isUrlCorrect = BlackBoxTestCase.verifyUrlContainsStockName(driver, "Apple");
            System.out.println("Test 1: Verify URL after search: " + (isUrlCorrect ? "Passed" : "Failed"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test case: Database Reader
        boolean isDatabaseReadCorrectly = WhiteBoxTestCase.validateDatabaseReader(20, "TestCases");
        System.out.println("Test 2: Validate Database Reader: " + (isDatabaseReadCorrectly ? "Passed" : "Failed"));

        // Test case: Verify Data in Database
        boolean isDataInDatabaseCorrect = BusinessRequirementTestCase.validateDataInDatabase("187.70", "TestData", "TestCase1", "OpenPrice");
        System.out.println("Test 3: Verify Data in Database: " + (isDataInDatabaseCorrect ? "Passed" : "Failed"));
        
        // Test case: Testcase Execution Time
        boolean isPageLoadTimeValid = PerformanceTestCase.validateTestcaseExecutionTime("TestCase2", 40000);
        System.out.println("Test 4: Validate Page Load Time: " + (isPageLoadTimeValid ? "Passed" : "Failed"));

        // Close the WebDriver
        driver.quit();
    }    

}

