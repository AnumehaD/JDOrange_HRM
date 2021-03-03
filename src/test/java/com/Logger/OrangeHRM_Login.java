package com.Logger;

import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OrangeHRM_Login {
	WebDriver driver;

	// ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		Log_Message.startLog("Chrome Browser Launched");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void CloseBrowser() {
		// driver.close();//Close will close only current chrome browser
		driver.quit();
		Log_Message.endLog("Chrome Browser closed successfully");
	}

	@Test
	public void LoginToOrangeHRM() throws InterruptedException {
		Log_Message.debug("OpenHRM URL Lauched");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		// Verify that Dashboard page displayed
		String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
		String ExpElement = "Dashboard";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);
		// ----------------To Verify Logout Function without using Assert----------------
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		Log_Message.debug("User Clicked on Logout button");
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();

	}




}
