package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_TC05 {
	static WebDriver driver;
	public static void main(String[] args) {
		launchApp();
		loginNegativeData();
		dropDown();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void loginNegativeData() {
		driver.findElement(By.id("username")).sendKeys("ani@anstar.com");
		driver.findElement(By.id("password")).sendKeys("le0nDhas");
		driver.findElement(By.id("Login")).click();
	}
	public static void dropDown() {
		WebElement dropDownUserName=driver.findElement(By.id("userNavLabel"));
		waitForVisibleElement(dropDownUserName,10);
		dropDownUserName.click();
	}
	public static void waitForVisibleElement(WebElement element, int Time) {
		WebDriverWait wait = new WebDriverWait(driver, Time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
