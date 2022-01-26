package PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemaxList extends Base{
	/////MENU 
	@FindBy(css = "#select-operation")
	WebElement tipoOperacion;
	@FindBy(xpath = "//button[contains(text(),'Comprar')]")
	WebElement tipoCompra;
	@FindBy(xpath = "//button[contains(text(),'Aplicar filtro')]")
	WebElement aplicarTipo;
	
	/////MENU PRECIO/////
	@FindBy(css = "#select-price")
	WebElement btnPrecio;
	@FindBy(css = "#mat-input-2")
	WebElement precioDesde;
	@FindBy(css = "#mat-input-3")
	WebElement precioHasta;
	@FindBy(xpath = "//button[contains(text(),'Aplicar filtro')]")
	WebElement aplicarPrecio;
	
	/////CARD LINK/////
	@FindBy(css="qr-card-prop.ng-star-inserted:nth-child(1)")
	WebElement cardLink1;
	@FindBy(css="qr-card-prop.ng-star-inserted:nth-child(2)")
	WebElement cardLink2;
	@FindBy(css="qr-card-prop.ng-star-inserted:nth-child(3)")
	WebElement cardLink3;
	//card link 123 qr-card-prop.ng-star-inserted:nth-child(3)
	
	/////CONSTRUCTOR/////
	public RemaxList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RemaxList() {

	}
	public void alquilerAVenta() throws InterruptedException {
		clickElement(driver, tipoOperacion);
		clickElement(driver, tipoCompra);
		clickElement(driver, aplicarTipo);
		Thread.sleep(3000);
	}
	public void precio(String desde, String hasta) throws InterruptedException {
		clickElement(driver, btnPrecio);
		sendKey(driver, precioDesde, desde);
		sendKey(driver, precioHasta, hasta);
		clickElement(driver, aplicarPrecio);
		Thread.sleep(3000);
		}
}
