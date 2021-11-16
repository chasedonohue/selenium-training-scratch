import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectLibraryInReporting3 extends BasePage{
    private WebDriver driver;

    public SelectLibraryInReporting3 (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean dropDownSelect (){
        try {
            WebElement dropDown = waitForElementToAppear(By.id("reports"));
            Actions a = new Actions(driver);
            a.moveToElement(dropDown).perform();
            WebElement library = waitForElementToAppear(By.cssSelector("li[data-module-title ='Library'] a"));
            a.moveToElement(library).perform();
            library.click();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
