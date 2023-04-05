package com.training.salesForce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_TC07_MtSetting {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		dropDown();
		clickOnMySetting();
		personalLink();
		displayAndLayoutLink();
		//clickOnEmailLink();
		//clickOnCalenderAndRemainder();
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

	public static void dropDown() {
		WebElement dropDownUserName = driver.findElement(By.id("userNavLabel"));
		waitForVisibleElement(dropDownUserName, 10);
		dropDownUserName.click();
	}

	public static void clickOnMySetting() throws InterruptedException {
		WebElement mySetting = driver.findElement(By.xpath("//a[text()='My Settings']"));

		waitForVisibleElement(mySetting, 5);
		mySetting.click();
	}

	//
	public static void personalLink() throws InterruptedException {
		Thread.sleep(5000);
		WebElement ToFindPersonalLink = driver.findElement(By.xpath("(//a[@class='header setupFolder'])[1]"));
		// waitForVisibleElement(ToFindPersonalLink,5);
		ToFindPersonalLink.click();
		driver.findElement(By.id("LoginHistory_font")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months')]")).click();
	}

	public static void displayAndLayoutLink() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("DisplayAndLayout_font")).click();
		driver.findElement(By.id("CustomizeTabs_font")).click();
		WebElement customLink = driver.findElement(By.id("p4"));
		Select select = new Select(customLink);
		select.selectByVisibleText("Salesforce Chatter");
		WebElement dropdownReport = driver.findElement(By.id("duel_select_0"));
		Select select1 = new Select(dropdownReport);
		List<WebElement> listOption = select1.getOptions();
		for (WebElement element : listOption) {
			element.getText();
			if (element.getText().equalsIgnoreCase("Reports")) {
				element.click();
				break;

			}
		}
		// select1.deselectByVisibleText("Reports");
		driver.findElement(By.xpath("//img[@title='Add']")).click();
		driver.findElement(By.xpath("//input[@class='btn primary']")).click();
	}

	public static void clickOnEmailLink() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='header setupFolder'])[3]")).click();
		driver.findElement(By.id("EmailSettings_font")).click();
		WebElement EmailName = driver.findElement(By.id("sender_name"));
		EmailName.clear();
		EmailName.sendKeys("Anilet Leon");
		WebElement EmailAddress = driver.findElement(By.id("sender_email"));
		EmailAddress.clear();
		EmailAddress.sendKeys("anilet1987@gmail.com");
		driver.findElement(By.id("auto_bcc1")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	public static void clickOnCalenderAndRemainder() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("CalendarAndReminders_font")).click();
		driver.findElement(By.id("Reminders_font")).click();
		driver.findElement(By.id("testbtn")).click();
	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
