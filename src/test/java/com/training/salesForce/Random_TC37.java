package com.training.salesForce;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Random_TC37 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnHomeTab();
		clickOnCurrenttime();
		clickOnFourPMLink();
		clickOnSubjectComboLink();
		clickOtherInComboWindow();
		clickOnEndTime();
		clickSevenPM();
		clickRecurrence();
		weeklyRadioButton();
		clickCalender();
		clickOnSaveButton();
		clickOnMonthViewIcon();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void login() {
		driver.findElement(By.id("username")).sendKeys("ani@anstar.com");
		driver.findElement(By.id("password")).sendKeys("le0nDhas");
		driver.findElement(By.id("Login")).click();

	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void clickOnHomeTab() throws InterruptedException {
		WebElement opty = driver.findElement(By.xpath("//a[text()='Home']"));
		waitForVisibleElement(opty, 5);
		opty.click();
		Thread.sleep(5000);
		WebElement popWindow = driver.findElement(By.id("lexNoThanks"));
		// waitForVisibleElement(popWindow,5);
		popWindow.click();
		driver.findElement(By.id("tryLexDialogX")).click();

	}

	public static void clickOnCurrenttime() {
		driver.findElement(By.xpath("//span[@class='pageDescription']/a")).click();
	}

	public static void clickOnFourPMLink() {
		driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")).click();
	}

	public static void clickOnSubjectComboLink() {
		driver.findElement(By.xpath("//img[@class='comboboxIcon']")).click();
	}

	public static void clickOtherInComboWindow() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String paraentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//li[@class='listItem4']/a")).click();
		driver.switchTo().window(paraentWindow);

	}

	public static void clickOnEndTime() {
		driver.findElement(By.id("EndDateTime_time")).click();
	}

	public static void clickSevenPM() {
		driver.findElement(By.id("timePickerItem_38")).click();
	}

	public static void clickOnSaveButton() {
		driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
	}

	public static void clickRecurrence() {
		driver.findElement(By.id("IsRecurrence")).click();
	}

	public static void weeklyRadioButton() {
		driver.findElement(By.id("rectypeftw")).click();
	}

	public static void clickCalender() {
		driver.findElement(By.id("RecurrenceEndDateOnly")).click();
		driver.findElement(By.xpath("//td[text()='29']")).click();
	}
public static void clickOnMonthViewIcon() {
	driver.findElement(By.xpath("//img[@class='monthViewIcon']")).click();
}
}
