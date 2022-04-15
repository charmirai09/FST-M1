package Appium_ProjectWork;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AP_Activity4_Goal1 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	

	@BeforeClass

	public void beforeClass() throws MalformedURLException {
		// Set the desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.training-support.net/selenium");
	}

	@Test
	
	public void toDoListPageTest () throws InterruptedException {
		
		
		try {
			driver.findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
		} catch (InvalidSelectorException e) {
			// ignore
		}
		Thread.sleep(3000);
		driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View")
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")))
				.sendKeys("NewTask");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Add Task\")")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")))
		.sendKeys("Testing");
       wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Add Task\")")))
		.click();

     Thread.sleep(3000);
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")))
     .sendKeys("Clear");
     wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Add Task\")")))
      .click();
	
     /*Thread.sleep(5000);	
     List<MobileElement> taskList = driver.
     System.out.println("Task List :"+taskList.size());*/
		
		


	}
}

