package SetupPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class setupPO {
	
public WebDriver driver;
	
	public setupPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "userNavLabel")
	WebElement userLable;
	
	public WebElement getUserLable()
	{
		return userLable;
	}     
	
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement profileLable;
	
	public WebElement getProfileLable()
	{
		return profileLable;
	}
	
	@FindBy(xpath = "//td[contains(@class,'noSidebarCell')]")
	WebElement userPage;
	
	public WebElement getUserPage()
	{
		return userPage;
	}     
	
	

}
