package testngPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

public class TestngPract {
	
	@FindBy(xpath="//div[@id='site-name']/a") WebElement title;
	
	WebDriver driver;
	public TestngPract(WebDriver driver)
	{
		
		this.driver=driver;
	}

	public Boolean checkTitle()

	{
		Boolean titlePresent=title.isDisplayed();
		return titlePresent;
	}
}
