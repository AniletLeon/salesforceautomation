package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_1_LoginErrorMessage {
	static WebDriver driver;

	public static void main(String[] args) {

		launchApp();
		enterUserName();
		clearPassWordField();
		clickOnLogin();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void enterUserName() {
		driver.findElement(By.id("username")).sendKeys("ani@anstar.com");
	}

	public static void clearPassWordField() {
		driver.findElement(By.id("password")).clear();
	}

	public static void clickOnLogin() {
		driver.findElement(By.id("Login")).click();
		String actualText = driver.findElement(By.id("error")).getText();
		System.out.println(actualText);
		String expecText = "Please enter your password.";
		
		compareText(actualText, expecText);
	}

	private static void compareText(String ActualText, String expectedText) {
		Assert.assertEquals(ActualText, expectedText);
	}

}
