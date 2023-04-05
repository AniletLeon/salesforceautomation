package com.training.salesForce;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leads_TC20_LeadsTab {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnleadTab();
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

	public static void clickOnleadTab() throws InterruptedException {
		WebElement opty = driver.findElement(By.xpath("//a[text()='Leads']"));
		waitForVisibleElement(opty, 5);
		opty.click();
		Thread.sleep(5000);
		driver.findElement(By.id("lexNoThanks"));

		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(5000);
		WebElement leadTab = driver.findElement(By.id("fcf"));
		List<String> actualStrings = new ArrayList<String>();
		Select select = new Select(leadTab);
		List<WebElement> list = select.getOptions();
		for (WebElement e : list) {
			actualStrings.add(e.getText());

		}
//		List<String> actual = select.getOptions().stream()
//				.map(WebElement::getText)
//				.collect(Collectors.toList());
		
		List<String> expected = Arrays.asList("All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads",
				"View - Custom 1", "View - Custom 2");
		assertEquals(actualStrings, expected);
	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
