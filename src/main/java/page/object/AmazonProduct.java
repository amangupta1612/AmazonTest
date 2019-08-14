package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProduct {
	
	WebDriver driver;
	
	By searchbar = By.xpath("//input[@id='twotabsearchtextbox']");
	By resultitem = By.xpath("(//span[text()='Apple iPhone X (256GB) - Space Grey'])[1]");
	By selectcolor = By.xpath("//span[@id='a-autoid-9']");
	By selectsize = By.xpath("//span[@id='a-autoid-11']");
	By addtowishlist = By.xpath("//input[@id='add-to-wishlist-button-submit']");
	By wishlistpopup = By.xpath("//button[@data-action='a-popover-close']");
	By addtoCart = By.xpath("//input[@id='add-to-cart-button']");
	By gotobag = By.xpath("(//a[@href='/checkout/cart'])[2]");
	
	public AmazonProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getSearchBar()
	{
		return driver.findElement(searchbar);
	}
	
	public WebElement getResult()
	{
		return driver.findElement(resultitem);
	}
	
	public WebElement selectColor()
	{
		return driver.findElement(selectcolor);
	}
	
	public WebElement selectSize()
	{
		return driver.findElement(selectsize);
	}
	
	public WebElement addToWishlist()
	{
		return driver.findElement(addtowishlist);
	}
	
	public WebElement getWishlistpopUp()
	{
		return driver.findElement(wishlistpopup);
	}
	
	public WebElement addToCart()
	{
		return driver.findElement(addtoCart);
	}
	
	public WebElement checkout()
	{
		return driver.findElement(gotobag);
	}

}
