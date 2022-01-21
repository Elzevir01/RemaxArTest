package com.remaxar;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Driver.BrowserFactory;
import Driver.DriverFactory;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import PageModel.RemaxMain;

public class RemaxSearchDataTest {
	String url = "";
	WebDriver driver;
	Logger Log = Logger.getLogger(RemaxSearchDataTest.class);
	BrowserFactory bf = new BrowserFactory();
	
  @Test(priority=1)
  public void TestBusdquedaPortada() {
	  RemaxMain rm = new RemaxMain(driver);
	  url = "https://www.remax.com.ar/";
	  rm.navegar(driver, url);
	  rm.alquilar();
	  
  }
  @BeforeClass
  public void SetUp() {
	  DriverFactory.getInstance().setDriver(bf.createBrowserIntance("CHROME"));
		driver = DriverFactory.getInstance().getDriver();
  }

  @AfterClass
  public void TearDown() throws InterruptedException {
	  Thread.sleep(5000);
	  bf.removeDriver();
  }

}
