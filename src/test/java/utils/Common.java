package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	WebDriver driver;
	public void setUpBrowser(String browser,String url) {
		String currDir=System.getProperty("user.dir");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir+"\\Drivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			driver=new ChromeDriver(options);
		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", currDir+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if (browser.equalsIgnoreCase("html"))
		{
			//driver = new HtmlUnitDriver();
		}
		
		driver.manage().window().maximize();
	
		//url
		if(url!="")
			driver.get(url);
		else
			
			driver.get("about:blank");
		
	}
	
	public WebDriver getDriver()
	{
		
		return driver;
	}
	
	}
