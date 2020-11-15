package Academy;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.RegisterPage;
import resources.base;

public class RegisterNewUser extends base {
	public WebDriver driver; /*this is declarated in order to have a local object driver to be used insted of use web driver
	from base class. This is needed to run test in parallel mode*/
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("RegisterNewUser-Driver is initialized");
		driver.get(prop.getProperty("url")); // prop must be public in parent class to be used
		log.info("RegisterNewUser-Navigate to home page");
	}

	@Test(dataProvider="getData")
	public void registerAnUser(String Fullname,String Email, String Password, String ConfPass) throws IOException {
		// two ways to access to metods in object: 1.with inherits, 2.creating objects
		// of a class an invoking methods on it
		LandingPage l = new LandingPage(driver);//Here we are giving the life to the object
		// click on register button
		Assert.assertTrue(l.getRegister().isDisplayed());
		l.getRegister().click();
		log.info("RegisterAnUser-Successfully Register button clicked");
		RegisterPage r = new RegisterPage(driver);
		Assert.assertTrue(r.getRegisterForm().isDisplayed());
		log.info("RegisterAnUser-Register form displayed");
		r.getFullName().sendKeys(Fullname);
		r.getEmail().sendKeys(Email);
		r.getPassword().sendKeys(Password);
		r.getConfPass().sendKeys(ConfPass);
		r.getTerms().click();
		log.info("RegisterAnUser-Successfully user register");
	}
	
	@DataProvider
	public Object[][] getData(){
		//Row stands for how many data types tests you will run
	    //Column stands for how many values per each test
		//For example if the object has a size 5 the rows will be 0,1,2,3,4 (first row in a array is 0)
		Object data [][]=new Object[1][4];
		//0th row
		data [0][0]="esteban quito";
		data [0][1]="mail@qw.com";
		data [0][2]="123456";
		data [0][3]="123456";

		return data;
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
