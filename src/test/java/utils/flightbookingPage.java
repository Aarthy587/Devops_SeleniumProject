package utils;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class flightbookingPage {
	
	
	@FindBy(how = How.NAME, using = "findFlights")
	 @CacheLookup
	 WebElement btn_ffContinue ;
	
	@FindBy(how = How.NAME, using = "reserveFlights")
	 @CacheLookup
	 WebElement btn_sfContinue ;
	
	@FindBy(how =How.NAME , using ="passFirst0")
	 @CacheLookup
	WebElement txtbox_firstName;
	
	@FindBy(how =How.NAME , using ="passLast0")
	 @CacheLookup
	WebElement txtbox_lastName;
	
	@FindBy(how =How.NAME , using ="creditnumber")
	 @CacheLookup
	WebElement txtbox_cNumber;
	
	@FindBy(how = How.NAME, using = "buyFlights")
	 @CacheLookup
	 WebElement btn_securePurchase ;
	
	@FindBy(how =How.TAG_NAME , using = "body")
	 @CacheLookup
	 WebElement message ;
	
	@FindBy(how =How.CSS , using ="img[src='/images/forms/home.gif']")
	 @CacheLookup
	WebElement btn_bkHomebtn;
	
	@FindBy(how = How.XPATH, using = "//input[@name ='userName']")
	 @CacheLookup
	 WebElement textbox_userName;
	
	@FindBy(how = How.XPATH, using = "//input[@name ='password']")
	 @CacheLookup
	 WebElement textbox_pwd;
	
	@FindBy(how=How.XPATH, using ="//input[@name='login']")
	WebElement btn_signin;
	 
	@FindBy(how=How.XPATH, using ="//a[text() ='Cruises']")
	WebElement lnk_cruises;
	
	@FindBy(how =How.CSS , using ="img[src='/images/reservation_open.gif']")
	 @CacheLookup
	WebElement lnk_Cbooking;
	
WebDriver driver;
	


	public  flightbookingPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public void signinUser() {
		textbox_userName.sendKeys("admin");
		textbox_pwd.sendKeys("mercury");
		btn_signin.click();
		
	}
	
	
	public void booking() throws InterruptedException
	{
		//signinUser();
		Thread.sleep(3000);
		Select fromport = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		fromport.selectByIndex(3);
		Select toPort = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		toPort.selectByVisibleText("London");
		Select airline = new Select (driver.findElement(By.xpath("//select[@name='airline']")));
		airline.selectByVisibleText("Unified Airlines");
		btn_ffContinue.click();
		String actualTitle = driver.getTitle();
		String expectedTitle="Select a Flight: Mercury Tours";
		Assert.assertEquals(actualTitle,expectedTitle);
		
		WebElement departtable = driver.findElement(By.xpath("//td/form/table[1]/tbody"));
        List < WebElement > rows_table = departtable.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        for (int row = 0; row < rows_count; row++) {
        	   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
        	   int columns_count = Columns_row.size();
        	   for (int column = 0; column < columns_count; column++) {
    		    Columns_row.get(column).click();
        }}

        WebElement returntable = driver.findElement(By.xpath("//td/form/table[2]/tbody"));

        List < WebElement > rrows_table = returntable.findElements(By.tagName("tr"));

        int rrows_count = rrows_table.size();

        for (int rrow = 0; rrow < rrows_count; rrow++) {

        	   List < WebElement > rColumns_row = rrows_table.get(rrow).findElements(By.tagName("td"));

        	   int rcolumns_count = rColumns_row.size();

        	   for (int rcolumn = 0; rcolumn < rcolumns_count; rcolumn++) {

        		    rColumns_row.get(rcolumn).click();
  
        }}

        btn_sfContinue.click();
	    
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(btn_securePurchase));
	    txtbox_firstName.sendKeys("User");
	    txtbox_lastName.sendKeys("demo");
	    txtbox_cNumber.sendKeys("789562142");
	    Thread.sleep(2000);
	    btn_securePurchase.click();
	    Thread.sleep(4000);
	    String expectedBookedText ="Your itinerary has been booked!";
	    String actualBookedText = message.getText();
	    if(actualBookedText.contains(expectedBookedText))
	    {
	    	System.out.println("Your itinerary has been booked!");
	    	
	    }
	    
	    else
	    {
	    	
	    	System.out.println("Test Case Fail");
	    }
	    btn_bkHomebtn.click();
		
	}

	public void cruisebooking() throws InterruptedException {
		
		lnk_cruises.click();
		Thread.sleep(1000);
		lnk_Cbooking.click();
		signinUser();
		booking();
		
	}
	
	
	
	
		
	
	

}
