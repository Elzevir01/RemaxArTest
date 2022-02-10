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
import txt.PrintText;

public class RemaxSearchDataTest {
	String url = "";
	WebDriver driver;
	private static Logger Log = LogManager.getLogger(RemaxSearchDataTest.class);// Logger.getLogger??
	BrowserFactory bf = new BrowserFactory();
	String minimo, maximo;
	RemaxDetalles rd;

	@Test(priority = 1)
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

	}

	@Test(priority = 2)
	public void testInfo() throws InterruptedException {
		///// FILTRAR MAS DATOS/////
		
		Log.info("ingresando filtro: cambiando alquiler por venta");
		RemaxList rl = new RemaxList(driver);
		rl.alquilerAVenta();
		minimo = "5000";
		maximo = "30000";
		Log.info("ingresando filtro: monto( U$D"+minimo+" U$D"+maximo+")");
		rl.precio();
		rl.montoPrecio(minimo, maximo);

		int cc = rl.cardCount();
		Propiedad[] pr = new Propiedad[cc];// [cc+1]
		PrintText tx = new PrintText();

		//// ABRIR LAS 3 PRIMERAS TARJETAS Y CAPTURAR SUS DATOS////
		Log.info("ingresando los 3 primeros link y recolectando sus datos");
		for (int i = 0; i < cc; i++) {
			if (i == 0)
				rl.card1();
			if (i == 1)
				rl.card2();
			if (i == 2)
				rl.card3();

			///// MOVIENDO A OTRA PESTAÑA/////
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			///// PROPIEDAD /////
			rd = new RemaxDetalles(driver);
			pr[i] = new Propiedad();

			pr[i].setTitulo(rd.getTitulo());
			pr[i].setDescripcion(rd.getDescripcion());
			pr[i].setPrecioDolar(rd.getPrecioDolar());
			pr[i].setSuperficieTotal(rd.getSuperficieTotal());
			pr[i].setSuperficieCubierta(rd.getSuperficieCubierta());
			pr[i].setBaños(rd.getBaños());
			pr[i].setPisosPropiedad(rd.getPisosPropiedad());
			pr[i].setAptoProfecional(rd.getAptoProfesional());
			pr[i].setExpensas(rd.getExpensas());
			System.out.println(pr[i].propiedadToString());
			////
			tx.escribirTextos(pr[i].propiedadToString());
			////
			driver.close();
			driver.switchTo().window(tabs2.get(0));
		}
		///// ESCRIBIR TXT LOS 3 LINK/////
		Log.info("RECOLECTANDO DATOS PARA ARCHIVO .TXT");
		tx.crearTxt();
		for (int t = 0; t < cc; t++) {
			Log.info(pr[t].propiedadToString());
			tx.escribirTextos(pr[t].propiedadToString());
		}
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
