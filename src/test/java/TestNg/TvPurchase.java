package TestNg;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TvPurchase {
	
		static WebDriver driver;
		long startTime;
		long endTime;
		@BeforeClass(groups = "default")
		public static void launch()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		@AfterClass(groups = "default")
		public static void close() {
			
			//driver.quit();
		}
		@BeforeMethod(groups = "default")
		public void startTime() {
			 startTime = System.currentTimeMillis();
			
		}
		@AfterMethod(groups = "default")
		public void endTime() {
			 endTime = System.currentTimeMillis();
			 System.out.println("total time taken:"+(endTime-startTime));
			}
		
		
		@Test(groups = "testing")
		public void login() {
			try {
				WebElement closeic = driver.findElement(By.xpath("//button[@ class='_2KpZ6l _2doB4z']"));
				 closeic.isDisplayed();
				 closeic.click();
				
				
				
			} catch (Exception e) {
				System.out.println("login not required");
				
			}
		}
		 static String fn;
			@Test(groups = "testing")
			public void tvSearch() {
				driver.findElement(By.name("q")).sendKeys("MICROMAX TV",Keys.ENTER);
//				WebElement mobile = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
//				fn = mobile.getText();
//				System.out.println("mobile name is:"+fn);
//				mobile.click();
//				
			}
			

	}


