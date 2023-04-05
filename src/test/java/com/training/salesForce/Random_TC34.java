package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Random_TC34 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnHomeTab();
		clickOnFirstLastNameLink();
		clickOnEditProfile();
		clickOnAboutTab();
		clickOnLastName();
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

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void clickOnFirstLastNameLink() {
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a")).click();
	}

	public static void clickOnEditProfile() {
		driver.findElement(By.xpath("(//img[@title='Edit Profile'])[1]")).click();
	}

	public static void clickOnAboutTab() {
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.xpath("//li[@id='aboutTab']/a")).click();
	}
	public static void clickOnLastName() {
		WebElement lastNameField=driver.findElement(By.id("lastName"));
		lastNameField.clear();
		lastNameField.sendKeys("Abcd");
		driver.findElement(By.xpath("//input[@value='Save All']")).click();
	}
}
