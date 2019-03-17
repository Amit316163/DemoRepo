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
		//Read value from your config properties file
		
		loadConfig();
		
		launchbrowser(prop.getProperty("Browser"));
		navigate(prop.getProperty("URL"));
		waits(prop.getProperty("Users_xpath"));
		
		//Verify the condition
		boolean b=driver.findElement(By.xpath("//*[@id='users']/a")).isDisplayed();
		Assert.assertTrue(b, "User");
		
		//Create new user id with valid details
		click(prop.getProperty("Users_xpath"));
		click(prop.getProperty("NewUser_xpath"));
		enterText("Username_id", "Username_value");
		enterText("Password_id", "Password_value");
		enterText("Email_id", "Email_value");
		click(prop.getProperty("CreateUser_name"));
		
		//Validation point-Successfully user id is created 
		String username= driver.findElement(By.xpath("PageTitle_id")).getText();
		if(username.equalsIgnoreCase("Amit0777")) {
			System.out.println("New user ID created successfully");
		}else {
			System.out.println("User ID creation failed");
		}
		
		//Update address for New User 
		click(prop.getProperty("AddressButton"));
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
