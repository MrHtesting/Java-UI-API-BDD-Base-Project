package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Paths;


public class WebBrowser {
    public static WebDriver driver = null;
    public static String browser = readPropFile.readConfig("BROWSER");
    public static String baseURL = readPropFile.readConfig("URL");


    public static WebDriver getDriver() {

        if (readPropFile.readConfig("Jenkins").equals("True")) {
            browser = System.getProperty("browser");
            baseURL = System.getProperty("url");
        }

        if (driver == null) {

            if (browser.equals("Chrome")) {

                String path = Paths.get("Drivers", "chromedriver.exe").toString();
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();

            } else if (browser.equals("IE")) {

                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                String path = Paths.get("Drivers", "IEDriverServer.exe").toString();
                System.setProperty("webdriver.ie.driver", path);
                driver = new InternetExplorerDriver(capabilities);

            } else if (browser.equals("Firefox")) {
                String path = Paths.get("Drivers", "geckodriver.exe").toString();
                System.setProperty("webdriver.gecko.driver", path);
                driver = new FirefoxDriver();
            }
        }

        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        return driver;

    }
}
	

