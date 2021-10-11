package JobBoardActivities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity5 {
	
	WebDriver driver;
	String h1;
	
  @Test
  public void TC05() throws InterruptedException {
	  driver.findElement(By.id("menu-item-24")).click();
	 // Thread.sleep(2000);
	  String t1 = driver.getTitle();
	  System.out.println("Title of page is: "+t1);
	  Assert.assertEquals("Jobs – Alchemy Jobs", t1);
	  
	  
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
