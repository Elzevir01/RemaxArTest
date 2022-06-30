package com.remaxar;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import driver.BrowserFactoryCF;
import driver.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageModel.RemaxDetalles;
import pageModel.RemaxList;
import pageModel.RemaxMain;

import data.Propiedad;
import txt.PrintText;

@Epic("Remax Search Test")
public class RemaxSearchDataTest {
	String url = "";
	WebDriver driver;
	private static Logger Log = LogManager.getLogger(RemaxSearchDataTest.class);
	BrowserFactoryCF bf = new BrowserFactoryCF();
	String minimo, maximo;
	RemaxDetalles rd;
	RemaxMain rm;
	RemaxList rl;
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Colocando los primeros filtros desde la portada")
	@Story("1) Navegacion desde portada")
	@Link(name="www.remax.com.ar/",url="https://www.remax.com.ar/")
	@Test(priority = 1)
	public void Test_1_BusdquedaPortada() throws InterruptedException {

		BasicConfigurator.configure();
		rm = new RemaxMain(driver);
		url = "https://www.remax.com.ar/";
		Log.info("ingresando a remax.com");
		rm.navegar(url);
		rm.alquilar();
		rm.textCordoba();
		rm.opcionCordoba();
		rm.propiedad();

	}
	@Severity(SeverityLevel.BLOCKER)
	@Description("Colocando los nuevos filtros de compra y precio, navegando "
			+ "y recolectando los datos de los tres primeros links")
	@Story("2) Agregado de filtros y recolectando datos")
	@Link(name="www.remax.com.ar/listings/",url="https://www.remax.com.ar/listings/buy?page=0&pageSize=21&sort="
			+ "-createdAt&in:operationId=1&pricein=1:5000:30000&locations=in:CB@C%C3%B3rdoba"
			+ "::::::&filterCount=1&viewMode=list")
	@Test(priority = 2)
	public void test_2_FiltrosRecoleccion() throws InterruptedException {
		
		///// FILTRAR MAS DATOS/////
		Log.info("ingresando filtro: cambiando alquiler por venta");
		rl = new RemaxList(driver);
		rl.esperarWeb();
		Thread.sleep(5000);
		rl.alquilerAVenta();
		minimo = "5000";
		maximo = "30000";
		Log.info("ingresando filtro: monto( U$D" + minimo + " U$D" + maximo + ")");
		rl.precio();
		rl.montoPrecio(minimo, maximo);
		rl.esperarWeb();
		
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
			Thread.sleep(3000);
			rl.esperarWeb();
			
			///// MOVIENDO A OTRA PESTAÑA/////
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			//rd.esperarWeb();
			
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
		Log.info("recolectando datos de los 3 primeros links para archivo .txt");
		tx.crearTxt();
		for (int t = 0; t < cc; t++) {
			Log.info(pr[t].propiedadToString());
			tx.escribirTextos(pr[t].propiedadToString());
		}
	}
	@BeforeTest
	@Parameters({"browser", "nodeUrl"})
	public void SetUp(String browser, String nodeUrl) {
		try {
			bf = new BrowserFactoryCF();
			DriverFactory.getInstance().setDriver(bf.setDriver(browser, nodeUrl));
			driver = DriverFactory.getInstance().getDriver();
			}catch(Exception exc){
				Log.error("Causa : "+exc.getCause());
				Log.error("Mensaje : "+exc.getMessage());
				exc.printStackTrace();
			}
	}

	@AfterTest
	public void TearDown(){
		bf.removeDriver();
	}

}
