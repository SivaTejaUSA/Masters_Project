package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
    	String homeDir = System.getProperty("user.dir");
        if (driver.get() == null) {
        	DesiredCapabilities caps = new DesiredCapabilities();
    		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
    		
    		
    		try {
				driver.set(new RemoteWebDriver(new URL("http://192.168.215.49:4444"), caps));
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	   System.setProperty("webdriver.chrome.driver", homeDir+"\\src\\main\\resources\\webdriver\\chromedriver\\chromedriver.exe");
//           driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
