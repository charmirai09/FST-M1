package Appium_ProjectWork;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AP_Activity1 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass

	public void beforeClass() throws MalformedURLException {
		// Set the desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	
	public void googleTaskAppTest () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Add first task and save it
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
		Thread.sleep(2000);
		MobileElement task1 = driver.findElementById("add_task_title");
	    task1.sendKeys("Complete Activity with Google Tasks");
	    driver.findElementById("add_task_done").click();
	    
	    //Add second task and save it
	    driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
		Thread.sleep(2000);
		MobileElement task2 = driver.findElementById("add_task_title");
		task2.sendKeys("Complete Activity with Google Keep");
	    driver.findElementById("add_task_done").click();
	    
	    //Add third task and save it
	    
	    driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
		Thread.sleep(2000);
		MobileElement task3 = driver.findElementById("add_task_title");
		task3.sendKeys("Complete the second Activity Google Keep");
	    driver.findElementById("add_task_done").click();
	    
	    //Assert to Ensure All 3 tasks are added
	    Thread.sleep(5000);
	    List<MobileElement> taskList = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
	    System.out.println("Task List :"+taskList.size());
	    String text3 = taskList.get(0).getText();
	    System.out.println("Task3 :" +text3);
	    String text2 = taskList.get(1).getText();
	    System.out.println("Task2 :" +text2);
	    String text1 = taskList.get(2).getText();
	    System.out.println("Task1 :" +text1);
	    
	    Assert.assertEquals(text1, "Complete Activity with Google Tasks");
	    Assert.assertEquals(text2, "Complete Activity with Google Keep");
	    Assert.assertEquals(text3, "Complete the second Activity Google Keep");
	    
	   
		
		
	}
	
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	

}
