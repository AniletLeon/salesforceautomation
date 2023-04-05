package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage_TC_2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		launchApp();
		loginSFDC();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void loginSFDC() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("ani@anstar.com");
		driver.findElement(By.id("password")).sendKeys("le0nDhas");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		String expectText = "Home Page ~ Salesforce - Developer Edition";
		compareText(homePageTitle, expectText);
	}

	private static void compareText(String ActualText, String expectedText) {
		Assert.assertEquals(ActualText, expectedText);
	}

}
