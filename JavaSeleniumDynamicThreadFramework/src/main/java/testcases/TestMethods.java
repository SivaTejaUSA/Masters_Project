package testcases;

import java.io.File;
import java.io.IOException;
//import mainpackage.TestRunner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.WebDriverManager;

public class TestMethods {

	 public synchronized void captureAndSaveScreenshot(String screenshotName, boolean passed) {
	        WebDriver driver = WebDriverManager.getDriver();
	        String homeDir = System.getProperty("user.dir");
	        if (driver instanceof TakesScreenshot) {
	            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
	            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
	            String screenshotPath = homeDir+"\\src\\main\\resources\\screenshots\\" + screenshotName + ".png";
	            try {
	                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
    public boolean method1(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method1: "+passed);
        }
		return passed;
    }

    public boolean method2(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method2: "+passed);
        }
		return passed;
    }

    public boolean method3(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method3: "+passed);
        }
		return passed;
    }

    public boolean method4(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method4: "+passed);
        }
		return passed;
    }

    public boolean method5(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method5: "+passed);
        }
		return passed;
    }

    public boolean method6(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method6: "+passed);
        }
		return passed;
    }

    public boolean method7(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
    }

    public boolean method8(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method8: "+passed);
        }
		return passed;
    }
    
    public boolean method9(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
    }
    
    public boolean method10(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
    }
    
    public boolean method11(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method12(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method13(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method14(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method15(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method16(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method17(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method18(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method19(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method20(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method21(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method22(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method23(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method24(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method25(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method26(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method27(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method28(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method29(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    public boolean method30(String ScreenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, ScreenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(ScreenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
}
