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
		try {
		return getText(titulo);}
		catch(Exception e){
			return "";}
	}
	public String getPrecioDolar() {
		try {
		return getText(precioDolar);}
		catch(Exception e){
			return "";}
	}
	public String getDescripcion() {
		try{
			return getText(descripcion);}
		catch(Exception e){
			return "";}
	}
	public String getSuperficieTotal() {
		try{
		return getText(superficieTotal);}
		catch(Exception e){
			return "";}
	}
	public String getSuperficieCubierta() {
		try{
			return getText(superficieCubierta);}
		catch(Exception e){
			return "";}
	}
	public String getBaños() {
		try {
		return getText(baños);}
		catch(Exception e){
			return "";}
	}
	public String getAptoProfesional() {
		try {
		return getText(aptoProfesional);}
		catch(Exception e){
			return "";}
	}
	public String getExpensas() {
		try{
			return getText(expensas);}
		catch(Exception e){
			return "";}
	}
	public String getPisosPropiedad() {
		try{
			return getText(pisosPropiedad);}
		catch(Exception e){
			return "";}
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
