package Pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.utility;

public class ProcessOrders extends utility {
  WebDriver driver;
	@FindBy(id="requestRecceivedDate") WebElement ReqReceivedDate;
	@FindBy(xpath="//button[@data-id='cancellationReasonId']") WebElement custReqReason;
	@FindBy(xpath="//button[@data-id='packagingStatusId']") WebElement packagingStatus;
	@FindBy(id="buyerComments") WebElement buyerComments;
	@FindBy(id="authorizationDate") WebElement AuthDate;
	@FindBy(xpath="//button[@data-id='authorizationId']" ) WebElement AuthStatus;
	@FindBy(id="returnAuthorizationComments" ) WebElement Authcomments;
	@FindBy(id="TeleasyRMADate") WebElement TelDate;
	@FindBy(xpath="//input[@id='TeleasyRMANo']" ) WebElement TelRMANo;
	@FindBy(id="teleasyRmaComments" ) WebElement TelRMAComm;
	@FindBy(xpath="//button[@data-id='labelProvidedId']") WebElement labelProvided;
	@FindBy(xpath="//button[@data-id='shippingCarrierId']") WebElement shipCarrierId;
	@FindBy(id="labelCostid") WebElement labelCostId;
	@FindBy(id="returnTrackingNoId") WebElement retTackNo;
	@FindBy(id="custReturnShippingCarrier") WebElement custReturnShipngCar;
	@FindBy(id="customerReturnTrackingNoId") WebElement CustRetTrackNo;
	@FindBy(id="custReturnDate") WebElement returnETA;
	@FindBy(id="returnShippingComments") WebElement retShipngComm;
	@FindBy(xpath="//button[@data-id='returnStatusId']") WebElement retStatusID;
	@FindBy(id="returnReceivedDate") WebElement retRecDate;
	@FindBy(id="teleasyReturnId") WebElement TelRetID;
	@FindBy(id="returnStatusComments") WebElement retStatusCom;
	@FindBy(xpath="//button[@data-id='inventoryStatusId']") WebElement invStatusID;
	@FindBy(xpath="//button[@data-id='inventorySubStatusId']") WebElement invSubStatus;
	@FindBy(id="mFRRequested") WebElement MFRrequested;
	@FindBy(id="inventoryRefundComments") WebElement invRefundComm;
	@FindBy(id="vendorReturnTrackingNo") WebElement vendRetTrackingNo;
	@FindBy(id="labelSharedDate") WebElement lablShrdDt;
	@FindBy(id="trackingStatus") WebElement trackStatus;
	@FindBy(id="deliveryDate") WebElement DelDt;
	@FindBy(id="vendorMFRefundComments") WebElement vendMFRComm;
	@FindBy(id="customerRefundedDate") WebElement custRefDt;
	@FindBy(id="customerRefundedAmount") WebElement CustRefAmt;
	@FindBy(xpath="//button[@data-id='refundTypeId']") WebElement RefType;
	@FindBy(id="refundComments") WebElement refComm;
	@FindBy(id="vendorRefundDate") WebElement vendRefDt;
	@FindBy(id="vendorRefundedAmount") WebElement VendRefAmt;
	@FindBy(id="vendorRefundComments") WebElement vendRefComm;
	@FindBy(xpath="//button[@onclick='insertProcessedOrderStatusTrans()']") WebElement submit;
	@FindBy(xpath="//button[@id='btnClose' and @onclick='closeWin();']") WebElement close;
	utility ut=new utility();
//	public void AddText(WebElement ele) {
//		ele.click();
//		ele.clear();
//		ele.sendKeys(RandomStringUtils.randomAlphabetic(2, 20));
//	}
//	
//	public String GetDate() {
//		LocalDate date = LocalDate.now();
//		String currentdate  = String.valueOf(date);
//	    return currentdate;
//	}
//	
//	public void getNumber(WebElement ele) {
//		ele.click();
//		ele.sendKeys(RandomStringUtils.randomNumeric(8));
//	}
	
	public void reqRecDate() {
		ReqReceivedDate.click();
		ReqReceivedDate.sendKeys(ut.GetDate());
	}
	
