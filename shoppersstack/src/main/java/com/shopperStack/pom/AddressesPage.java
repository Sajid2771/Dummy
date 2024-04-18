package com.shopperStack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
	
	public AddressesPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddress;

	public WebElement getAddAddress() {
		return addAddress;
	}
	
	@FindBy (xpath = "(//span[contains(@class,'MuiButton-start')])[2]")
	private WebElement deleteAdd;
	
	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement yesButton;

	public WebElement getDeleteAdd() {
		return deleteAdd;
	}

	public WebElement getYesButton() {
		return yesButton;
	}
	
	@FindBy(xpath = "//span[contains(@class,'BaseBadge-badge')]")
	private WebElement acSettings;
	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logOut;

	public WebElement getAcSettings() {
		return acSettings;
	}

	public WebElement getLogOut() {
		return logOut;
	}
		
}
