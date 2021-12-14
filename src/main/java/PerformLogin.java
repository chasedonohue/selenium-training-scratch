import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformLogin extends BasePage {

    protected By companyUserName = By.id("company_user[username]");
    protected By companyUserPassword = By.id("company_user[password]");
    private final By LOGIN_BUTTON = By.cssSelector("a[class='btn-login']");

    public PerformLogin (WebDriver driver) {
        super(driver);
    }
    public boolean navigateToLoginPage (String url) {
        return navigateToPage(url);
    }
    public boolean enterUsername (String userName) {
        return sendKeys(userName, companyUserName);
    }
    public boolean enterPassword (String password) {
        return sendKeys(password, companyUserPassword);
    }
    public boolean clickLoginButton () {
        return locateAndClickOnElement(LOGIN_BUTTON);
    }
}
