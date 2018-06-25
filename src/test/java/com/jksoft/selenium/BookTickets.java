package com.jksoft.selenium;
import static com.jksoft.utility.UtilityLibrary.*;

import org.testng.annotations.Test;
import com.jksoft.pageobjects.*;

import com.jksoft.pageobjects.SearchPage;
import com.jksoft.utility.BaseClass;
import com.jksoft.utility.UtilityLibrary;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.jksoft.utility.Config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class BookTickets extends BaseClass{
  
	

	  @Test
	  public void bookAdultTicket() {
		  
		  SearchPage objSearchPage=PageFactory.initElements(driver, SearchPage.class);
		  MatrixPage objMatrixPage=PageFactory.initElements(driver, MatrixPage.class);
		  SelectDeliveryOptionPage objDeliveryOptions=PageFactory.initElements(driver, SelectDeliveryOptionPage.class);
		  SignInPage objSignInPage=PageFactory.initElements(driver, SignInPage.class);
		  CheckoutPage objCheckoutPage=PageFactory.initElements(driver, CheckoutPage.class);
		 
		  // Calling methods to perform actions on search page
		  objSearchPage.setFromLocation();
		  objSearchPage.setToLocation();
		  objSearchPage.setJourneyType();
		  objSearchPage.setDate();
		  objSearchPage.clickPassSummaryButton();
		  objSearchPage.setPassenger("2");
		  objSearchPage.clickDone();
		  objSearchPage.clickGetTickets();
		  
		  //Calling methods to perform action on Matrix Page
		  waitForPageLoaded();
		  objMatrixPage.selectFirstClassTicket();
		  String strExpectedPrice=objMatrixPage.getPrice();
		  objMatrixPage.clickContinueButton();
		  
		  //Calling methods to perform actions on travel options page
		  waitForPageLoaded();
		  objDeliveryOptions.clickContinueButton();
		 
		  //Calling methods to perform actions in sign in page
		  waitForPageLoaded();
		  objSignInPage.selectSignOption();
		  objSignInPage.setEmailAddress();
		  objSignInPage.clickGuest();
		  
		  //Calling methods to perform actions on Delivery options page
		  waitForPageLoaded();
		  objDeliveryOptions.clickContinueButton();
		  
		  waitForPageLoaded();
		  String strActualPirce=objCheckoutPage.getPriceInCheckOutPage();
		  
		  Assert.assertEquals(strExpectedPrice, strActualPirce);
		  
		  
		  }	
}
