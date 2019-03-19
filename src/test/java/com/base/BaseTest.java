package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver=null;
	public FileInputStream fis=null;
	public Properties prop=null;	

	@BeforeMethod
	//***Create one Config properties file***
	public void loadConfig() {	

		try {
			if (prop==null) {
				fis=new FileInputStream("Config.properties");
				prop=new Properties();
				prop.load(fis);
			}} catch (Exception e) {

				e.printStackTrace();
			}}
//***Different browser***
	
 	public void launchbrowser(String browserType) {

		if (browserType.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
				
        driver=new ChromeDriver();
        
        }else if (browserType.equals("IE")) {
			System.setProperty("webdriver.IE.driver",
		    System.getProperty(("user.dir")+ "\\resources\\IEDriverServer.exe"));
            driver=new InternetExplorerDriver();
                       
            }else if (browserType.equals("FF")) {
			System.setProperty("webdriver.gecodriver.driver",
			System.getProperty(("user.dir")+ "\\resources\\geckodriver.exe"));
            driver=new FirefoxDriver();
            
            }else {
			Assert.fail();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	//***URL***
	public void navigate (String URL) {
		driver.get(URL);
	}
	
	//***locators***
	public  WebElement getElement (String locatorkey) {
		if(locatorkey.endsWith("_xpath")) {
			return driver.findElement(By.xpath(prop.getProperty(locatorkey)));
		}else if (locatorkey.endsWith("_ID")) {
			return driver.findElement(By.id(prop.getProperty(locatorkey)));
		}else if (locatorkey.endsWith("_name")) {
			return driver.findElement(By.name(prop.getProperty(locatorkey)));
		}else {
			Assert.fail();
			return null;
		}
	}
	//***Text box***
	public void enterText(String locatorkey,String inputvalue) {
		WebElement elm=	getElement(locatorkey);
		elm.sendKeys(inputvalue);

	}
	//***Button***
	public void click(String locatorkey) {
		WebElement elm=	getElement(locatorkey);
		elm.click();
}
	//***Dropdown***
	public void selectDropdownvalue(String locatorkey,String inputvalue) {
		WebElement elm=	getElement(locatorkey);
		Select sel=new Select(elm);
		sel.selectByVisibleText(inputvalue);

	}

	//***Explicit wait***
		public void waits(String locatorkey) {
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorkey)));
		}

}
