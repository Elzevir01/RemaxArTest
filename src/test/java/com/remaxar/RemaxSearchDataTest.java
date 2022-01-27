package com.remaxar;

import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

//import org.apache.log4j.Logger;
import Driver.BrowserFactory;
import Driver.DriverFactory;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import PageModel.RemaxList;
import PageModel.RemaxMain;

public class RemaxSearchDataTest {
	String url = "";
	WebDriver driver;
	private static Logger Log = LogManager.getLogger(RemaxSearchDataTest.class);//Logger.getLogger??
	BrowserFactory bf = new BrowserFactory();
	String minimo, maximo;
	
	
	
  @Test(priority=1)
  public void TestBusdquedaPortada() throws InterruptedException {
	  
	  BasicConfigurator.configure();  
	  RemaxMain rm = new RemaxMain(driver);
	  url = "https://www.remax.com.ar/";
	  Log.info("ingresando a remax.com");
	  rm.navegar(driver, url);
	  rm.alquilar();
	  rm.textCordoba();
	  rm.opcionCordoba();
	  rm.propiedad();
	  RemaxList rl = new RemaxList(driver);
	  rl.alquilerAVenta();
	  minimo="5000";
	  maximo="30000";
	  rl.precio();
	  rl.montoPrecio(minimo, maximo);
  }
  @BeforeClass
  public void SetUp() {
	  DriverFactory.getInstance().setDriver(bf.createBrowserIntance("CHROME"));
		driver = DriverFactory.getInstance().getDriver();
  }

  @AfterClass
  public void TearDown() throws InterruptedException {
	  Thread.sleep(3000);
	  bf.removeDriver();
  }

}
