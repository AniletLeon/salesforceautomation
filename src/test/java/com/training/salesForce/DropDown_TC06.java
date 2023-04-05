package com.training.salesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_TC06 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchApp();
		login();
		dropDown();
		clickOnMyProfile();
		editProfilePage();
		//clickOnPostLink();
		//fileUpload();
		uploadProfilePic();
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

	public static void clickOnMyProfile() throws InterruptedException {
		WebElement myProfile = driver.findElement(By.xpath("//a[text()='My Profile']"));

		// waitForVisibleElement(myProfile,5);
		myProfile.click();
		Thread.sleep(5000);
		WebElement myprofile = driver.findElement(By.xpath("(//img[@title='Edit Profile'])[1]"));
		waitForVisibleElement(myprofile, 5);
		myprofile.click();
	}

	public static void editProfilePage() {
		// Thread.sleep(5000);
		WebElement frame1 = driver.findElement(By.xpath("(//iframe)[3]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("Leon");
		driver.findElement(By.xpath("//input[@value='Save All']")).click();

	}

	public static void clickOnPostLink() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='publisherattachtext '])[1]")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		waitForVisibleElement(frame, 5);
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("hi hello");
		driver.switchTo().defaultContent();
		//
		WebElement share = driver.findElement(By.xpath("//input[@name='publishersharebutton']"));
		waitForVisibleElement(share, 5);
		share.click();
	}

	public static void fileUpload() {
		driver.findElement(By.xpath("//span[text()='File']")).click();
		driver.findElement(By.id("chatterUploadFileAction")).click();
		driver.findElement(By.id("chatterFile"))
				.sendKeys("C:\\Users\\anile\\OneDrive\\Desktop\\ScreenShot\\What is Polymorphism.docx");

		driver.findElement(By.id("publishersharebutton")).click();

	}

	public static void uploadProfilePic() throws InterruptedException {

		WebElement profileEdit = driver.findElement(By.id("uploadLink"));
		Actions action = new Actions(driver);
		action.moveToElement(profileEdit).click().build().perform();
		waitForVisibleElement(profileEdit, 5);
		driver.switchTo().frame("uploadPhotoContentId");

		WebElement pic = driver.findElement(By.xpath("(//form[@id='j_id0:uploadFileForm']/input)[2]"));

		pic.sendKeys("C:\\Users\\anile\\OneDrive\\Desktop\\naslovna.jpg");
		WebElement save = driver.findElement(By.xpath("(//input[@value='Save'])[2]"));
		waitForVisibleElement(save, 5);
		save.click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
//		driver.switchTo().frame("uploadPhotoContentId");
		driver.findElement(By.id("j_id0:j_id7:save")).click();

	}

	public static void waitForVisibleElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
