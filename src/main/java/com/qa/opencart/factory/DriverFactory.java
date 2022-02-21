package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
/**
 * This method is used to initialize the driver using browser name
 * @param browserName
 * @return this returns the Webdriver
 */
	WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		String browserName=prop.getProperty("browser").trim();
		
		System.out.println("browser name is :"+ browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Please pass the right browser name "+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	/**
	 * this method is used to initialize the properties
	 * @return this return properties class ref.
	 */
	
	public Properties init_prop()  {
		prop=new Properties();
		try {
			FileInputStream inuptstream=new FileInputStream("src/test/resources/config/config.properties");
			prop.load(inuptstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
