package testngPractice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utility {

	Properties prop=new Properties();
	
	public Properties readProperties()
	{
	try 
	{
	FileInputStream fi=new FileInputStream("E:\\eclipse\\mavendemo\\src\\test\\resources\\config.properties");
	prop.load(fi);
	}
	catch(Exception e)
	
	{
		System.out.println("exception is successfully catched");
	}

	return prop;
	}
}
