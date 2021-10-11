package JobBoardActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	WebDriver driver;
	String h1;
	
  @Test
  public void TC04() {
	  h1 = driver.findElement(By.tagName("h2")).getText();
	  System.out.println("Second header of page is: "+ h1);
	  Assert.assertEquals("Quia quis non", h1);
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
