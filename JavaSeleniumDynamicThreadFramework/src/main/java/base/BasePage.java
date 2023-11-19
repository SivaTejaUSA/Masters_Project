package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public synchronized void navigateToUrl(String url) {
        driver.get(url);
    }

    public synchronized void click(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }
    
    public synchronized void pressEnter(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        element.sendKeys(Keys.ENTER);
    }

    public synchronized void sendKeys(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public synchronized String getText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    public synchronized void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public synchronized WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public synchronized WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}

