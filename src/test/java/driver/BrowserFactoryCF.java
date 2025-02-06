package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactoryCF {
	WebDriver driver;

	public BrowserFactoryCF() {

	}

	private static DriverFactory33 instance = new DriverFactory33();

	public static DriverFactory33 getInstance() {
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver setDriver(String browser, String nodeURL) throws MalformedURLException {
		System.getProperty("java.classpath");
		new DesiredCapabilities();
		
		switch (browser.toString().toUpperCase()) {
		case "CHROME":
			ChromeOptions capc = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(nodeURL), capc);
			break;
		case "FIREFOX":
			FirefoxOptions capf = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(nodeURL), capf);
			break;
		case "EDGE":
			EdgeOptions cape = new EdgeOptions();
			driver = new RemoteWebDriver(new URL(nodeURL), cape);
			break;

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;

	}

	public void removeDriver() {
		driver.close();
		driver.quit();

	}

}
