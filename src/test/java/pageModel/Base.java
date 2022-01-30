package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import js.jScript;

public class Base {
	WebDriver driver;
	jScript js = new jScript();
	String expectedTitle = "";

	///// CONSTRUCTOR/////
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public Base() {
	}
	
	////METODOS/////
	public void clickElement(WebDriver driver, WebElement elemento) {//WebDriver driver,
		js.highLight(driver, elemento);
        elemento.click();
    }
	public void clickElementFocus( WebDriver driver, WebElement elemento) {
		js.moveyhightlight(driver, elemento);
		elemento.click();
		js.waitForPageToLoad(driver);
	}
	
	public void sendKey(WebDriver driver, WebElement elemento, String texto) {
		js.highLight(driver, elemento);
		elemento.sendKeys(texto);
	}
	public void cursorTo(WebDriver driver, WebElement elemento) {
		js.highLight(driver, elemento);
		new Actions(driver).moveToElement(elemento).perform();
	}
	public boolean checkElement(WebElement elemento) {
	    try {
	    	if (elemento.isDisplayed()) {
	    		System.out.println("Elemento: ["+elemento.getText()+" ] Existe");
			}
	    	return true;
	    }catch(org.openqa.selenium.NoSuchElementException e) {
	    	System.out.println("Elemento: ["+elemento.getText()+" ]X NO Existe");
	    	return false;
	    }
	}
	public void navegar(WebDriver driver, String url) {
		driver.get(url);
		js.waitForPageToLoad(driver);
	}
	public String titulo(WebDriver driver) {
		return driver.getTitle();
	}
	public String getText(WebElement elemento) {
		js.highLight(driver, elemento);
		return elemento.getText();
}
}