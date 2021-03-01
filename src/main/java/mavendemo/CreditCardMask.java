package mavendemo;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class CreditCardMask {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map < String, Object > prefs = new HashMap < String, Object > ();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);
        WebDriver chdriver = new ChromeDriver();

		//WebDriver chdriver=new ChromeDriver();
		Logger log=Logger.getLogger(CreditCardMask.class.getSimpleName());
		
		chdriver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
		
		chdriver.manage().window().maximize();
		chdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		chdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * //chdriver.findElement(By.xpath("//a[text()='Input Value']")).click();
		 * chdriver.findElement(By.
		 * xpath("//li[@class='tree-branch']//a[contains(text(),'Input Forms')]")).click
		 * (); log.info("The Form is clicked"); chdriver.findElement(By.
		 * xpath("//li[@class='tree-branch']//ul//li//a[contains(text(),'Simple Form Demo')]"
		 * )).click(); log.info("The form is opened");
		 * chdriver.findElement(By.id("user-message")).sendKeys("I am from Chennai");
		 * dialogopen(chdriver);
		 * chdriver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).
		 * click(); String
		 * s=chdriver.findElement(By.xpath("//span[@id='display']")).getText();
		 * System.out.println("the message is "+ s); chdriver.findElement(By.
		 * xpath("//li[@class='tree-branch']//a[contains(text(),'Input Forms')]")).click
		 * (); chdriver.findElement(By.
		 * xpath("//li[@class='tree-branch']//ul//li//a[contains(text(),'Checkbox Demo')]"
		 * )).click();
		 * chdriver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		 * chdriver.findElement(By.
		 * xpath("//li[@class='tree-branch']//a[contains(text(),'Input Forms')]")).click
		 * (); chdriver.findElement(By.
		 * xpath("//li[@class='tree-branch']//ul//li//a[contains(text(),'Select Dropdown List')]"
		 * )).click(); Select sec=new
		 * Select(chdriver.findElement(By.xpath("//select[@id='select-demo']")));
		 * sec.selectByValue("Wednesday");
		 */		//Select sec2=new Select(chdriver.findElement(By.id("multi-select")));
		//sec2.selectByValue("Ohio");
		//sec2.selectByValue("Texas");
	
		chdriver.findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'Input Forms')]")).click();
		
		chdriver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//a[contains(text(),'JQuery Select dropdown')]")).click();
		WebElement input1=chdriver.findElement(By.xpath("//span[@class='select2-selection__arrow']//b[@role='presentation']"));
		WebDriverWait wait=new WebDriverWait(chdriver,38);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='select2-selection__arrow']//b[@role='presentation']")));
		input1.click();
		JavascriptExecutor jse = (JavascriptExecutor)chdriver;
		//jse.executeScript("arguments[0].click();", input1);
		//jse.executeScript("arguments[0].style.border='3px solid red'", input1);

		
		log.info("element clicked");
		Thread.sleep(4000);
		WebElement input=chdriver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
		jse.executeScript("arguments[0].value='Australia';", input);
        chdriver.findElement(By.xpath("//li[contains(text(),'Australia')]")).click();
chdriver.close();
System.exit(0);
	
	}
	static void dialogopen(WebDriver chdriver)
	{
		if(chdriver.findElement(By.id("at-cv-lightbox-button-holder")).isEnabled())
{
	chdriver.findElement(By.xpath("//a[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']")).click();
}
	}

}
//html[1]/body[1]/div[2]/div[1]/div[1]/div[1