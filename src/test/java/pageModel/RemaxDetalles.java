package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import js.jScript;

public class RemaxDetalles extends pageModel.Base{
	//WebDriver driver;
	
	private By ilimitado = By.xpath("//li[text()='Ilimitado']");
	//---DATOS PRINCIPADOS---//
	private By titulo = By.cssSelector("#title-multimedia > div:nth-child(1) > h1");
	private By precioDolar = By.cssSelector("#price-container > h3");
	private By descripcion = By.xpath("//*[@id='first-item']//*[@id='last']");
	
	//---DATOS EXTRAS---//
	private By superficieTotal = By.xpath("//*[@id='second-item']//span[contains(text(),'superficie total')]");
	private By superficieCubierta = By.xpath("//*[@id='second-item']//span[contains(text(),'superficie cubierta')]");
	private By baños = By.xpath("//*[@id='second-item']//span[contains(text(),'ba�os')]");
	private By aptoProfesional = By.xpath("//*[@id='second-item']//span[contains(text(),'apto profesional')]");
	private By expensas = By.xpath("//*[@id='second-item']//span[contains(text(),'expensas')]");
	private By pisosPropiedad = By.xpath("//*[@id='second-item']//span[contains(text(),'pisos')]");
	
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
	 
}
