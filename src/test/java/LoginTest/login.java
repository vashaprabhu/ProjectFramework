package LoginTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LoginPage.LoginPO;
import Utilities.SFDCTestBase;

public class login extends SFDCTestBase {
	
	
	public WebDriver driver;
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	@BeforeSuite
	public void setting_log4j() throws Exception {
		SFDCTestBase.loadLog4j(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\log4j.properties");
	}
	
	
	@BeforeTest
	public void launchApp() throws IOException
	{
		driver = Browsermethod();
		String address = getUrl();
		driver.get(address);
		log.info("Web app launched");
	}
	
	@Test(dataProvider = "userData")
	public void validateUserLogin(String sUserName, String sPassword) {
		LoginPO lop = new LoginPO(driver);
		
		lop.getEmail().sendKeys(sUserName);
		lop.getPassword().sendKeys(sPassword);
		lop.getRemember().click();
		lop.getLogin().click();
		Assert.assertTrue(lop.getpageLogo().isDisplayed(), "Logo displayed");
		log.info("user login");
	}
	
	
	@DataProvider
	public Object[][] userData() 
	{
		return new Object[][] { {"varsha.ks@salesforce.com", "test123"}};
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
		
		
		
		
	
	

}
