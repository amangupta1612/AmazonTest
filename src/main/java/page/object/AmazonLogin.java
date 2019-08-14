package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLogin {
	
	WebDriver driver;
	
	By signIn = By.xpath("//a[@id='nav-link-accountList']");
	By email = By.xpath("//input[@id='ap_email']");
	By contBtn = By.xpath("//input[@id='continue']");
	By password = By.xpath("//input[@name='password']");
	By signInbtn = By.xpath("//input[@id='signInSubmit']");
	
	public AmazonLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement goToSignIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement gotoContinue()
	{
		return driver.findElement(contBtn);
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signInbtn);
	}

}
