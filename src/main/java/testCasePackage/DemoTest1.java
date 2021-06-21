package testCasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest1 {

	WebDriver driver;
	ThreadLocal<WebDriver> drv = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		drv.set(driver);
		drv.get().manage().window().maximize();
		drv.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}

	@Test
	public void test1() {
		drv.get().get("https://www.google.com");
		System.out.println("Title of Test 1 : " + drv.get().getTitle());
		System.out.println("Addition line added in Test1 method");
	}

	@Test
	public void test2() {
		drv.get().get("https://www.google.com");
		System.out.println("Title of Test 2 : " + drv.get().getTitle());
	}

	@Test
	public void test3() {
		drv.get().get("https://www.google.com");
		System.out.println("Title of Test 3 : " +drv.get().getTitle());
	}


	@AfterMethod
	public void tearDown() {
		drv.get().close();
	}

}
