package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
	
	public WebDriver driver;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "username")
	WebElement email;
	
	public WebElement getEmail()
	{
		return email;
	}     
	
	@FindBy(id = "password")
	WebElement password;
	
	public WebElement getPassword()
	{
		return password;
	}
	
	@FindBy(id = "rememberUn")
	WebElement remember;
	
	public WebElement getRemember()
	{
		return remember;
	}
	
	@FindBy(id = "Login")
	WebElement loginButton;
	
	public WebElement getLogin()
	{
		return loginButton;
	}
	
	@FindBy(id = "phHeaderLogoImage")
	WebElement pageLogo;
	
	public WebElement getpageLogo()
	{
		return pageLogo;
	}


}
