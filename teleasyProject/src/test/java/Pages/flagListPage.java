package Pages;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flagListPage {
	WebDriver driver;
 
	@FindBy (xpath="//tr[@class='clickableRow odd'][1]") WebElement newFlag;
	@FindBy (xpath="//span[@class='text-info']") WebElement text;
	@FindBy(id="startDate") WebElement StartDt;
	@FindBy(xpath="//button[text()='Go']") WebElement Go;
	
	public void clickOnFlag() {
		StartDt.click();
		StartDt.clear();
//		StartDt.sendKeys(String.valueOf(LocalDate.of(2022, 01, 01)));
		StartDt.sendKeys("2022-01-01");
		Go.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> flagList=driver.findElements(By.xpath("//tr[@id='editRow']/td[8]"));
		for(WebElement flag:flagList ) {
			System.out.println(flag.getText());
			if(flag.getText().equals("New"))
				flag.click();
			else 
				continue;
		}
	}

	
	public void checkNewFlag() {
		if(text.equals("Your flag is created successfully!"))
		    Assert.assertTrue("New Flag is created Successfully", true);
		else
			Assert.assertFalse("Error in creating new Flag", false);
	}
	
	public void checkEditFlag() {
		if(text.equals("Flag updated successfully"))
			 Assert.assertTrue("Flag is updated Successfully", true);
		else
			Assert.assertFalse("Error in updating Flag", false);
	}

    public flagListPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}