package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount_TC12_EditView {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			launchApp();
			login();
			clickAccountsLink();
			clickViewLink();
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

		public static void clickAccountsLink() throws InterruptedException {
			Thread.sleep(5000);
			WebElement accountlink = driver.findElement(By.xpath("//a[text()='Accounts']"));
			// waitForVisibleElement(accountlink,5);
			accountlink.click();
			Thread.sleep(5000);
			driver.findElement(By.id("lexNoThanks")).click();
			driver.findElement(By.id("tryLexDialogX")).click();
	}
		public static void clickViewLink() {
			WebElement viewLink=driver.findElement(By.id("fcf"));
			Select viewDropdown=new Select(viewLink);
			viewDropdown.selectByVisibleText("LeonLeon");
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			WebElement fieldDropDown=driver.findElement(By.id("fcol1"));
			Select fieldDropDown1=new Select(fieldDropDown);
			fieldDropDown1.selectByVisibleText("Account Name");
			WebElement operatorldDropDown=driver.findElement(By.id("fop1"));
			Select operatorldDropDown1=new Select(operatorldDropDown);
			operatorldDropDown1.selectByVisibleText("contains");
			WebElement valueldDropDown=driver.findElement(By.id("fval1"));
			valueldDropDown.sendKeys("a");
			driver.findElement(By.xpath("(//input[@class='btn primary'])[2]")).click();
			
		}

}
