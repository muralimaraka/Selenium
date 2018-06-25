package com.jksoft.utility;

import static com.jksoft.utility.Config.driver;
import static com.jksoft.utility.Config.wait;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	String URL = "https://www.thetrainline.com/";
	
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
		  	driver = new ChromeDriver();
			//driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 15);
			driver.navigate().to(URL);
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
}
