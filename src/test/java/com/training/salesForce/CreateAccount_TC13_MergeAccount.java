package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount_TC13_MergeAccount {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickAccountsLink();
		clickMergeLink();
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

	public static void clickAccountsLink() throws InterruptedException {
		Thread.sleep(5000);
		WebElement accountlink = driver.findElement(By.xpath("//a[text()='Accounts']"));
		// waitForVisibleElement(accountlink,5);
		accountlink.click();
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
	}
	public static void clickMergeLink() {
		driver.findElement(By.xpath("//a[text()='Merge Accounts']")).click();
		WebElement findName=driver.findElement(By.id("srch"));
		waitForVisibleElement(findName,5);
		findName.sendKeys("bu");
		driver.findElement(By.xpath("//input[@value='Find Accounts']")).click();
		driver.findElement(By.id("cid0")).click();
		driver.findElement(By.id("cid1")).click();
		driver.findElement(By.xpath("(//input[@class='btn'])[3]")).click();
		driver.findElement(By.xpath("(//input[@title='Merge'])[2]")).click();
		driver.switchTo().alert().accept();
		
		
	}
	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
