package JD_OrangeHRA_Maven.JD_OrangeHRA_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRA_SignIn_FromExcel extends OrangeHraTestData {
	ChromeDriver driver;

	@Test(dataProvider = "LoginExcelData")
	public void Sign_On(String uname, String password) throws InterruptedException

	{

		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		// ----------------To Verify Logout Function without using
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	}

	@BeforeTest
	public void LaunchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(17000);
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
