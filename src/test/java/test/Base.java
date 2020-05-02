package test;

import org.testng.annotations.Test;

import utils.Common;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Base {
  
	WebDriver driver;
	
  @BeforeMethod
  public void beforeSuite() {
	  Common commonUtil = new Common();
	  commonUtil.setUpBrowser("chrome", "http://www.newtours.demoaut.com/");
	  driver = commonUtil.getDriver();
  }

  @AfterMethod
  public void afterSuite() {
	  driver.quit();
  }

}
