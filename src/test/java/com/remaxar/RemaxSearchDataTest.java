package com.remaxar;

import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import driver.BrowserFactory;
import driver.DriverFactory;
import pageModel.RemaxDetalles;
import pageModel.RemaxList;
import pageModel.RemaxMain;

import data.Propiedad;

public class RemaxSearchDataTest {
	String url = "";
	WebDriver driver;
	private static Logger Log = LogManager.getLogger(RemaxSearchDataTest.class);//Logger.getLogger??
	BrowserFactory bf = new BrowserFactory();
	String minimo, maximo;
	
	RemaxMain rm = new RemaxMain(driver);
	RemaxList rl = new RemaxList(driver);
	RemaxDetalles rd = new RemaxDetalles(driver);
	
	Propiedad pr = new Propiedad();
	
  @Test(priority=1)
  public void TestBusdquedaPortada() throws InterruptedException {
	  
	  BasicConfigurator.configure();  
	  
	  url = "https://www.remax.com.ar/";
	  Log.info("ingresando a remax.com");
	  rm.navegar(driver, url);
	  rm.alquilar();
	  rm.textCordoba();
	  rm.opcionCordoba();
	  rm.propiedad();
	  
	  rl.alquilerAVenta();
	  minimo="5000";
	  maximo="30000";
	  rl.precio();
	  rl.montoPrecio(minimo, maximo);
	  
  }
  @Test(priority=2)
  public void testInfo() {
	  rl.card1();
	  ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		
		pr.setTitulo(rd.getTitulo());
		pr.setDescripcion(rd.getDescripcion());
		pr.setPrecioDolar(rd.getPrecioDolar());
		pr.setSuperficieTotal(rd.getSuperficieTotal());
		pr.setSuperficieCubierta(rd.getSuperficieCubierta());
		pr.setBaños(rd.getBaños());
		pr.setPisosPropiedad(rd.getPisosPropiedad());
		pr.setAptoProfecional(rd.getAptoProfesional());
		pr.setExpensas(rd.getExpensas());
		
		
		
		
		
		driver.close();
	    driver.switchTo().window(tabs2.get(0));
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
