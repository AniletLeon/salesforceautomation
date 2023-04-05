package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpty_TC19_QuarterlySumReport {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		clickOnOpty();
		clickOnOptySumReport();
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
public static void clickOnOptySumReport() {
	WebElement optyDropDown=driver.findElement(By.id("quarter_q"));
	Select optyDropDown1=new Select(optyDropDown);
	optyDropDown1.selectByVisibleText("Current and Next FQ");
	WebElement includeDropDown=driver.findElement(By.id("open"));
	Select includeDropDown1=new Select(includeDropDown);
	includeDropDown1.selectByVisibleText("Open Opportunities");
	driver.findElement(By.xpath("//input[@value='Run Report']")).click();
}
	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
