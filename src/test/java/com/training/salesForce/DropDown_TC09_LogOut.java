package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_TC09_LogOut {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		dropDown();
		clickOnLogOut();
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

	public static void clickOnLogOut() throws InterruptedException {
		WebElement logOut = driver.findElement(By.xpath("//a[text()='Logout']"));

		waitForVisibleElement(logOut, 5);
		logOut.click();
		
	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
