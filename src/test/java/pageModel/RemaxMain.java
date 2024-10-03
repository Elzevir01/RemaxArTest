package pageModel;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RemaxMain extends Base{

	String expectedTitle = "Venta y Alquiler de Propiedades | RE/MAX";

	///// ELEMENTOS WEB/////
	private By btnAlquilar = By.xpath("//button[contains(text(),'Quiero alquilar')]");
	private By buscador = By.xpath("//div//input");//div[@class='searcher searcher--home-searcher']");
	
	/////-- seleccion especifica de "Córdoba" en el buscador --/////
	private By opcionCordoba = By.xpath("//div[text()= 'Córdoba']");

	/////-- lista Tipo de propiedad --/////
	private By tipoPropiedad = By.xpath("//span[contains(text(), 'Tipo de propiedad')]");////*[@id=\\\"property-type\\\"]
	private By tipoOficina = By.xpath("//span[contains(text(),'Oficina')]");
	private By tipoConsultorio = By.xpath("//span[contains(text(),'Consultorio')]");
	private By cerrarMenuTipo = By.xpath("//div[@class='cdk-overlay-container']");
	
	/////-- iniciar la busqueda --/////
	private By btnBuscar = By.xpath("//button[@id='button-search']");

	///// CONSTRUCTOR/////
	public RemaxMain(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RemaxMain() {

	}
	
	//////METODOS /////
	public void alquilar() {
		findElemento(btnAlquilar).click();
	}
	public void textCordoba(){
		sendKey(buscador, "cordoba");
	}
	public void opcionCordoba() {
		
		esperarElemento(opcionCordoba);
		
		if(checkElement(opcionCordoba)) {
			findElemento(opcionCordoba).click();
			}
	}
	public void propiedad() throws InterruptedException{
		findElemento(tipoPropiedad).click();
		//////
		esperarElemento(tipoOficina);
		findElemento(tipoOficina).click();
		findElemento(tipoConsultorio).click();
		Thread.sleep(2000);
		findElemento(cerrarMenuTipo).click();
		pressESC();
		findElemento(tipoPropiedad).click();
		//clickCo(btnBuscar);
	}
	public void buscar() {
		esperarElemento(btnBuscar);
		findElemento(btnBuscar).click();;
	}
	public void pressESC() {
		try {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		}catch(Exception e) {
			
		}
	}
	
	
}
