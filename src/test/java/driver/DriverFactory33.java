package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory33 {
public DriverFactory33() {
		
	}
	/////INSTANCIA//////
	private static DriverFactory33 instance = new DriverFactory33();
	
	public static DriverFactory33 getInstance() {
		return instance;
	}
	
	/////DISEÑO DEL FACTORY/////
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}
}