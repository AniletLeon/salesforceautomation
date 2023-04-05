package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage_TC_5_ForgotPasswordB {
	static WebDriver driver;

	public static void main(String[] args) {

		launchApp();
		loginNegativeData();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void loginNegativeData() {
		driver.findElement(By.id("username")).sendKeys("123");
		driver.findElement(By.id("password")).sendKeys("22131");
		driver.findElement(By.id("Login")).click();
		String errormsg = driver.findElement(By.id("error")).getText();
		System.out.println(errormsg);
	}


}
