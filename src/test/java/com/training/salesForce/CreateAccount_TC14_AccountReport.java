package com.training.salesForce;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount_TC14_AccountReport {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickAccountsLink();
		clickOnLastActivy();
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
		Thread.sleep(5000);
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
	}

	public static void clickOnLastActivy() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last')]")).click();
		WebElement calender = driver.findElement(By.id("ext-gen152"));
		waitForVisibleElement(calender, 5);
		calender.click();
		driver.findElement(By.id("ext-gen152")).click();
		driver.findElement(By.xpath("(//button[text()='Today'])[1]")).click();
		driver.findElement(By.id("ext-gen154")).click();
		driver.findElement(By.xpath("(//button[text()='Today'])[2]")).click();
		driver.findElement(By.id("ext-gen49")).click();
		Random random = new Random();
		
		driver.findElement(By.id("saveReportDlg_reportNameField")).sendKeys("star"+random.nextInt(1000));
		driver.findElement(By.id("saveReportDlg_DeveloperName")).sendKeys("star"+random.nextInt(1000));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Save and Run Report']")).click();
		

	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
