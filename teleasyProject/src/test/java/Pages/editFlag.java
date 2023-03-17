package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editFlag {
	WebDriver driver;
	@FindBy(xpath="//textarea[@id='notes']") WebElement notes;
	@FindBy(xpath="//button[@data-id='statusId']") WebElement statusId;
	@FindBy(xpath="//button[text()='Update']") WebElement update;
    
	public void addNotes() {
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
		System.out.println(driver.switchTo().window(child_window).getTitle());
		}
//		String parent=driver.getWindowHandle();
//		for(String window:driver.getWindowHandles()) {	
//			driver.switchTo().window(parent);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		notes.click();
		notes.clear();
		String note=RandomStringUtils.randomAlphabetic(2, 20);
		notes.sendKeys(note);
	}

	public void status() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		statusId.click();
		List<WebElement> statusList=driver.findElements(By.xpath("//select[@id='statusId']/following-sibling::div/div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,statusList.size()-1);
		statusList.get(i).click();
	}

	public void update() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		update.click();
	}
	
	public editFlag(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
