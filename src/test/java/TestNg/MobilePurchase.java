package TestNg;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {

	static WebDriver driver;
	long startTime;
	long endTime;

	@BeforeClass(groups = "default")
	public static void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass(groups = "default")
	public static void close() {

		// driver.quit();
	}

	@BeforeMethod(groups = "default")
	public void startTime() {
		startTime = System.currentTimeMillis();

	}

	@AfterMethod(groups="default")
	public void endTime() {
		endTime = System.currentTimeMillis();
		System.out.println("total time taken:" + (endTime - startTime));
	}

	@Test(priority = 1,groups = "testing")
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

	@Test(priority = 2,groups = "testing")
	public void mobileSearch() {
		driver.findElement(By.name("q")).sendKeys("SAMSUNG MOBILES", Keys.ENTER);
		WebElement mobile = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		fn = mobile.getText();
		System.out.println("mobile name is:" + fn);
		mobile.click();

	}

	@Test(priority = 3)
	public void windowHandle() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x : child) {
			if (!x.equals(parent)) {
				driver.switchTo().window(x);
				System.out.println("Window Switched");
			}
		}

	}

	@Test(priority = 4)
	public void mobileName() {

		WebElement mobileName = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		String ln = mobileName.getText();
		System.out.println("mobile name is:" + ln);

		WebElement buynow = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']"));
		buynow.isDisplayed();
		buynow.click();

		if (ln.equals(fn)) {
			System.out.println("Both the mobiles names are same");

		} else {
			System.out.println("Both the mobiles are not same");
		}
	}

	@Test(priority=5,enabled = false)
	public void screenShot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:/Users/Gobinath/Desktop/junit.png");
		FileUtils.copyFile(src, des);

	}

}
