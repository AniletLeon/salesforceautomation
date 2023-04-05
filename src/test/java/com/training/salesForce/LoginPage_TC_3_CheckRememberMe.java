package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage_TC_3_CheckRememberMe {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		loginSFDC();
		logOutSFDC();
		// validateUserName();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	public static void loginSFDC() {
		driver.findElement(By.id("username")).sendKeys("ani@anstar.com");
		driver.findElement(By.id("password")).sendKeys("le0nDhas");
		driver.findElement(By.id("rememberUn")).click();
		driver.findElement(By.id("Login")).click();
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
	}

	public static void logOutSFDC() throws InterruptedException {
		WebElement Userneme = driver.findElement(By.id("userNavLabel"));
		waitForVisibleElement(Userneme, 10);
		Userneme.click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		//Thread.sleep(5000);
		//WebElement UserN = driver.findElement(By.xpath("//span[@id='idcard-identity']"));

		//String UserName = UserN.getText();
		//System.out.println(UserName);
	}

	

	public static void waitForVisibleElement(WebElement element, int Time) {
		WebDriverWait wait = new WebDriverWait(driver, 0);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	  
	 
}
