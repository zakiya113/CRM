package qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.ContactsPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
				initialization();
				testUtil = new TestUtil();
		contactsPage = new ContactsPage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToframe();
	Assert.assertTrue(homePage.verifyCorrectUserName());	
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToframe();
		contactsPage = homePage.clickOnContactsLink();
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
		}
	
}
