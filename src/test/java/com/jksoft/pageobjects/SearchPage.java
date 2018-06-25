package com.jksoft.pageobjects;

import static com.jksoft.utility.Config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
	
	// Intializing locators in Serach Page
	
	private By fromLocation = By.id("from.text");
	private By toLocation = By.id("to.text");
	private By journeyDate = By.className("_1xkf6cj");
	private By ddDateType = By.xpath("//fieldset[@data-test='outbound-datepicker']//child::select[@name='dateType']");
	private By ddHours=By.name("hours");
	private By ddMinutes=By.name("minutes");
	private By btnPassengerSummaryButton=By.id("passenger-summary-btn");
	private By ddAudultsNo=By.name("adults");
	private By ddChildNo=By.name("children");
	private By ddChildAge=By.xpath("//select[@name='child-0']");
	private By btnDone=By.className("_1gc3bztu");
	private By btnGetTickets=By.xpath("//button[@type='submit']");
	
	// Methods in Search Page
	public void setFromLocation()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(fromLocation));
		WebElement weFromLocation = driver.findElement(fromLocation);
		weFromLocation.sendKeys("London");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectLocation("Any");
	}
	
	public void setToLocation()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(toLocation));
		WebElement weToLocation = driver.findElement(toLocation);
		weToLocation.sendKeys("Manchester");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		selectLocation("Any");
	}
	
	public void setJourneyType()
	{
		selectJourneyType("One Way");
	}
	
	public void setDate()
	{
		WebElement dtJourneyDate=driver.findElement(journeyDate);
	  	dtJourneyDate.click();
		selectDatefromMultiDate("30");
		
		WebElement wbdateType=driver.findElement(ddDateType);
		Select seldateType= new Select(wbdateType);
		seldateType.selectByValue("arriveBefore");
	  	
		WebElement wbHours=driver.findElement(ddHours);
		Select selHours= new Select(wbHours);
		selHours.selectByVisibleText("12");
		
		WebElement wbMinutes=driver.findElement(ddMinutes);
		Select selMinutes= new Select(wbMinutes);
		selMinutes.selectByVisibleText("15");
	}
	
	public void clickPassSummaryButton()
	{
		WebElement wbPassengerSummaryButton=driver.findElement(btnPassengerSummaryButton);
		wbPassengerSummaryButton.click();
	}
	
	public void setPassenger(String strPassNo)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(ddAudultsNo));
		WebElement wbAdults=driver.findElement(ddAudultsNo);
		Select selAdults= new Select(wbAdults);
		selAdults.selectByVisibleText(strPassNo);
	}
	
	public void setChildPassenger()
	{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ddChildNo));
		WebElement wbChilds=driver.findElement(ddChildNo);
		Select selChilds= new Select(wbChilds);
		selChilds.selectByVisibleText("1");
	}
	
	public void setChildAge()
	{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ddChildAge));
		WebElement wbChildsAge=driver.findElement(ddChildAge);
		Select selChildsAge= new Select(wbChildsAge);
		selChildsAge.selectByVisibleText("5-15");
	}
	
	
	
	public void clickDone()
	{
		WebElement wbDone=driver.findElement(btnDone);
		wbDone.click();
	}
	
	public void clickGetTickets()
	{
		WebElement wbGetTickets=driver.findElement(btnGetTickets);
		wbGetTickets.click();
	}
	
	
	 public static void selectLocation(String textToSelect) {
		 WebElement autoOptions;
			try {
				if(textToSelect.equalsIgnoreCase("Any"))
				{
				  autoOptions = driver.findElement(By.className("_1isarv8"));
				}
				else
				{
				 autoOptions = driver.findElement(By.className("_1ef1s25"));
				}
				
				wait.until(ExpectedConditions.visibilityOf(autoOptions));

				List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//span[@class='_1ef1s25']"));
				wait.until(ExpectedConditions.visibilityOfAllElements(optionsToSelect));
				for(WebElement option : optionsToSelect){
			        if(option.getText().contains(textToSelect)) {
			            option.click();
			            break;
			        }
			    }
				
				
				
			} catch (NoSuchElementException e) {
				System.out.println(e.getStackTrace());
			}
			catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	
	
	 
	
	public  static void selectJourneyType(String strjourneyType)
	  {
		  List oRadioGroup = driver.findElements(By.name("journeyType"));
		  	
		  	 int iSize = oRadioGroup.size();
		  	 System.out.println(iSize);

		  	 for(int i=0; i < iSize ; i++ ){
		  	   	 
		  		 String sValue = ((WebElement) oRadioGroup.get(i)).getAttribute("value");

		  		 if (sValue.equalsIgnoreCase(strjourneyType)){
		  	 
		  			((WebElement) oRadioGroup.get(i)).click();

		  			 break;
		  	 
		  			 }
		  	 
		  		}
	  }
	
	public static void selectDatefromMultiDate(String date) {
		By calendarXpath=By.xpath("//a[text()='"+date+"']");
		//By calendarXpath=By.xpath("table//td/a[text()='"+date+"']");
		driver.findElement(calendarXpath).click();
	}

}
