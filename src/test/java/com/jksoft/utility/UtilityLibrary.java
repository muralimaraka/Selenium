package com.jksoft.utility;

import static com.jksoft.utility.Config.wait;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UtilityLibrary {
	
	public static Boolean pageReady()
	{
	ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState")
                    .toString().equals("complete");
        }

		
    };
    return wait.until(jsLoad);
}
	
	
	public static void waitForPageLoaded() 
	{
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(5000);
            WebDriverWait wait1 = new WebDriverWait(Config.driver, 30);
            wait1.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
