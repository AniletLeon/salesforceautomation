package com.training.salesForce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilMethod {
	private WebDriver driver;
	UtilMethod(WebDriver driver){
		this.driver=driver;
	}
	public void waitForVisibleElement(WebElement element, int Time) {
		WebDriverWait wait = new WebDriverWait(driver, Time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
