import Utils.WebDriverBuilder;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class BaseTest {
    protected WebDriver driver;
    protected PerformLogin performMyLogin;

    @Before
    public void StartupChrome() {
        WebDriverBuilder builtWebDriver = new WebDriverBuilder();
        driver = builtWebDriver.getWebDriver();

        performMyLogin = new PerformLogin(driver);
        assertTrue("login page failed to load", performMyLogin.navigateToLoginPage("https://avantic.trunk.entratadev.com/"));
        assertTrue("unable to send username information", performMyLogin.enterUsername("Entrata_2012"));
        assertTrue("Unable to send password information", performMyLogin.enterPassword("Xento123"));
        assertTrue("Unable to locate login button", performMyLogin.clickLoginButton());
    }
    @After
    public void quitDriver() {
        driver.quit();
    }
}
