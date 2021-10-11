package JobBoardActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	
	WebDriver driver;
	String h1;
	
  @Test
  public void TC02() {
	   h1 = driver.findElement(By.className("entry-title")).getText();
	  System.out.println("Heading of page is: " +h1);
	  Assert.assertEquals("Welcome to Alchemy Jobs", h1);
	  
	  
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
