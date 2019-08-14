package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	//Browser Invocation code - As we should not launch a new instance of browser for each test case
	
		public static WebDriver driver; //make driver as static so that another class can't change the driver object until we set it to null.
		public Properties prop;
		
		
		public WebDriver initializeDriver() throws IOException
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\AmanWorkSpace\\AmazonTest\\src\\main\\java\\resources\\Data.properties");
			
			prop.load(fis);
			String Browsername = prop.getProperty("browser");
			System.out.println(Browsername);
					
			if(Browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Bin\\chromeDriver\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			
			else if(Browsername.equalsIgnoreCase("Firefox"))
			{
				
				driver= new FirefoxDriver();
				//firefox code
			}
			
			else if (Browsername.equalsIgnoreCase("IE"))
			{
				//IE code
			}
			
			//Driver wait time
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			return driver;
		}
		

}
