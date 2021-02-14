package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;

	@BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	 }
	
	
	@Test
	public void LoginTest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
	loginpageObj.enterUserName("demo@techfios.com");	
	loginpageObj.enterPassword("abc123");	
	Thread.sleep(3000);
	loginpageObj.clickSignInButton();
	
	takeScreenshotAtEndOfTest(driver);
	}
	
	@Test(priority = 2)
	public void loginpageTitleTest() throws InterruptedException {
	loginpageObj.enterUserName("demo@techfios.com");	
	Thread.sleep(2000);
	loginpageObj.enterPassword("abc123");
	Thread.sleep(2000);
	
	}
	
	@AfterMethod
	 public void tearDown() {  
	  driver.close();
	  driver.quit();
	 }	
}
