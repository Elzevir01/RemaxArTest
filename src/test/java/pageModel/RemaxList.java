package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemaxList extends Base {
	///// MENU /////
	private By tipoOperacion = By.cssSelector("#select-operation");
	private By tipoCompra = By.xpath("//button[contains(text(),'Comprar')]");
	private By aplicarTipo = By.xpath("//button[contains(text(),'Aplicar filtro')]");

	///// MENU PRECIO/////
	private By btnPrecio = By.cssSelector("#select-price");
	private By precioDesde = By.xpath("//*[@id=\"mat-input-0\"]");
	private By precioHasta = By.xpath("//*[@id=\"mat-input-1\"]");
	private By aplicarPrecio = By.xpath("//button[contains(text(),'Aplicar filtro')]");

	///// CARD LINK/////
	private By cardLink1 = By.cssSelector("qr-card-prop.ng-star-inserted:nth-child(1)");
	private By cardLink2 = By.cssSelector("qr-card-prop.ng-star-inserted:nth-child(2)");
	private By cardLink3 = By.cssSelector("qr-card-prop.ng-star-inserted:nth-child(3)");

	///// CONSTRUCTOR/////
	public RemaxList(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void alquilerAVenta() throws InterruptedException {
		esperarElemento(tipoOperacion);
		findElemento(tipoOperacion).click();
		findElemento(tipoCompra).click();
		findElemento(aplicarTipo).click();
		Thread.sleep(3000);
	}
	
	public void precio() {
		findElemento(btnPrecio).click();
	}
	
	public void montoPrecio(String desde, String hasta){
		findElemento(precioDesde).clear();
		sendKey(precioDesde, desde);
		findElemento(precioHasta).clear();
		sendKey(precioHasta, hasta);
		findElemento(aplicarPrecio).click();
	}

	public void card1() {
		findElemento(cardLink1).click();
	}

	public void card2() {
		findElemento(cardLink2).click();
	}

	public void card3() {
		findElemento(cardLink3).click();
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
