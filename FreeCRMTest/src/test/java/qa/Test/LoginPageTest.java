package qa.Test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
		@BeforeMethod
	public void setUp() {
				initialization();
		loginpage = new LoginPage();
		
	}
		
		@Test(priority=1)
		public void loginPageTitleTest() {
			
			 String title = loginpage.validateLoginPageTitle();
			 Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
		}
		
		
		@Test(priority=2)
		public void crmlogoImageTest() {
			boolean flag = loginpage.validateCRMImage();
			Assert.assertTrue(flag);
		}
		
		@Test(priority=3)
		public void loginTest() throws InterruptedException {
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
