package stepDefinitionFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.login;
import Utilities.baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class loginSteps {
	WebDriver driver;
    login l;
	@Given("user is on login page")
	public void user_is_on_login_page() {
	System.out.println("user is on login page");
	WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/home/login.htm");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		login l=new login(driver);
		System.out.println("user entered username and password");
		l.setUsername();
		l.setPassword();
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws Exception {
		login l=new login(driver);
	    System.out.println("user clicks on login button");
	    l.clickLogin();
	    Thread.sleep(4);
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
	   System.out.println("user is navigated to home page");
	   driver.quit();
	   
	}
}
