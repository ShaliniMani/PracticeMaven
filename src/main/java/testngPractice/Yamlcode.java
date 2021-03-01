package testngPractice;

import java.io.InputStream;
import java.util.*;

import org.yaml.snakeyaml.Yaml;

public class Yamlcode {
	 Map<String,String> config=new HashMap<String,String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Yaml yaml = new Yaml();
    InputStream input= Yamlcode.class.getClassLoader().getResourceAsStream("Application.yaml");
    
    
    @SuppressWarnings("unchecked")
	Map<String,Map<String,String>> yml=(Map<String,Map<String,String>>) yaml.load(input);
   System.out.println(yml);
   System.out.println(yml.get("Browser"));
   Iterator<String> i=yml.keySet().iterator();
   while(i.hasNext())
   {
	   String key=i.next();
	   System.out.println("Environment is "+ key);
	   
	   Map<String,String> inside=(Map<String,String>) yml.get(key);
	   
	   Iterator<String> k= inside.values().iterator();
	   while(k.hasNext())
	   {
	      System.out.println("Browser is" + k.next());
	   }
	   
   }
	}
	public  Map<String,String> addConfig(Map<String,String> m)
	{
		Iterator<String> i=m.keySet().iterator();
		while(i.hasNext())
		{
		String key=i.next();
		config.put(key,m.get(key));
		}
		return config;
	}
}
