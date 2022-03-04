package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import js.jScript;

public class RemaxMain extends Base{
	//WebDriver driver;
	jScript js = new jScript();
	String expectedTitle = "Venta y Alquiler de Propiedades | RE/MAX";

	///// ELEMENTOS WEB/////
	@FindBy(xpath = "//button[contains(text(),'Quiero alquilar')]")
	WebElement btnAlquilar;
	@FindBy(css = "#searchbar-input")
	WebElement buscador;
	
	@FindBy(css = "#cdk-overlay-2")
	WebElement lista;
	
	@FindBy(xpath = "//*[@id=\"mat-option-10\"]")
	WebElement opcionCordoba;
	
	@FindBy(css = "#property-type")
	WebElement tipoPropiedad;
	@FindBy(xpath = "//span[contains(text(),'Oficina')]")
	WebElement tipoOficina;
	@FindBy(xpath = "//span[contains(text(),'Consultorio')]")
	WebElement tipoConsultorio;
	
	@FindBy(css = ".cdk-overlay-backdrop")
	WebElement cerrarMenuTIpo;
	//.cdk-overlay-backdrop
	
	@FindBy(css = "#button-search")
	WebElement btnBuscar;

	///// CONSTRUCTOR/////
	public RemaxMain(WebDriver driver) {
		super.driver = driver;
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
		esperarCss(driver, cssCordoba);
		js.moveyhightlight(driver, cba);
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
