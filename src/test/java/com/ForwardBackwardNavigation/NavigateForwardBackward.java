package com.ForwardBackwardNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateForwardBackward {
	
	ChromeDriver driver;
	
  @Test
  public void navigateForward() {
	  
	  driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		// Add 5 seconds wait
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create object of actions class
		Actions act=new Actions(driver);
		// find element which we need to drag
		//WebElement drag=driver.findElementById("draggable");
		WebElement drag=driver.findElement(By.id("draggable"));

		// find element which we need to drop
		//WebElement drop=driver.findElementById("droppable");
		WebElement drop=driver.findElement(By.id("droppable"));
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");
	  
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
