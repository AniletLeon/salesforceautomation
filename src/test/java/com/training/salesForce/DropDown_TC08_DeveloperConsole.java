package com.training.salesForce;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_TC08_DeveloperConsole {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		dropDown();
		clickOnMySetting();
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
	public static void clickOnMySetting() throws InterruptedException {
		WebElement clickdevConsole = driver.findElement(By.xpath("//a[text()='Developer Console']"));

		waitForVisibleElement(clickdevConsole, 5);
		clickdevConsole.click();
		Set<String> wind=driver.getWindowHandles();
		Iterator<String> it=wind.iterator();
		String paraent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		driver.close();
		driver.switchTo().window(paraent);
	}


	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
