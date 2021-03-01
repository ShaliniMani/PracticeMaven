package testngPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Configurationclass {

	WebDriver driver;
	Utility ui=new Utility();
	public WebDriver startBrowser()
	{
		String browsername=ui.readProperties().getProperty("browser");
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			

		}
		return driver;
	}
	
}
