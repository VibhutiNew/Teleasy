package Utilities;

import java.time.Duration;
import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class utility {
	

	public void AddText(WebElement ele) {
		ele.click();
		ele.clear();
		ele.sendKeys(RandomStringUtils.randomAlphabetic(2, 20));
	}
	
	public String GetDate() {
		LocalDate date = LocalDate.now();
		String currentdate  = String.valueOf(date);
	    return currentdate;
	}
	
	public void getNumber(WebElement ele) {
		ele.click();
		ele.sendKeys(RandomStringUtils.randomNumeric(8));
	}
	
	public void fluentWait(int i, WebDriver driver) {
		try {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(i)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class)
;
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
		}catch(Exception e)
		{
			System.out.println("Alert is not present");
		}
	}
	
	public void scrolintoview(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	
}
