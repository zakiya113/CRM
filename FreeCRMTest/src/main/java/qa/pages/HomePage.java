package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: zakiya tahseen')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]/ul[1]/li[4]/a[1] ")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
	return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
	return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
	return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
	return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactLink.click();
			
	
	
	
	}
	
}
