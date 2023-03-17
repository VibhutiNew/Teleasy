package Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderListPage {
	 WebDriver driver;
	 @FindBy(id="startDate") WebElement startdate;
	 @FindBy(xpath="//input[@value='Go']") WebElement Go;
	 @FindBy(xpath="//a[text()='Return & Refund' and @role='tab']") WebElement retandref;
	 
	 public void startdate() {
		 startdate.clear();
		 startdate.sendKeys("2022-08-01");
	 }
	 
	 public void go() {
		 Go.click();
	 }
	 
	public void selectOrder() {
		List<WebElement> ordr=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr"));
		int i= ThreadLocalRandom.current().nextInt(1,ordr.size()-1);
		ordr.get(i).click();
	}
	 
	public void retandref(){
		retandref.click();
	}
	 
	 public orderListPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
}
