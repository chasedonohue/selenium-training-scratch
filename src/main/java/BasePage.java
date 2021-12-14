import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WaitTimes wt = new WaitTimes();

    private final WebDriver driver;
    public String innerText;
    public String numberOnly;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean waitForElementToAppear(By locator) {
        try {
            new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    //over Ride Method
    public boolean waitForElementToAppear (By locator, Duration waitTimeInSeconds) {
        try {
        new WebDriverWait(driver, waitTimeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean locateAndClickOnElement (By locator){
        try {
        WebElement elementToBeClicked = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
        elementToBeClicked.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean pickFirstItemInAList (By locator) {
        try {
            new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElements(locator).get(0).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean moveToAndSelectItemInDropDown (By locator, By locator2) {
        try {
            WebElement locatedListItem = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions moveToItem = new Actions(driver);
            moveToItem.moveToElement(locatedListItem).click().perform();
            locateAndClickOnElement(locator2);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean moveToAElement(By locator) {
        try {
            WebElement element = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions a = new Actions(driver);
            a.moveToElement(element).perform();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean moveToItemInDropdownAndClickItem (By locator) {
        try {
            Actions a = new Actions(driver);
            WebElement item = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            a.moveToElement(item).perform();
            item.click();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public String locateNumberAndStoreAsString(By locator){
        try {
            WebElement locatedElement = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            innerText = locatedElement.getAttribute("innerHTML");
            System.out.println("Summarized number is "+ innerText);
            return innerText;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean doubleClickOnElement (By locator) {
        try {
            WebElement clickOccupiedDrillInSummarized = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions DrillA = new Actions(driver);
            DrillA.moveToElement(clickOccupiedDrillInSummarized).doubleClick().perform();
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean doubleClickOnElementIfInnerTextNotEqualZero(By locator) {
        try {
            if (!innerText.equals("0")) {
                WebElement clickOccupiedDrillInSummarized = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
                Actions DrillA = new Actions(driver);
                DrillA.moveToElement(clickOccupiedDrillInSummarized).doubleClick().perform();
            }
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String removeLettersFromString(By locator){
        try {
            if (!innerText.equals("0")) {
                WebElement locatedString = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
                String innerHTMLOfString = locatedString.getAttribute("innerHTML");
                System.out.println(innerHTMLOfString);
                numberOnly = innerHTMLOfString.replaceAll("[^0-9]", "");
                System.out.println("Refactored Drill in number is " + numberOnly);
                return numberOnly;
            } else
                return numberOnly = "0";
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean navigateToPage (String url) {
        try {
            driver.navigate().to(url);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean sendKeys (String keys, By locator) {
        try {
            WebElement autocompleteUsername = new WebDriverWait(driver, wt.DEFAULT_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
            autocompleteUsername.sendKeys(keys);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
