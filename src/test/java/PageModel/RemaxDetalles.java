package PageModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemaxDetalles {
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
