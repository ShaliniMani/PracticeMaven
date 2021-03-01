package mavendemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the date in dd-mmm-yyyy");
		String date[]=in.nextLine().split("-");

		String day=date[0];
		String month=date[1];
		String year=date[2];
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map < String, Object > prefs = new HashMap < String, Object > ();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver chdriver = new ChromeDriver();

		//WebDriver chdriver=new ChromeDriver();
		Logger log=Logger.getLogger(CreditCardMask.class.getSimpleName());
		
		chdriver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
		chdriver.manage().window().maximize();
		chdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		chdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
chdriver.findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'Date pickers')]")).click();
chdriver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//a[contains(text(),'Bootstrap Date Picker')]")).click();
chdriver.findElement(By.xpath("//div[@class='input-group date']//span[@class='input-group-addon']")).click();
chdriver.findElement(By.xpath("//th[@class='datepicker-switch']")).click();
String curryear=chdriver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']")).getText();
Integer yearclick=Integer.parseInt(curryear)-Integer.parseInt(year);
for(int i=0;i<yearclick;i++)
{
chdriver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='prev'][contains(text(),'«')]")).click();	
}
List<WebElement> months=chdriver.findElements(By.xpath("//tbody/tr/td/span[@class='month']"));
for(int i=0;i<months.size();i++)
{
	if(month.equalsIgnoreCase(months.get(i).getText()))
	{
		months.get(i).click();
		break;
	}
}
String day1="//table[@class='table-condensed']/tbody/tr[";
String day2="]/td[";
boolean flag=false;
for(int i=1;i<=7;i++)
{
 for(int j=1;j<=6;j++)
 {
	 System.out.println(day1+i+day2+j+"]");
	 WebElement wb=chdriver.findElement(By.xpath(day1+i+day2+j+"]"));
	 if(day.equalsIgnoreCase(wb.getText()))
	 {
		 if(!(wb.getAttribute("class").contains("disabled")))
		 {
		 wb.click();
		 }
		 else
			 System.out.println("enter the date which doesnt fall on sunday");
		 flag=true;

		 break;
	 }
 }
 
 if(flag)
	 break;
}
chdriver.close();
System.exit(0);
	}

}
