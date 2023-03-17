package stepDefinitionFiles;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CreateFlag;
import Pages.ProcessOrders;
import Pages.editFlag;
import Pages.flagListPage;
import Pages.login;
import Pages.orderListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class processOrderSteps {
	WebDriver driver;
	login l;
	orderListPage olp;
	ProcessOrders PO;
	
	@Given("User is on order list page")
	public void user_is_on_order_list_page() {
		System.out.println("user is on flag list page");
		WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/home/login.htm");
		  login l=new login(driver);
		  l.setUsername();
		  l.setPassword();
		  l.clickLogin();
		  driver.get("http://uatteleasy.altius.cc/TelEasyAdminTool/order/marketplaceOrderList.htm");
	}

	@And("selects the order date from")
	public void selects_the_order_date_from() {
		orderListPage olp=new orderListPage(driver);
		olp.startdate();
	}

	@And("clicks on go")
	public void clicks_on_go() {
		orderListPage olp=new orderListPage(driver);
		olp.go();
	}

	@When("user clicks on an order from order list")
	public void user_clicks_on_an_order_from_order_list() {
		orderListPage olp=new orderListPage(driver);
		olp.selectOrder();
	}

	@When("clicks on return and refund")
	public void clicks_on_return_and_refund() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}}
		orderListPage olp=new orderListPage(driver);
		olp.retandref();
	}

	@When("fill all the details")
	public void fill_all_the_details() {
		ProcessOrders PO=new ProcessOrders(driver);
		PO.addallthedetails();
		PO.submit();
	}

}
