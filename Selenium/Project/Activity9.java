package JobBoardActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity9 {
 
	WebDriver driver;
	
	
	  @Test
	  public void TC08() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.id("user_login")).sendKeys("root");
	      driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	      driver.findElement(By.id("wp-submit")).click();  
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
	      driver.findElement(By.className("page-title-action")).click();
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
	      Thread.sleep(3000);
	     // driver.findElement(By.tagName("p")).sendKeys("testing12");
	     // driver.findElement(By.id("editor-9c7ce825-51c7-4c83-a88d-0a8b47ab2f24")).sendKeys("testing");
	    //  driver.findElement(By.className("wp-block-freeform block-library-rich-text__tinymce mce-content-body html5-captions mce-edit-focus")).sendKeys("test123");
		  driver.findElement(By.id("_company_website")).sendKeys("https://www.ibm.com/in-en");
		  driver.findElement(By.id("_company_twitter")).sendKeys("@TestPost");
		  driver.findElement(By.id("_job_expires")).sendKeys("November 6, 2021");
		  Thread.sleep(3000);
		  driver.findElement(By.id("_job_location")).sendKeys("Pune");
		  driver.findElement(By.id("_company_name")).sendKeys("IBM India");
		  driver.findElement(By.id("_company_tagline")).sendKeys("test tagline");
		  
		  
		  
		  
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
		  driver. get("https://alchemy.hguy.co/jobs/wp-login.php?redirect_to=https%3A%2F%2Falchemy.hguy.co%2Fjobs%2Fwp-admin%2F&reauth=1");
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  	//driver.quit();
	  }

}
