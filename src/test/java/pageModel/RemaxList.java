package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemaxList extends Base {
	///// MENU
	@FindBy(css = "#select-operation")
	WebElement tipoOperacion;
	@FindBy(xpath = "//button[contains(text(),'Comprar')]")
	WebElement tipoCompra;
	@FindBy(xpath = "//button[contains(text(),'Aplicar filtro')]")
	WebElement aplicarTipo;

	///// MENU PRECIO/////
	@FindBy(css = "#select-price")
	WebElement btnPrecio;
	@FindBy(xpath = "//*[@id=\"mat-input-0\"]")
	WebElement precioDesde;
	@FindBy(xpath = "//*[@id=\"mat-input-1\"]")
	WebElement precioHasta;
	@FindBy(xpath = "//button[contains(text(),'Aplicar filtro')]")
	WebElement aplicarPrecio;

	///// CARD LINK/////
	@FindBy(css = "qr-card-prop.ng-star-inserted:nth-child(1)")
	WebElement cardLink1;
	@FindBy(css = "qr-card-prop.ng-star-inserted:nth-child(2)")
	WebElement cardLink2;
	@FindBy(css = "qr-card-prop.ng-star-inserted:nth-child(3)")
	WebElement cardLink3;

	///// CONSTRUCTOR/////
	public RemaxList(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void alquilerAVenta() throws InterruptedException {
		esperarCss(driver, "#select-operation");
		clickElement(driver, tipoOperacion);
		clickElement(driver, tipoCompra);
		clickElement(driver, aplicarTipo);
		Thread.sleep(3000);
	}
	
	public void precio() {
		clickElement(driver, btnPrecio);
	}
	
	public void montoPrecio(String desde, String hasta) throws InterruptedException {
		clearText(precioDesde);
		sendKey(driver, precioDesde, desde);
		clearText(precioHasta);
		sendKey(driver, precioHasta, hasta);
		clickElement(driver, aplicarPrecio);
		Thread.sleep(5000);
	}

	public void card1() {
		clickElement(driver, cardLink1);
	}

	public void card2() {
		clickElement(driver, cardLink2);
	}

	public void card3() {
		clickElement(driver, cardLink3);
	}
	
	public int cardCount() {
		int c = 0;
		if (checkElement(cardLink1) == true)
			c = 1;
		if (checkElement(cardLink2) == true)
			c = 2;
		if (checkElement(cardLink3) == true)
			c = 3;
		return c;
	}
}
