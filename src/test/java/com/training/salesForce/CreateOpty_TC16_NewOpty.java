package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpty_TC16_NewOpty {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnOpty();
		clichOnNewOpty();
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

	public static void clickOnOpty() throws InterruptedException {
		WebElement opty = driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]"));
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

	public static void clichOnNewOpty() {
		driver.findElement(By.xpath("//input[@title='New']")).click();
		driver.findElement(By.id("opp3")).sendKeys("Edge Emergency Generator");
		driver.findElement(By.id("opp4")).sendKeys("Edge Communications");
		driver.findElement(By.xpath("//span[@class='dateFormat']/a")).click();
		WebElement stageDropDown=driver.findElement(By.id("opp11"));
		Select stageDropDown1=new Select(stageDropDown);
		stageDropDown1.selectByVisibleText("Qualification");
		WebElement probability=driver.findElement(By.id("opp12"));
		probability.clear();
		probability.sendKeys("30");
		WebElement leadSourceDropDown=driver.findElement(By.id("opp6"));
		Select leadSourceDropDown1=new Select(leadSourceDropDown);
		leadSourceDropDown1.selectByVisibleText("Phone Inquiry");
		driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
		
	}

}
