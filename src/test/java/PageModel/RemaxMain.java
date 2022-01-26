package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Js.jScript;

public class RemaxMain extends Base{
	WebDriver driver;
	jScript js = new jScript();
	String expectedTitle = "Venta y Alquiler de Propiedades | RE/MAX";

	///// ELEMENTOS WEB/////
	@FindBy(xpath = "//button[contains(text(),'Quiero alquilar')]")
	WebElement btnAlquilar;
	@FindBy(css = "#searchbar-input")//.input-label
	WebElement buscador;
	
	@FindBy(css = "#cdk-overlay-2")
	WebElement lista;
	
	@FindBy(css = "#mat-option-19 > span:nth-child(1) > div")
	WebElement opcionCordoba;
	//selectByVisibleText
	//#mat-option-422 > span:nth-child(1) > div
	
	@FindBy(css = "#property-type")
	WebElement tipoPropiedad;
	@FindBy(css = "#mat-option-6")
	WebElement tipoOficina;
	@FindBy(css = "#mat-option-7")
	WebElement tipoConsultorio;
	
	@FindBy(css = ".cdk-overlay-backdrop")
	WebElement cerrarMenuTIpo;
	//.cdk-overlay-backdrop
	
	@FindBy(css = "#button-search")
	WebElement btnBuscar;

	///// CONSTRUCTOR/////
	public RemaxMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RemaxMain() {

	}
	//////METODOS /////
	public void alquilar() {
		clickElement(driver, btnAlquilar);
	}
	public void textCordoba() throws InterruptedException {
		sendKey(driver, buscador, "cordoba");
		Thread.sleep(3000);
	}
	public void opcionCordoba() {
		String cssCordoba = "#mat-option-19 > span:nth-child(1) > div";
		WebElement cba = driver.findElement(By.cssSelector(cssCordoba));
		js.moveyhightlight(driver, cba);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssCordoba)));
		
		if(cba.isDisplayed()) {
			cba.click();
			}
	}
	public void propiedad() throws InterruptedException {
		clickElement(driver, tipoPropiedad);
		Thread.sleep(1000);
		clickElement(driver, tipoOficina);
		clickElement(driver, tipoConsultorio);
		clickElement(driver, cerrarMenuTIpo);
		clickElement(driver, btnBuscar);
	}
}
