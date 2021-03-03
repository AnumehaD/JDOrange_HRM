package JD_OrangeHRA_Maven.JD_OrangeHRA_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestNG {
	ChromeDriver driver;
  @Test
  public void login() {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  driver.findElement(By.linkText("Dashboard")).isDisplayed();
	  
  }
  @Test
  public void logout() throws InterruptedException {
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Logout")).click();
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
      driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
      Thread.sleep(20000);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
