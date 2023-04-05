package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount_TC11_CreateNewView {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickAccountsLink();
		clickNewViewLink();
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
		// driver.findElement(By.id("createNewButton")).click();
	}

	public static void clickNewViewLink() {
		driver.findElement(By.xpath("//a[text()='Create New View']")).click();
		
		WebElement name=driver.findElement(By.id("fname"));
		waitForVisibleElement(name,5);
		name.clear();
		name.sendKeys("Leon");
		//driver.findElement(By.id("fname")).sendKeys("Leon");
		driver.findElement(By.xpath("(//input[@class='btn primary'])[2]")).click();

	}
	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