	public void custReason() {
		custReqReason.click();
		List<WebElement> ReqReasonList=driver.findElements(By.xpath("//button[@data-id='cancellationReasonId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,ReqReasonList.size()-1);
		ReqReasonList.get(i).click();
	}
	
	public void packagingStatus() {
		packagingStatus.click();
		List<WebElement> packgingStatus=driver.findElements(By.xpath("//button[@data-id='packagingStatusId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,packgingStatus.size()-1);
		packgingStatus.get(i).click();
	}
	
	public void buyerComments() {
		ut.AddText(buyerComments);
		driver.findElement(By.id("reqRecDate")).click();
	    ut.fluentWait(5, driver);
//      Alert alert = driver.switchTo().alert();
//      alert.accept();
	}
	
	public void AuthorizationStatus() {
		AuthStatus.click();
		driver.findElement(By.xpath("//span[text()='Authorized Teleasy']")).click();
//		List<WebElement> statusList=driver.findElements(By.xpath("//button[@data-id='authorizationId']//following-sibling::div/ul"));
//		int i= ThreadLocalRandom.current().nextInt(2,5);
//		statusList.get(i).click();
	}
	
	public void Authdate() {
		AuthDate.click();
		AuthDate.sendKeys(ut.GetDate());
	}
	
	public void authcomments() {
		ut.AddText(Authcomments);
		driver.findElement(By.id("authorizationStatusSave")).click();
		ut.fluentWait(3, driver);
	}
	
	 
	public void Teleasy_RMA() {
		ut.AddText(TelRMANo);
	}
	
	public void TelDate() {
		TelDate.click();
		TelDate.sendKeys(ut.GetDate());
	}
	
	public void TelEasyComm() {
		ut.AddText(TelRMAComm);
		driver.findElement(By.id("teleasyRMASave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void LabelProvided() {
		ut.scrolintoview(driver, labelProvided);
		labelProvided.click();
		List <WebElement> labelList=driver.findElements(By.xpath("//button[@data-id='labelProvidedId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(2,labelList.size()-1);
		labelList.get(i).click();
	}
	
	public void ShipCarrierId() {
		shipCarrierId.click();
		List<WebElement> CarrList=driver.findElements(By.xpath("//button[@data-id='shippingCarrierId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,CarrList.size()-1);
		CarrList.get(i).click();
	}
	
	public void labelCost() {
		ut.getNumber(labelCostId);
	}
	
	public void retTraNO() {
		ut.getNumber(retTackNo);
		driver.findElement(By.id("returnTrackingInformationSave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void custShippingCarrier() {
		ut.AddText(custReturnShipngCar);
	}
	
	public void custReturnTrakngNo() {
		ut.getNumber(CustRetTrackNo);
	}
	
	public void returnETA() {
		returnETA.click();
		returnETA.sendKeys(ut.GetDate());
	}
	
	public void returnShippingComments() {
		ut.AddText(retShipngComm);
		driver.findElement(By.id("customerReturnShippingInformationSave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void returnStatus() {
		retStatusID.click();
		List<WebElement> retStatusList=driver.findElements(By.xpath("//button[@data-id='returnStatusId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,retStatusList.size()-1);
		retStatusList.get(i).click();
	}
	
	public void returnReceivedDate() {
		retRecDate.click();
		retRecDate.sendKeys(ut.GetDate());
	}
	
	public void telRetID() {
		ut.getNumber(TelRetID);
	}
	
	public void retStatysComm() {
		ut.AddText(retStatusCom);
		driver.findElement(By.id("returnStatusSave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void InvStatus() {
		invStatusID.click();
		List<WebElement> InvStatusList=driver.findElements(By.xpath("//button[@data-id='inventoryStatusId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,InvStatusList.size()-1);
		InvStatusList.get(i).click();
	}
	
	public void invSubStatus() {
		invSubStatus.click();
		List<WebElement> invSubStatList=driver.findElements(By.xpath("//button[@data-id='inventorySubStatusId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,invSubStatList.size()-1);
		invSubStatList.get(i).click();
	}
	
	public void MfrReq() {
		ut.AddText(MFRrequested);
	}
	
	public void invRefuComm() {
		ut.AddText(invRefundComm);
		driver.findElement(By.id("inventoryIdStatusSave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void vendRetTrackNo() {
		ut.getNumber(vendRetTrackingNo);
	}
	
	public void lablshrdDt() {
		lablShrdDt.click();
		lablShrdDt.sendKeys(ut.GetDate());
	}
	
	public void TrackStatus() {
		ut.AddText(trackStatus);
	}
	
	public void DelDt() {
		DelDt.click();
		DelDt.sendKeys(ut.GetDate());
	}
	
	public void vendMFRcomm() {
		ut.AddText(vendMFRComm);
		driver.findElement(By.id("vendorMFRReturnDetailsSave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void custRefDT() {
		custRefDt.click();
		custRefDt.sendKeys(ut.GetDate());
	}
	
	public void CustRefAmt() {
		ut.getNumber(CustRefAmt);
	}
	
	public void refType() {
		RefType.click();
		List<WebElement> refTypeList=driver.findElements(By.xpath("//button[@data-id='refundTypeId']//following-sibling::div/ul/li"));
		int i= ThreadLocalRandom.current().nextInt(1,refTypeList.size()-1);
		refTypeList.get(i).click();
	}
	
	public void refundComm() {
		ut.AddText(refComm);
		driver.findElement(By.id("refundDetailsOfCustomerSave")).click();
		ut.fluentWait(3, driver);
	}
	
	public void vendRefDt() {
		vendRefDt.click();
		vendRefDt.sendKeys(ut.GetDate());
	}
	
	public void vendRefAmt() {
		ut.getNumber(VendRefAmt);
	}
	
	public void vendRefComm() {
		ut.AddText(vendRefComm);
		driver.findElement(By.id("vendorRefundDetailsSave")).click();
		ut.fluentWait(3, driver);
	}
	public void addallthedetails() {
		reqRecDate();
		custReason();
		packagingStatus();
		buyerComments();
		AuthorizationStatus();
	    Authdate();
		authcomments();
		Teleasy_RMA();
		TelDate();
		TelEasyComm();
		LabelProvided();
		ShipCarrierId();
		labelCost();
		retTraNO();
		custShippingCarrier();
		custReturnTrakngNo();
		returnETA();
		returnShippingComments();
		returnStatus();
		returnReceivedDate();
		telRetID();
		retStatysComm();
		InvStatus();
		invSubStatus();
		MfrReq();
		invRefuComm();
		vendRetTrackNo();
		lablshrdDt();
		TrackStatus();
		DelDt();
		vendMFRcomm();
		custRefDT();
		CustRefAmt();
		refType();
		refundComm();
		vendRefDt();
		vendRefAmt();
		vendRefComm();
	}
	public void submit() {
		submit.click();
		ut.fluentWait(5, driver);
		close.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
		driver.quit();
		
	}
 public ProcessOrders(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
}
