package stepDefinitionFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CreateFlag;
import Pages.editFlag;
import Pages.flagListPage;
import Pages.login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class editFlagSteps {
	WebDriver driver;
	login l;
	CreateFlag cf;
	flagListPage flp;
	editFlag ef;
	
	@Given("user is on flag list page")
	public void user_is_on_flag_list_page() {
		System.out.println("user is on flag list page");
		WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/home/login.htm");
		  login l=new login(driver);
		  l.setUsername();
		  l.setPassword();
		  l.clickLogin();
		  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/flags/listAllFlags.htm");
	}

	@When("user clicks on the flag")
	public void user_clicks_on_the_flag() {
		flp=new flagListPage(driver);
	    flp.clickOnFlag();
	}

	@And("add the comments")
	public void add_the_comments() {
	    ef=new editFlag(driver);
	    ef.addNotes();
	}

	@And("update the status")
	public void update_the_status() {
		ef=new editFlag(driver);
		ef.status();
	}

	@And("clicks on update")
	public void clicks_on_update() {
		ef=new editFlag(driver);
		ef.update();
	}

	@Then("flag is edited")
	public void flag_is_edited() {
		flp=new flagListPage(driver);
		flp.checkEditFlag();
	}
	
	@And("visible in the View All Flags list")
	public void visible_in_the_view_all_flags_list() {
	    System.out.println("flag is visible in Flag list page");
	}

}
