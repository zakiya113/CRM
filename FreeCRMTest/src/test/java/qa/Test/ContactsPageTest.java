package qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.ContactsPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	 
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToframe();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabl(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority=3)
	public void selectContactsTest() throws InterruptedException{
		contactsPage.selectContacts("zakiya tahseen");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
	//String sheetName = null;
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}


	@Test(priority=1 ,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company){ 
	homePage.clickOnNewContactLink();
	contactsPage.createNewContact(title, firstname, lastname, company); 
	} 

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		}
	
	
	
	
	
}
	


