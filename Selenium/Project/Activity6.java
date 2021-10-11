package JobBoardActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
  
	WebDriver driver;
	String h1;
	
  @Test
  public void TC06() throws InterruptedException {
	  //open jobs tab
	  driver.findElement(By.id("menu-item-24")).click();
	  //enter job searhc keyword
	  driver.findElement(By.id("search_keywords")).sendKeys("Automation");
	  Thread.sleep(2000);
	  //click on search job button
	  driver.findElement(By.xpath("//input[@value ='Search Jobs']")).click();
	  Thread.sleep(3000);
	  //click on first job listing
	  driver.findElement(By.tagName("h3")).click();
	  Thread.sleep(3000);
	  //click on apply job button
	  driver. findElement(By.xpath("//input[@value = 'Apply for job']")).click();
	  Thread.sleep(3000);
	  //to print email id from screen to console
	  String mailid = driver.findElement(By.className("job_application_email")).getText();
	  System.out.println("Mail id is: "+ mailid);
	  
			  
	  
	  
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
