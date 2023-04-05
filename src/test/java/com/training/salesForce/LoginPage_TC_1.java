package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage_TC_1 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		launchApp();
		enterUserName();
		clearPasswordField();
		clockOnLoginButton();
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

	public static void clearPasswordField() {
		driver.findElement(By.id("password")).clear();
	}

	public static void clockOnLoginButton() {
		driver.findElement(By.id("Login")).click();
	}

	public static void validateErrormessage() {
		String Ecpected = "Please enter your password.";
		WebElement Acual = driver.findElement(By.id("error"));
		Assert.assertEquals(Acual, Ecpected);
	}
}
