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
	private By buscador = By.cssSelector("#searchbar-input");
	/////-- lista donde ¿quieres mudarte? --/////
	private By lista = By.cssSelector("#cdk-overlay-2");
	/////-- seleccion especifica de "Córdoba" en el buscador --/////
	private By opcionCordoba = By.xpath("//div[text()= 'Córdoba']");

	/////-- lista Tipo de propiedad --/////
	private By tipoPropiedad = By.xpath("//span[contains(text(), 'Tipo de propiedad')]");
	private By tipoOficina = By.xpath("//span[contains(text(),'Oficina')]");
	private By tipoConsultorio = By.xpath("//span[contains(text(),'Consultorio')]");
	
	private By cerrarMenuTipo = By.xpath("//div[@class='cdk-overlay-connected-position-bounding-box']");
	private By cerrarMenu = By.xpath("/html/body/div[3]/div[1]");
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
	public void propiedad(){
		findElemento(tipoPropiedad).click();
		//////
		esperarElemento(tipoOficina);
		findElemento(tipoOficina).click();
		findElemento(tipoConsultorio).click();
		//findElemento(cerrarMenuTipo).click();
		/*while(checkElement(btnBuscar)==false) {
			clickCo(cerrarMenu);
		}*/
		//derechaDe(cerrarMenuTipo);
		//findElemento(cerrarMenu).click();
		clickCo(btnBuscar);
		esperarElemento(btnBuscar);
		findElemento(btnBuscar).click();
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
