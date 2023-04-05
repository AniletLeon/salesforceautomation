package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage_TC_4_ForgotPasswordA {
	static WebDriver driver;
	public static void main(String[] args) {

		launchApp();
		clickForgotPassword();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void clickForgotPassword()   {
		driver.findElement(By.id("forgot_password_link")).click();
		driver.findElement(By.id("un")).sendKeys("ani@anstar.com");
		driver.findElement(By.id("continue")).click();
		String ForgotPageTitle=driver.getTitle();		
		System.out.println(ForgotPageTitle);
		
	}

}
