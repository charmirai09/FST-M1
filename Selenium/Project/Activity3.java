package JobBoardActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	

  @Test
  public void TC03() {
	  WebElement img = driver.findElement(By.tagName("img"));
	  String imgsrc = img.getAttribute("src");
	  System.out.println("URL of img is: "+ imgsrc);
	  
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
