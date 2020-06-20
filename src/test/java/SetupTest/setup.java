package SetupTest;

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
import SetupPage.setupPO;
import Utilities.SFDCTestBase;

public class setup extends SFDCTestBase {
	
public WebDriver driver;

	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	@BeforeSuite
	public void setting_log4j() throws Exception {
		loadLog4j(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\log4j.properties");
	}
	
	
	@BeforeTest
	public void launchApp() throws IOException
	{
		driver = Browsermethod();
		String address = getUrl();
		driver.get(address);
		log.info("app launched");
	}
	
	@Test(dataProvider = "userData")
	public void userAccount(String sUserName, String sPassword) {
		LoginPO lop = new LoginPO(driver);
		setupPO spo = new setupPO(driver);
		
		lop.getEmail().sendKeys(sUserName);
		lop.getPassword().sendKeys(sPassword);
		lop.getRemember().click();
		lop.getLogin().click();
		spo.getUserLable().click();
		log.info("user login");
		spo.getProfileLable().click();
		Assert.assertEquals(true, true, "User Account page");
		log.info("user in profile page");
		
	}
	
	@DataProvider
	public Object[][] userData() 
	{
		return new Object[][] {{"varsha.ks@salesforce.com", "test@123"}};
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	

}
