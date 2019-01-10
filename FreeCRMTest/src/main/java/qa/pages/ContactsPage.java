package qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")
	WebElement contactsLabel;
	 
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName; 
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//Initializing the Page Objects
		public ContactsPage() {
			PageFactory.initElements(driver, this);
				}
	
		public boolean verifyContactsLabel(){
			return contactsLabel.isDisplayed();
		}
	
		public void selectContacts(String name) throws InterruptedException{
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/form[1]/table[1]/tbody[1]/tr[4]/td[1]"));
		}
			
		public void createNewContact(String title, String ftName, String ltName, String comp){
			Select select = new Select(driver.findElement(By.name("title")));
			select.selectByVisibleText(title);
			
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
		}
			
			
			
		
}
