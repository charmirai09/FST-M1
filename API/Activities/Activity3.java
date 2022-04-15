import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
    
    @BeforeClass

	public void setUp() throws MalformedURLException {

		//Setting up the desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "PixelEmulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		cap.setCapability("noReset", false);
		
		//Set up Appium driver instance 
		
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
				wait = new WebDriverWait(driver,10);
	}
	
	@Test(priority=1)
	
	public void add() {
		
		driver.findElementById("digit_5").click();
		driver.findElementById("op_add").click();
		driver.findElementById("digit_9").click();
		driver.findElementById("eq").click();
		String addResult = driver.findElementById("result").getText();
		System.out.println("Addition Result :"+addResult);
		Assert.assertEquals(addResult, "14");
		
		
		
	}
	@Test(priority=2)
	
	public void sub() {
		
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("op_sub").click();
		driver.findElementById("digit_5").click();
		driver.findElementById("eq").click();
		String subResult = driver.findElementById("result").getText();
		System.out.println("Subtraction Result :"+subResult);
		Assert.assertEquals(subResult, "5");
		
	}
		
		
	@Test(priority=3)
	
	public void mult() {
		driver.findElementById("digit_5").click();
		driver.findElementById("op_mul").click();
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("eq").click();
		String multResult = driver.findElementById("result").getText();
		System.out.println("Multiplication Result :"+multResult);
		Assert.assertEquals(multResult, "500");
		
		
		
	}
	
	@Test(priority=4)
	public void div() {
		
		driver.findElementById("digit_5").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("op_div").click();
		driver.findElementById("digit_2").click();
		driver.findElementById("eq").click();
		String divResult = driver.findElementById("result").getText();
		System.out.println("Division Result :"+divResult);
		Assert.assertEquals(divResult, "25");
		
	}
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
		
	}