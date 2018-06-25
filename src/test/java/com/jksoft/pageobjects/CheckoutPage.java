package com.jksoft.pageobjects;

import static com.jksoft.utility.Config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	//intilizing WebElements in CheckOut Page
	private By txtPriceInCheckOut=By.xpath("//span[@data-test='trip-card-total']");
	private By childLableInCheckOut=By.xpath("//span[@data-test='children']");
	//span[@data-test='children']
	
	public String getPriceInCheckOutPage()
	{
		WebElement wbtxtGetPrice=driver.findElement(txtPriceInCheckOut);
		String strActualPrice=wbtxtGetPrice.getText();
		return strActualPrice;
		
	}
	
	public String getChildLableInCheckOutPage()
	{
		WebElement wbtchildLable=driver.findElement(childLableInCheckOut);
		String strChildLable=wbtchildLable.getText();
		return strChildLable;
		
	}

}
