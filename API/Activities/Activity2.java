import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

	
	@BeforeTest
	
	public void setup() throws MalformedURLException {
		
		//Setting up the desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "PixelEmulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability("noReset", false);
		
		//Set up Appium driver instance 
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		wait = new WebDriverWait(driver,10);
		
		//Accept the terms and conditions on chrome browser
		
		driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
		//Click on Next button
		driver.findElement(By.id("com.android.chrome:id/next_button")).click();
		//Click on No Sign in button
		driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
		
	}
	
	@Test
	
	public void testSearchAppium() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/");
		String title = driver.findElement(By.xpath("//android.view.View[@text='Training Support']")).getText();
		System.out.println("Title of the Home page is :"+title);
		//Click on About us link
		
		MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@text='About Us']");
		aboutButton.click();
		
		String pageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
		System.out.println("New page Title is :" +pageTitle);
		
		//Assertions
		Assert.assertEquals(title, "Training Support");
		Assert.assertEquals(pageTitle, "About Us");
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}