package Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import io.reactivex.rxjava3.functions.Action;

public class CreateFlag {
	WebDriver driver;

	@FindBy(xpath="//button[@data-id='companyId']") WebElement company;
	@FindBy(xpath="//button[@data-id='companyId']/following-sibling::div/ul/li[2]") WebElement Teleasy;
	@FindBy(xpath="//input[@name='poNumber']") WebElement poNumber;
	@FindBy(xpath="//button[@data-id='marketplaceId']") WebElement marketplace;
	@FindBy(xpath="//button[@data-id='marketplaceId']/following-sibling::div/div/input") WebElement mrkt;
	@FindBy(xpath="//select[@id='departmentId']/following-sibling::div/button") WebElement department;
	
	@FindBy(id="notes") WebElement notes;
	@FindBy(id="orderId") WebElement orderID;
	@FindBy(id="followUpDate") WebElement followUpDate;
//	@FindBy(xpath="//select[@id='modalFlagId']/following-sibling::div/div/ul/li") WebElement
	@FindBy(xpath="//button[@data-id='marketplaceId']/following-sibling::div/ul/li[2]") WebElement amazon;
	@FindBy(xpath="//select[@id='modalFlagId']/following-sibling::div/button") WebElement flag;
	@FindBy(xpath="//select[@id='modalAssignedTo']/following-sibling::div/button") WebElement AssignedTo;
	@FindBy(id="button1") WebElement submitButton;
	@FindBy(id="msgReceivedDate") WebElement msgReceivedDate;
	
	public void setCompanyName() {
		company.click();
		Teleasy.click();
	}
	public void setMarketplace() {
		marketplace.click();
		amazon.click();
//		List<WebElement> marketplaceList= driver.findElements(By.xpath("//button[@data-id='marketplaceId']/following-sibling::div/ul/li/a/span"));
//		int i= ThreadLocalRandom.current().nextInt(2,marketplaceList.size());
//		System.out.println("size is "+marketplaceList.get(i).getText());
//		mrkt.click();
//		mrkt.sendKeys("Amazon");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//		marketplaceList.get(i).click();
		
//		mrkt.sendKeys(marketplaceList.get(i).getText());
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
//		w.until(ExpectedConditions.elementToBeClickable(marketplaceList.get(i)));
//		marketplaceList.get(i).click();
		
	}
	public void setPoNumber() {
	poNumber.sendKeys(RandomStringUtils.randomNumeric(1, 8));
	}
	public void setDepartment() {
		department.click();
		List<WebElement> DeptList=driver.findElements(By.xpath("//select[@id='departmentId']/following-sibling::div/div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(3,4);
		DeptList.get(i).click();
	}
	public void setNotes() {
		String note=RandomStringUtils.randomAlphabetic(2, 20);
		notes.sendKeys(note);
	}
	public void setFollowupDate() {
		followUpDate.sendKeys("2023-01-10");
		followUpDate.sendKeys(Keys.ESCAPE);
	}
	public void setOrderId() {
		orderID.sendKeys(RandomStringUtils.randomNumeric(8));
	}
	public void setFlag() {
		flag.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> flag=driver.findElements(By.xpath("//select[@id='modalFlagId']/following-sibling::div/div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,flag.size());
		flag.get(i).click();
	}
	public void setAssignedTo() {
		AssignedTo.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> assignedToList=driver.findElements(By.xpath("//select[@id='modalAssignedTo']/following-sibling::div/div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,assignedToList.size());
		assignedToList.get(i).click();
	}
	public void messageReceivedDate() {
		msgReceivedDate.sendKeys("2023-01-10");
	}
	public void submit() {
		submitButton.click();
	}
	
	public CreateFlag(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
