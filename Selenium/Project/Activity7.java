package JobBoardActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	
  @Test
  public void TC07() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //open post a job tab
	  driver.findElement(By.id("menu-item-26")).click();
	  //Thread.sleep(1000);
	  driver.findElement(By.className("button")).click();
	  //login 
	 
	  driver.findElement(By.id("user_login")).sendKeys("root");
      driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
      driver.findElement(By.id("wp-submit")).click();
	 
	  //fill job post detials
	 driver.findElement(By.id("job_title")).sendKeys("Project Manager-PM1");
	  driver.findElement(By.id("job_location")).sendKeys("Pune");
	  //click on preview button
	  driver.switchTo().frame("job_description_ifr");
	  Thread.sleep(2000);
	//driver.findElement(By.tagName("p")).sendKeys("testing1");
	  driver.findElement(By.id("tinymce")).sendKeys("testing22");
	  driver.switchTo().defaultContent();
	  driver.findElement(By.xpath("//input[@value = 'Preview']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("job_preview_submit_button")).click();
	
	  
  }
 
  @Test
  public void z() throws InterruptedException {
 //verify job posted successfully
	  
	  driver.findElement(By.id("menu-item-24")).click();
	  driver.findElement(By.id("search_keywords")).sendKeys("Project Manager-PM1");
	  Thread.sleep(2000);
	  //click on search job button
	  driver.findElement(By.xpath("//input[@value ='Search Jobs']")).click();
	  Thread.sleep(2000);
	  
  
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
