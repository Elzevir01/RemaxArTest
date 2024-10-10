package pageModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Base {
	WebDriver driver;
	String expectedTitle = "";

	///// CONSTRUCTOR/////
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Base() {
	}

	//// METODOS/////
	public WebElement findElemento(By elemento) {
		return driver.findElement(elemento);
	}
	public WebElement listaElemento(By elemento, int numero) {
        List<WebElement> lista = driver.findElements(elemento);
        WebElement elementoNumero = lista.get(numero);
		return elementoNumero;
	}
	public int listaSize(By elemento) {
		List<WebElement> lista = driver.findElements(elemento);
		return lista.size();
		
	}
	
	public void sendKey(By elemento, String texto) {
		findElemento(elemento).sendKeys(texto);
	}
	public void cursorTo(By elemento) {
		new Actions(driver).moveToElement(findElemento(elemento)).perform();
	}
	public void navegar(String url) {
		driver.get(url);
	}
	public String titulo() {
		return driver.getTitle();
	}
	public void esperarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));	
	}
	public void esperarWeb() {
	}
	public void confirmarTitulo(String titulo) {
		ExpectedConditions.titleIs(titulo);
	}
	public boolean checkElement(By elemento) {
		WebElement we = findElemento(elemento);
		try {
			if (we.isDisplayed()) {
				System.out.println("Elemento: [ " + we.getText() + " ] Existe");
			}
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Elemento: [ " + we.getText() + " ]X NO Existe");
			return false;
		}
	}
	public String getText(By elemento) {
		
		if (checkElement(elemento))
			return findElemento(elemento).getText();
		else
			return "";
	}
	public void derechaDe(By elemento) {
		driver.findElement(with(By.xpath("/html/body/div[3]")).toRightOf(elemento)).click();
	}
	public void clickCo(By elemento) {
		Actions builder = new Actions(driver);   
		builder.moveToElement(findElemento(elemento), 25, 25).click().build().perform();
	}
	public void pressEsc() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}
	
}
