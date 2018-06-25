package com.jksoft.pageobjects;

import static com.jksoft.utility.Config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatrixPage {
	
	//intilizing WebElements in Matrix Page
	
	private By radio=By.xpath("//div[@data-test='cheapest-first']//child::div[@class='_mmfn8m']//child::input");
	private By txtGetPrice=By.xpath("//span[@data-test='cjs-price']");
	private By btnContinue=By.xpath("//button[@title='Select your travel preferences and delivery option.']");
	private By btnContinue1=By.xpath("//button[@data-test='cjs-button-continue']");
	
	// Methods in Matrix Page
	
	public void selectFirstClassTicket()
	{
		wait.until(ExpectedConditions.elementToBeClickable(radio));
		List<WebElement> wbselectTicket=driver.findElements(radio);
		
		for(WebElement ticket:wbselectTicket)
		{
			ticket.click();
			break;
		}
	}
	
	public String getPrice()
	{
		WebElement wbtxtGetPrice=driver.findElement(txtGetPrice);
		String strExpectedPrice=wbtxtGetPrice.getText();
		return strExpectedPrice;
		
	}
	
	public void clickContinueButton()
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		
			try {
				Thread.sleep(1000);
				wait.until(ExpectedConditions.presenceOfElementLocated(btnContinue));
				WebElement wbbtnContinue=driver.findElement(btnContinue);
				wbbtnContinue.click();
				/*
				
				wait.until(ExpectedConditions.elementToBeClickable(btnContinue1));
				WebElement wbContinue1=driver.findElement(btnContinue1);
				wbContinue1.click();*/
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
	}
	
	
	
	

}
