package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
  
public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	 By lnkCustomers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	 
		
     By InkCustomers_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
   
     By btnAddnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
     
     By txtEmail=By.xpath("//input[@id='Email']");
     By txtPassword=By.xpath("//input[@id='Password']");
     
    //By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");

    By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
    By  lstitemRegistered=By.xpath("//li[contains(),'Registered')]");
    By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");

    By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
    By rdMaleGender=By.id("Gender_Male");
    By rdFeMaleGender=By.id("Gender_Female");
    
    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLastName=By.xpath("//input[@id='LastName']");
    
    By txtDob=By.xpath("//input[@id='DateOfBirth']");
    
    By txtCompanyName=By.xpath("//input[@id='Company']");
    
    By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
    
    By btnSave=By.xpath("//button[@name='save']");

  //Actions Methods
    public String getPageTitle() {
 	   return ldriver.getTitle();
    }

  public void clickOnCustomersMenu () {
 	 ldriver.findElement(lnkCustomers_menu).click();
  }

    public void clickOnCustomersMenuItem() {
 	   ldriver.findElement(InkCustomers_menuitem).click();
    }
     
    public void clickOnAddnew() {
 	   ldriver.findElement(btnAddnew).click();
    }
   
    public void setEmail(String email) {
 	   ldriver.findElement(txtEmail).sendKeys(email);
    }
     public void setPassword(String password) {
     	ldriver.findElement(txtPassword).sendKeys(password);
     }
 
		public void setCustomerRoles(String role) throws InterruptedException 
     {
     	if (!role.equals("Vendors")) 
     	{
     		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]"));
     		//ldriver.findElement(By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/ul/li/span[2]"));
     		
     	}
     	ldriver.findElement(txtcustomerRoles).click();
                
     	WebElement listitem;
     	Thread.sleep(3000);
     	
     	if(role.equals("Administrators")) 
     	{
     		listitem=ldriver.findElement(lstitemAdministrators);
     	}
     	else if (role.equals("Guests")) 
     	{
     		listitem=ldriver.findElement(lstitemGuests);
     	}
     	if(role.equals("Registered")) 
     	{
     		listitem=ldriver.findElement(lstitemRegistered);
     	
     	}
     	else if (role.equals("Vendors")) 
     	{
     		listitem=ldriver.findElement(lstitemVendors);
     	}
     	else 
     	{
     		listitem=ldriver.findElement(lstitemGuests);
     	}
     	    // listitem.click();
     	
     	   JavascriptExecutor js= (JavascriptExecutor)ldriver ;
     	   js.executeScript("arguments[0].click();", listitem);
     	      }
     
     public void setManagerOfVendor(String value)
     {
     	Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
     	drp.selectByVisibleText(value);
     }
     public void setGender(String gender)
     {
     	if(gender.equals("Male")) 
     	{
     		ldriver.findElement(rdMaleGender).click();
     	}
     	else if(gender.equals("Female")) 
     	{
     		ldriver.findElement(rdFeMaleGender).click();
     	}
     	
     }
      public void setFirstName(String fname) 
      {
     	 ldriver.findElement(txtFirstName).sendKeys(fname);
      }
      public void setLastName(String lname) 
      {
     	 ldriver.findElement(txtLastName).sendKeys(lname);
      }
      public void setdob(String dob) 
      {
     	 ldriver.findElement(txtDob).sendKeys(dob);
      }
      public void setCompanyName(String coname) 
      {
     	 ldriver.findElement(txtCompanyName).sendKeys(coname);
      }
      public void setAdminContent(String content) 
      {
     	 ldriver.findElement(txtAdminContent).sendKeys(content);
      }
      public void clickInSave() 
      {
     	 ldriver.findElement(btnSave).click();
      }




}














