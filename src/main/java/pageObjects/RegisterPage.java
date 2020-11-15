package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	public WebDriver driver;
	
	private By fullname=By.xpath("//input[@name='user[name]']");
	private By email=By.xpath("//input[@type='email']");
	private By password=By.xpath("//input[@name='user[password]']");
	private By confPass=By.xpath("//input[contains(@name,'confirmation]')]");
	private By terms=By.xpath("//input[@default='default']");
	private By regForm=By.xpath("(//div[contains(@class,'row')])[2]");
	
	public RegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getFullName() {
		return driver.findElement(fullname);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getConfPass() {
		return driver.findElement(confPass);
	}
	
	public WebElement getTerms() {
		return driver.findElement(terms);
	}
	
	public WebElement getRegisterForm() {
		return driver.findElement(regForm);
	}
}
