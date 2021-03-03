package com.HDFCNetBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HDFCBankingLogin {
	
	
	ChromeDriver driver;
	
  @Test
  public void Login() {
	  //using xpath
	  driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
	  
	  //using css selector
	 // driver.findElement(By.cssSelector("//input[name='txtUsername']")).sendKeys("admin123");
	 // driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	 // driver.findElement(By.id("btnLogin")).click();
	  driver.findElement(By.xpath("//tbody/tr/td/a/img[1]")).click();
	  
  }
  
  @Test
  public void Logout(){

	  
 }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
	  try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }


}
