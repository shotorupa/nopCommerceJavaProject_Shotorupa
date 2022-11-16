package stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class BaseClass {
	  public static WebDriver driver;
	   public static LoginPage lp;
	   public static AddcustomerPage addcust;
	   public static Properties property;
		public static Logger logger;
	   public static SearchCustomerPage searchCust;
	   
	   public BaseClass() {
			logger = Logger.getLogger("Automation Testing");
			PropertyConfigurator.configure("src/test/resources/log4j.properties");		
		} 
	
			
			//created for generating random string for Unique email
			 public static String randomestring() {
				 String generatedString1 = RandomStringUtils.randomAlphabetic(5);
				return (generatedString1);		
		} 

		public static void initializeProperties()      {	
			
			try {
				Properties property = new Properties();
				InputStream ip = new FileInputStream("src/test/resources/config.properties");
				property.load(ip);
			} catch (IOException error) {	
				error.printStackTrace();
				System.out.println("Can't find the file");		
			} catch (Exception error) {
				error.getMessage();
			} finally {
				System.out.println("This code will always run");
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	//This will delete user session information	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://admin-demo.nopcommerce.com/login"); //This goes the to URL of the application
			
	}
		public static void setUp(){
			if(property.getProperty("BrowserType").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			} else if (property.getProperty("BrowserType").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (property.getProperty("BrowserType").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		
		
		
		
		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source,target);
			System.out.println("Screenshot taken");
		}
}

