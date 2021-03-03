package com.OrangeHRM;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proxytest {
	WebDriver driver;
	  @Test
	  public void HTTPAuth() throws InterruptedException {
		   System.out.println("Proxy Setting Done");
		
	  }
	  @BeforeTest
	  public void LaunchBrowser() {
		  //Create proxy class object
		  Proxy p=new Proxy();
		  // Set HTTP Port to 8080
		  p.setHttpProxy("localhost:8080");
		  // Create desired Capability object
		  DesiredCapabilities cap=new DesiredCapabilities();
		  // Pass proxy object p
		  cap.setCapability(CapabilityType.PROXY, p);
			/*
			 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(cap);
			 */
		  WebDriverManager.iedriver().setup();
		  driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
			/*
			 * by pass proxy code - 
			 * 
			 * @BeforeTest
			 * 
			 *     public void LaunchBrowser() {​​​​
			 * 
			 *         ChromeOptions chromeOptions = new ChromeOptions();
			 * 
			 *         Proxy proxy = new Proxy();
			 * 
			 *         proxy.setHttpProxy("localhost:8080");
			 * 
			 *         chromeOptions.setProxy(proxy);
			 * 
			 *         WebDriverManager.chromedriver().setup();
			 * 
			 *         driver = new ChromeDriver(chromeOptions);
			 * 
			 *         driver.manage().window().maximize();
			 * 
			 *     }​​​​
			 */

	  }

	  @AfterTest
	  public void CloseBrowser() {	
			//driver.quit();
	  }
}
