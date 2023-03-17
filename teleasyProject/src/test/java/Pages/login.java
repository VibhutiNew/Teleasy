package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.baseclass;

public class login extends baseclass{
 
	WebDriver driver;
	@FindBy(id="j_username") WebElement username;
	@FindBy(id="j_password") WebElement password;
	@FindBy(xpath="//span[text()='Log In']") WebElement loginButton;
	
	public void setUsername() {
		username.sendKeys("super");
	}
	public void setPassword() {
		password.sendKeys("pass1234");
	}
	public void clickLogin() {
		loginButton.click();
	}
	
	public login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
