package ecom.AmazonTest;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.object.AmazonLogin;
import page.object.AmazonProduct;
import resources.Base;

public class AmazonTest extends Base 
{
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		System.out.println("Driver is initialized");
		
	}
	
	@Test(dataProvider="getData")
	public void BasePageNavigation(String username, String password) throws IOException, InterruptedException
	{
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		AmazonLogin al=new AmazonLogin(driver);
		al.goToSignIn().click();
				
		//User needs to be login successfully to add product to wishlist
		
		al.getEmail().sendKeys(username); // user data will be fetched from getData method using data provider annotation 
		al.gotoContinue().click();
		al.getPassword().sendKeys(password);
		al.getLogin().click();
		System.out.println("Login Successful");
		
		//Search for product
		
		AmazonProduct ap = new AmazonProduct(driver);
		Thread.sleep(5000);
		ap.getSearchBar().sendKeys("Apple iPhone X");
		ap.getSearchBar().sendKeys(Keys.ENTER);
		
			
		//ap.getResult().sendKeys(Keys.CONTROL+"t");
		ap.getResult().click();
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle(Newly open window)
		}
		
		//Select Color
		ap.selectColor().click();
		//select size 
		ap.selectSize().click();
		
		//Add to Wishlist
		ap.addToWishlist().click();
		System.out.println("Product is added to Wishlist");
		
		//Add to Bag
		ap.addToCart().click();
		System.out.println("Product is added to bag");
		
		//Go to bag and checkout
		ap.checkout().click();
		System.out.println("Product is ready for checkout");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Object[][] data=new Object[rowcount][columncount]
		Object[][] data= new Object[1][2];
		
		data[0][0]="aman****@gmail.com"; // Provide valid username 
		data[0][1]="an****mmm"; // provide valid password
				
		return data;
		
	}


}
