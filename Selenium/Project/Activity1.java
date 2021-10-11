package JobBoardActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Activity1 {
	WebDriver driver;
	
	  @BeforeMethod
	  public void beforeMethod() {
		
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/jobs/");
		   
	  }
	  
	@Test
  public void TC01() {
		
      String title = driver.getTitle();
	  System.out.println("Page title is: " + title);
	 
	// Assertion for page title
	Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
  }
  
   @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }

   @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {

  }

 
}
