package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RemaxList extends Base {
	int numero =0;
	///// MENU /////
	private By tipoOperacion = By.cssSelector("#select-operation");
	private By tipoCompra = By.xpath("//button[contains(text(),'Comprar')]");
	private By aplicarTipo = By.xpath("//button[contains(text(),'Aplicar filtro')]");
	///// MENU PRECIO/////
	private By btnPrecio = By.cssSelector("#select-price");
	private By precioDesde = By.xpath("//*[@id='from']");
	private By precioHasta = By.xpath("//*[@id='to']");
	private By aplicarPrecio = By.xpath("//button[contains(text(),'Aplicar filtro')]");

	///// CARD LINK/////
	private By cardLinkList = By.xpath("//qr-card-property");
	///// CONSTRUCTOR/////
	public RemaxList(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void alquilerAVenta() throws InterruptedException {
		findElemento(tipoOperacion).click();
		esperarElemento(tipoCompra);
		findElemento(tipoCompra).click();
		findElemento(aplicarTipo).click();
		Thread.sleep(3000);
	}
	
	public void precioMonto(String desde, String hasta) throws InterruptedException {
		findElemento(btnPrecio).click();
		Thread.sleep(2000);
		esperarElemento(precioDesde);
		findElemento(precioDesde).clear();
		sendKey(precioDesde, desde);
		findElemento(precioHasta).clear();
		sendKey(precioHasta, hasta);
		findElemento(aplicarPrecio).click();
	}
	
	public int cardListCount() {
		
		return listaSize(cardLinkList);
	}
	public WebElement listaElement(int numero) {
		
		return  listaElemento(cardLinkList,numero);
	}
}
