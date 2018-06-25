package com.jksoft.pageobjects;

import static com.jksoft.utility.Config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
	
	//intilizing WebElements in SignIn Page
	
	/*private By lnkRegister=By.xpath("//a[@title='Register']");
	private By tbEmail=By.id("email");
	private By tbPassword=By.id("password");
	private By tbFirstName=By.id("firstName");
	private By tbSurName=By.id("surname");
	private By tbPostCode=By.id("postcode");
	private By btnFindAddress=By.className("_1dxixy4r");*/
	
	private By radioSignIn=By.id("isGuest");
	private By tbEmail=By.id("email");
	private By buttonGuest=By.xpath("//button[@type='submit']");
	
	// Methods in Matrix Page
	
	public void selectSignOption()
	{
		WebElement wbradioSignIn=driver.findElement(radioSignIn);
		wbradioSignIn.click();
	}
	
	public void setEmailAddress()
	{
		WebElement wbtbEmail=driver.findElement(tbEmail);
		wbtbEmail.sendKeys("muralikrishna.maraka@gmail.com");
	}
	
	public void clickGuest()
	{
		WebElement wbButtonGuest=driver.findElement(buttonGuest);
		wbButtonGuest.click();
	}

}
