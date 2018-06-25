package com.jksoft.pageobjects;

import static com.jksoft.utility.Config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectDeliveryOptionPage {
	
	//intilizing WebElements in Select Delivery Option Page
	
	private By ContinueToCheckOut=By.xpath("//button[@class='_ixvcez6']");
	
	
	public void clickContinueButton()
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			wait.until(ExpectedConditions.presenceOfElementLocated(ContinueToCheckOut));
			WebElement wbContinueToCheckOut=driver.findElement(ContinueToCheckOut);
			wbContinueToCheckOut.click();
		
		}
		
		
		
	}


