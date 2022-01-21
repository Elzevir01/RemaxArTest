package PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Js.jScript;

public class RemaxMain extends Base{
	WebDriver driver;
	jScript js = new jScript();
	String expectedTitle = "Venta y Alquiler de Propiedades | RE/MAX";

	///// ELEMENTOS WEB/////
	@FindBy(xpath = "//button[contains(text(),'Quiero alquilar')]")
	WebElement btnAlquilar;
	@FindBy(css = "#search-input")
	WebElement buscador;
	@FindBy(css = "#property-type")
	WebElement tipoPropiedad;
	@FindBy(css = "#mat-option-6")
	WebElement tipoOficina;
	@FindBy(css = "#mat-option-7")
	WebElement tipoConsultorio;
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
}
