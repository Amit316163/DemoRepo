package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CreateAccount1 extends BaseTest{
	
	public String TestCaseName="CreateValidCustomerIDTC";
	
	@Test
	public void CreateAccountTC() {
		// Read value from your config properties file
		loadConfig();
		launchbrowser(prop.getProperty("Browser"));
		navigate("URL");
	      //waits(prop.getProperty("Users_xpath"));
		// Verify the condition
		boolean b = getElement("Displayeduser_xpath").isDisplayed();
		Assert.assertTrue(b, "User");
		// Create new user id with valid details
		click("Users_xpath");
		click("NewUser_xpath");
		enterText("Username_id", "Username_name");
		enterText("Password_id", "Password_name");
		enterText("Email_id", "test1234@hotmail.com");
		click("CreateUser_name");

		// Validation point-Successfully user id is created
		String username = getElement("PageTitle_id").getText();
		if (username.equalsIgnoreCase("Amit0777")) {
			System.out.println("New user ID created successfully");
		} else {
			System.out.println("User ID creation failed");
		}

		// Update address for New User
		click("AddressButton_xpath");
		enterText("FullName_id", "Amit Singh");
		enterText("AddressLine1_id", "10 wall st");
		enterText("City_id", "Albany");
		enterText("State_id", "New York");
		enterText("ZipCode_id", "23352-8547");
		
		selectDropdownvalue("Country_dropdown", "US");
		
		click(prop.getProperty("CreateUserNameAddress_name"));
		//Address updated response and print the message on console
		String address=driver.findElement(By.xpath("//*[@class='flash flash_notice']")).getText();
		System.out.println(address);
		
		//click on user link and navigate to home page
		click(prop.getProperty("UserLink_xpath"));
		
		//Validate address on home page
		String fullname=driver.findElement(By.xpath("//*[@id=\"user_address_3\"]/td[1]/a")).getText();
		if(fullname.equalsIgnoreCase("Amit Singh")) {
			System.out.println("Address updated successfully");
		}else {
			System.out.println("Address not updated successfully");
		}
		/*We can perform other task as well on home page like 
		*Total orders,Total Value,Order History and so on
		*Edit user and update details
		*Delete user and verify after deletion,User data should not be exist  
		*/
		
		System.out.println("running"+TestCaseName);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
