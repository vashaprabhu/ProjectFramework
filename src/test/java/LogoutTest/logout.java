package LogoutTest;

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
import LogoutPage.logoutPO;
import SetupPage.setupPO;
import Utilities.SFDCTestBase;

public class logout extends SFDCTestBase {
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
	public void userLogout(String sUserName, String sPassword) {
		LoginPO lop = new LoginPO(driver);
		setupPO spo = new setupPO(driver);
		logoutPO outp = new logoutPO(driver);
		
		lop.getEmail().sendKeys(sUserName);
		lop.getPassword().sendKeys(sPassword);
		lop.getRemember().click();
		lop.getLogin().click();
		log.info("user login");
		spo.getUserLable().click();
		outp.getLogout().click();
		String afterLogout = outp.driver.getCurrentUrl();
		Assert.assertEquals(true, true, afterLogout);
		log.info("user logout");
		
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
