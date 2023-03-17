package stepDefinitionFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CreateFlag;
import Pages.flagListPage;
import Pages.login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class createFlagSteps {
	WebDriver driver;
	login l;
	CreateFlag cf;
	flagListPage flp;
	@Given("user is on create flag page")
	public void user_is_on_create_flag_page() {
		System.out.println("user is on create flag page");
		WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/home/login.htm");
		  login l=new login(driver);
		  l.setUsername();
		  l.setPassword();
		  l.clickLogin();
		  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/flags/createFlag.htm");
	}

	@When("user enters company name")
	public void user_enters_company_name() {
	   cf=new CreateFlag(driver);
	   cf.setCompanyName();
	}

	@And("marketplace")
	public void marketplace() {
		cf=new CreateFlag(driver);
		cf.setMarketplace();
	}

	@And("Po number")
	public void po_number() {
		cf=new CreateFlag(driver);
		cf.setPoNumber();
	}

	@And("Department")
	public void department() {
		cf=new CreateFlag(driver);
		cf.setDepartment();
	}

	@When("notes")
	public void notes() {
		cf=new CreateFlag(driver);
		 cf.setNotes();
	}

	@And("followup Date")
	public void followup_date() {
		cf=new CreateFlag(driver);
		cf.setFollowupDate();
	}

	@And("order Id")
	public void order_id() {
		cf=new CreateFlag(driver);
		cf.setOrderId();
	}

	@And("flag")
	public void flag() {
		cf=new CreateFlag(driver);
		cf.setFlag();
	}

	@And("AssignedTo")
	public void assigned_to() {
		cf=new CreateFlag(driver);
		cf.setAssignedTo();
	}

	@And("click on submit")
	public void click_on_submit() {
		cf=new CreateFlag(driver);
		cf.submit();
	}
	
	@Then("Flag is created")
	public void flag_is_created() {
	   flp=new flagListPage(driver);
	   flp.checkNewFlag();
	}
	
    @And("is visible in the View All Flags list")
    public void is_visible_in_the_view_all_flags_list() {
        System.out.println("flag is visible in view all flags");
        driver.close();
    }
}
