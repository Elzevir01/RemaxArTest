package driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DriverFactoryDirect {

	private static WebDriver driver;

	
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser) {
                case "CHROME":
                    driver = createRemoteDriver("chrome");
                    break;
                case "EDGE":
                    driver = createRemoteDriver("edge");
                    break;
                case "FIREFOX":
                    driver = createRemoteDriver("firefox");
                    break;
                default:
                    throw new IllegalArgumentException("Navegador no soportado: " + browser);
            }
            
        }
        driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
        return driver;
    }
    
    private static WebDriver createRemoteDriver(String browser) {
        try {
            String remoteUrl = "http://selenium-hub-c:4444/wd/hub"; // Cambiar si usas un grid en otro host
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // cambia las capability al browser encuestion //
            capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
            return new RemoteWebDriver(new URL(remoteUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL de Selenium Grid no válida", e);
        }
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
