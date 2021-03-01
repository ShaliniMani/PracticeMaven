package testngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class testngPractTest {
	
	WebDriver driver;
    Configurationclass cm=new Configurationclass();

	public testngPractTest()
	{
		driver=cm.startBrowser();
		driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	
	@Test
	public void verifyTitle()
	{
		TestngPract ng=PageFactory.initElements(this.driver, TestngPract.class);
		Assert.assertTrue(ng.checkTitle());
		driver.quit();
	}
	
	
}
