package stepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	
	 public WebDriver driver;
	 public LoginPage lp;
	 public AddcustomerPage addcust;
	 
	 
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() throws InterruptedException {
		logger=Logger.getLogger("nopCommerce"); //added logger
		PropertyConfigurator.configure("Log4j.properties");// added logger
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver/chromedriver.exe");
		driver= new ChromeDriver();
      logger.info("*******Launching browser*********");
		lp=new LoginPage(driver);
		 Thread.sleep(3000);
	}
       //login step definition

	@When("User Opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		 logger.info("*******opening URL*********");
		driver.get(url);
		driver.manage().window().maximize();
		 Thread.sleep(3000);
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String password) throws InterruptedException {
		 logger.info("*******Providing login details*********");
		lp.setUserName(uname);
	    lp.setPassword(password);
	    Thread.sleep(3000);
	}

	@When("Click On Login")
	public void click_on_login() throws InterruptedException {
		 logger.info("*******Started login prosses*********");
		lp.clickLogin();
	  Thread.sleep(3000);
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		// Negative validation condition 
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			 logger.info("*******Login passed*********");
			Assert.assertTrue(false);
		}else {
			 logger.info("*******Login failed*********");
			Assert.assertEquals(title,driver.getTitle());
			}
		Thread.sleep(3000);
		}



	@When("User Click On Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		 logger.info("*******click on logout*********");
		lp.clickLogout();
	  Thread.sleep(3000);
	}



	@Then("Close Browser")
	public void close_browser() {
		 logger.info("*******Closing browser*********");
		driver.quit();
	}



	//customer feature step definition

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    addcust=new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
	}
	@When("User clicks on customer menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenu();
	} 
	@When("click on customers menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addcust.clickOnCustomersMenuItem();
	   
	}
	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    addcust.clickOnAddnew();
	    Thread.sleep(2000);
	}
	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
	}
	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		 logger.info("*******Adding new customer*********");
		 logger.info("******Providing customer details**********");
		String email = randomestring() + "@gmail.com";
	    addcust.setEmail(email);
	    addcust.setPassword("test123");
	    
	 // Registered - default
	    //The customer cannot be both 'Guest' and 'Registered' customer roles
	    //Add the customer to 'Guests' or 'Registered' customer role
	    addcust.setCustomerRoles("Guest");
	    Thread.sleep(3000);
	 
	    addcust.setManagerOfVendor("Vendor 2");
	    addcust.setGender("Female");
	    addcust.setFirstName("Dani");
	    addcust.setLastName("Chowdhury");
	    addcust.setdob("01/01/1988");
	    addcust.setCompanyName("busyQA");
	    addcust.setAdminContent("This is for testing.......");
	}


	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		 logger.info("******Saving customer data**********");
		addcust.clickInSave();
		Thread.sleep(2000);
	  
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The customer cannot be in both 'Guests' and 'Registered' customer roles"));
	    }

	// Searching a customer by email id
@When("Enter customer Email")
public void enter_customer_email() {
	 logger.info("*******searching by email id*********");
	searchCust= new SearchCustomerPage(driver);
 searchCust.setEmail("victoria_victoria@nopCommerce.com");
}

@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
	searchCust.clickSearch();
	Thread.sleep(3000);
}

@Then("User should found Email in the Search table")
public void user_should_found_email_in_the_search_table() {
boolean status =searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
 Assert.assertEquals(false, status);
}



}


