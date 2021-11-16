import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformLogin {
    private WebDriver driver;

    public PerformLogin (WebDriver driver) {

        this.driver = driver;
    }
    public boolean performLoginUser (String userName, String password, String url) {
        try {
            driver.get(url);
            driver.navigate().to(url);
            //username
            WebElement autocompleteUsername = driver.findElement(By.id("company_user[username]"));
            autocompleteUsername.sendKeys(userName);
            //password
            WebElement autocompletePassword = driver.findElement(By.id("company_user[password]"));
            autocompletePassword.sendKeys(password);
            //login button
            WebElement login = driver.findElement(By.cssSelector("a[class='btn-login']"));
            login.click();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
