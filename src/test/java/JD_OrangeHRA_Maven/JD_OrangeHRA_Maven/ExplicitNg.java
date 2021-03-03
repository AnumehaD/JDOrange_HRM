package JD_OrangeHRA_Maven.JD_OrangeHRA_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitNg {
	
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
				  String ActText = driver.findElement(By.id("logInPanelHeading")).getText();
				  String ExptText = "LOGIN Panel";
				  Assert.assertEquals(ExptText,ActText);
				  String ActTitle = driver.getTitle();
				  String ExtTitle = "OrangeHRM";
				  Assert.assertEquals(ActTitle, ExtTitle);
				  
				  String ActURL = driver.getCurrentUrl();
				  String ExptURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
				  Assert.assertEquals(ActURL, ExptURL);
			  }
			  @BeforeTest
			  public void beforeTest() throws InterruptedException {
				  WebDriverManager.chromedriver().setup();
				  driver = new ChromeDriver();
				  driver.manage().window().maximize();
			      driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			    //----------------ExplicitWait Example--------------
					WebDriverWait wait = new WebDriverWait(driver, 60);
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
					String ActText=element.getText();
					System.out.println(ActText);
					element.click();
			  }

			  @AfterTest
			  public void afterTest() {
				  driver.quit();
			  }

			}

