package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverBuilder {
    protected WebDriver driver;
    protected static String driverPath = "/Users/cdonohue/Downloads/chromedriver";

    public WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        return driver;
    }

    //headless webdriver
    public WebDriver headlessWebDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        return driver;
    }
}