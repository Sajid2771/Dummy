package com.shoppersstack_testScript;

import org.testng.annotations.Test;	

import com.aventstack.extentreports.Status;
import com.shopperStack.generalUtility.BaseTest;
import com.shopperStack.pom.AddressesPage;
import com.shopperStack.pom.MyProfilePage;

public class Verify_User_Is_Able_To_Delete_Address_Test extends BaseTest{
	
	
	@Test 
	public void deleteAdd() throws InterruptedException {
		
		test.log(Status.INFO, "Verify User Is Able Navigate To HomePage");
		hPage.getAcSettings().click();
		hPage.getMyProfile().click();
		
		test.log(Status.INFO, "Verify User Is Able Navigate To MyProfile Page");
		MyProfilePage mProfilePage= new MyProfilePage(driver);
		mProfilePage.getMyAdd().click();
		
		test.log(Status.INFO, "Verify User Is Able Navigate To MyAddresses Page");
		AddressesPage addPage= new AddressesPage(driver);
		addPage.getDeleteAdd().click();
		Thread.sleep(1000);
		addPage.getYesButton().click();
		Thread.sleep(2000);	
		driver.switchTo().alert().dismiss();
		
		
		test.log(Status.INFO, "Verify User Is Able Delete Address");
		addPage.getAcSettings().click();
		addPage.getLogOut().click();
		
		
	
	}
}
