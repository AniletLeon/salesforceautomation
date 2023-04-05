package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacts_TC25_CreateNewContacts {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			launchApp();
			login();
			clickOnContactsTab();
			clickOnNewTab();
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

		public static void clickOnContactsTab() throws InterruptedException {
			WebElement opty = driver.findElement(By.xpath("//a[text()='Contacts']"));
			waitForVisibleElement(opty, 5);
			opty.click();
			Thread.sleep(5000);
			WebElement popWindow = driver.findElement(By.id("lexNoThanks"));
			// waitForVisibleElement(popWindow,5);
			popWindow.click();
			driver.findElement(By.id("tryLexDialogX")).click();

		}

		public static void waitForVisibleElement(WebElement element, int time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public static void clickOnNewTab() {
			driver.findElement(By.xpath("//input[@value=' New ']")).click();
			driver.findElement(By.id("name_lastcon2")).sendKeys("Nickel");
			driver.findElement(By.id("con4")).sendKeys("United Oil & Gas, Singapore");
			driver.findElement(By.xpath("(//input[@value=' Save '])[2]")).click();
			
			
		}
	}


