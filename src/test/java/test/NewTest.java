package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.flightbookingPage;
import utils.loginPage;



public class NewTest extends Base {
	
	loginPage login;
	flightbookingPage fbooking;
	@BeforeClass
	public void beforeclass()
	{
		login = new loginPage(driver);
	}
	@Test(priority=0)

	  public void testcase_UserRegister() throws InterruptedException{
		  
		  driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		  
		  loginPage objRegister = PageFactory.initElements(driver, loginPage.class);
		  objRegister.signupBlock1("Demo", "User", "9000989010", "aarthy.587@gmail.com");
		  objRegister.signupBlock2("569,Duane Street", "Gname", "mercury", "mercury");
		  Thread.sleep(4000);
		  String bodyText = driver.findElement(By.tagName("body")).getText();
	  if(bodyText.contains("Thank you for registering")) {
	    	  System.out.println("Registration is Successfull");
	      }else
	      {
	          System.out.println("Test Case Fail");
	      }
	}

	  @Test(priority=1)
	  public void testcase_flightBooking() throws InterruptedException{
		  
		  fbooking = new flightbookingPage(driver);
		  flightbookingPage objflightBooking = PageFactory.initElements(driver, flightbookingPage.class);
		  objflightBooking.signinUser();
		  objflightBooking.booking();
		  
	  }
	
	  @Test(priority=3)
	  public void testcase_cruisesBooking() throws InterruptedException{
		  
		  fbooking = new flightbookingPage(driver);
		  flightbookingPage objcruiseBooking = PageFactory.initElements(driver, flightbookingPage.class);
		  objcruiseBooking.cruisebooking();
		  
	  }
	
	  @Test(priority=4)
	  public void testcase_BrokenLinks() throws InterruptedException{
		  
		  login = new loginPage(driver);
		  loginPage objbLinks = PageFactory.initElements(driver, loginPage.class);
		  objbLinks.Brokenlinks();
	  }
	
	
	
}
