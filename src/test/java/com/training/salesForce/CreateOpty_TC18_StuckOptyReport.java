package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpty_TC18_StuckOptyReport {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnOpty();
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

	public static void clickOnOpty() throws InterruptedException {
		WebElement opty = driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]"));
		waitForVisibleElement(opty, 5);
		opty.click();
		Thread.sleep(5000);
		WebElement popWindow = driver.findElement(By.id("lexNoThanks"));
		// waitForVisibleElement(popWindow,5);
		popWindow.click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//a[text()='Stuck Opportunities']")).click();

	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
