package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCTestBase {
	
	public static WebDriver driver;
	static Properties prop;
	
	public static WebDriver Browsermethod() throws IOException {
		
		prop = new Properties();
		String sDataFilepath = System.getProperty("user.dir")+"\\data.properties";
		FileInputStream fileIn = new FileInputStream(sDataFilepath);
		prop.load(fileIn);
		String sBrowserName = prop.getProperty("browser");
		
		if(sBrowserName.contains("ch"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if(sBrowserName.contains("fire"))
		{			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();		
		return driver;
	}
			
	
	
	public static String getUrl() throws IOException {
		prop = new Properties();
		String sDataFilepath = System.getProperty("user.dir")+"\\data.properties";
		FileInputStream fileIn = new FileInputStream(sDataFilepath);
		prop.load(fileIn);
		String sWebApp = prop.getProperty("Websiteaddrs");
		return sWebApp;
	}
	
	
	public static void loadLog4j(String sLogfilePath) throws Exception {
		prop = new Properties();
		FileInputStream fileIn = new FileInputStream(sLogfilePath);
		prop.load(fileIn);
		PropertyConfigurator.configure(prop);
		
		
	}
	
	public String screenShot(String sTestName, WebDriver driver) throws Exception {
		TakesScreenshot takepic = (TakesScreenshot)driver;
		File source = takepic.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\Screenshot\\"+sTestName+".png";
		File destinFile = new File(destinationPath);
		FileUtils.copyFile(source, destinFile);
		return destinationPath;
	}

}
