package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Random_TC35 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnPlusTab();
		clickOnCustomizeTabButton();
		selectAnyTabInSelectedTab();
		clickOnLogout();
		loginPage();
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

	public static void clickOnCustomizeTabButton() throws InterruptedException{
		Thread.sleep(7000);
		WebElement CustomizeTab=driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		//waitForVisibleElement(CustomizeTab,5);
		CustomizeTab.click();
	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void clickOnPlusTab(){
		WebElement opty = driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
		waitForVisibleElement(opty, 5);
		opty.click();
	}
public static void selectAnyTabInSelectedTab() {
	driver.findElement(By.xpath("//option[text()='Subscriptions']")).click();
	//Select select=new Select(selectTab);
	//select.selectByVisibleText("Subscriptions");
	driver.findElement(By.xpath("//img[@title='Remove']")).click();
	driver.findElement(By.xpath("//input[@title='Save']")).click();
}
public static void clickOnLogout() {
	WebElement dropDownUserName = driver.findElement(By.id("userNavLabel"));
	waitForVisibleElement(dropDownUserName, 10);
	dropDownUserName.click();
	WebElement logOut = driver.findElement(By.xpath("//a[text()='Logout']"));

	waitForVisibleElement(logOut, 5);
	logOut.click();
}
public static void loginPage() throws InterruptedException {

	Thread.sleep(10000);
	WebElement username=driver.findElement(By.id("username"));
	//waitForVisibleElement(username,7);
	username.sendKeys("ani@anstar.com");
	driver.findElement(By.id("password")).sendKeys("le0nDhas");
	driver.findElement(By.id("Login")).click();
}

}
