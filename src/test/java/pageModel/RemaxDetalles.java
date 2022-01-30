package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import js.jScript;

public class RemaxDetalles extends pageModel.Base{
	WebDriver driver;
	jScript js = new jScript();
	
	//---DATOS PRINCIPADOS---//
	@FindBy(css = "#title-multimedia > div:nth-child(1) > h1")
	WebElement titulo;
	@FindBy(css = "#price-container > h3")
	WebElement precioDolar;
	@FindBy(xpath = "//*[@id='first-item']//*[@id='last']")
	WebElement descripcion;
	
	//---DATOS EXTRAS---//
	@FindBy(xpath = "//*[@id='second-item']//span[contains(text(),'superficie total')]")
	WebElement superficieTotal;
	@FindBy(xpath = "//*[@id='second-item']//span[contains(text(),'superficie cubierta')]")
	WebElement superficieCubierta;
	@FindBy(xpath = "//*[@id='second-item']//span[contains(text(),'baños')]")
	WebElement baños;
	@FindBy(xpath = "//*[@id='second-item']//span[contains(text(),'apto profesional')]")
	WebElement aptoProfesional;
	@FindBy(xpath = "//*[@id='second-item']//span[contains(text(),'expensas')]")
	WebElement expensas;
	@FindBy(xpath = "//*[@id='second-item']//span[contains(text(),'pisos')]")
	WebElement pisosPropiedad;
	
	///// CONSTRUCTOR/////
	public RemaxDetalles(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RemaxDetalles() {

	}
	////METODOS/////
	public String getTitulo() {
		return getText(titulo);
	}
	public String getPrecioDolar() {
		return getText(precioDolar);
	}
	public String getDescripcion() {
		return getText(descripcion);
	}
	public String getSuperficieTotal() {
		return getText(superficieTotal);
	}
	public String getSuperficieCubierta() {
		return getText(superficieCubierta);
	}
	public String getBaños() {
		return getText(baños);
	}
	public String getAptoProfesional() {
		return getText(aptoProfesional);
	}
	public String getExpensas() {
		return getText(expensas);
	}
	public String getPisosPropiedad() {
		return getText(pisosPropiedad);
	}
	////Xpath=//label[starts-with(@id,'message')]
	////*[@id="second-item"]//*[@class="feature-detail"]
	////*[@id="second-item"]//*[@class="feature-detail"]
	////*[@id="second-item"]//following::span[3]
	/*
	 * String searchText = "your element's text";
        WebElement dropdown = driver(or your parent locator of ul).findElement(By.tagName("ul"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        System.out.println(options);
        for (WebElement option : options)
        {
            if (option.getText().equals(searchText))
            {
                option.click(); // click the desired option

            }
        } */
	 
}
