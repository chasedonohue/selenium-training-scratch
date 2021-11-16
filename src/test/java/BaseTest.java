import Utils.WebDriverBuilder;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class BaseTest {
    protected WebDriver driver;
    protected PerformLogin preformMyLogin;

    @Before
    public void StartupChrome() {
        WebDriverBuilder builtWebDriver = new WebDriverBuilder();
        driver = builtWebDriver.getWebDriver();

        preformMyLogin = new PerformLogin(driver);
        assertTrue("Login try catch failed", preformMyLogin.performLoginUser( "Entrata_2012", "Xento123", "https://avantic.stage.entratadev.com/"));

    }
    @After
    public void quitDriver() {

        driver.quit();

    }
}
