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
    public int innerTextInt;
    public int numberOnlyInt;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    //over Ride Method
    public WebElement waitForElementToAppear (By locator, Duration waitTimeInSeconds) {
        try {
        WebElement BaseWebElement = new WebDriverWait(driver, waitTimeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return BaseWebElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public WebElement waitForElementToAppear(By locator) {
        try {
        WebElement BaseWebElement = new WebDriverWait(driver, wt.defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator));

        return BaseWebElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public boolean locateAndClickOnElement (By locator){
        try {
        WebElement elementToBeClicked = new WebDriverWait(driver, wt.defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator));
        elementToBeClicked.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean pickFirstItemInAList (By locator) {
        try {
            waitForElementToAppear(locator);
            driver.findElements(locator).get(0).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean moveToAndSelectItemInDropDown (By locator, By locator2) {
        try {
            WebElement locatedListItem = waitForElementToAppear(locator);
            Actions moveToItem = new Actions(driver);
            moveToItem.moveToElement(locatedListItem).click().perform();
            locateAndClickOnElement(locator2);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String findSummarizedReportNumber (By locator){
            WebElement checkOccupiedDrillInSummarized = waitForElementToAppear(locator);
            innerText = checkOccupiedDrillInSummarized.getAttribute("innerHTML");
            System.out.println("Summarized number is "+ innerText);
            return innerText;
    }
    public void clickOnSummarizedElement (By locator) {
            WebElement clickOccupiedDrillInSummarized = waitForElementToAppear(locator);
            Actions DrillA = new Actions(driver);
            DrillA.moveToElement(clickOccupiedDrillInSummarized).doubleClick().perform();
    }
    public String locateDrillInElement (By locator){
            WebElement LoadedDrillInResult = waitForElementToAppear(locator);
            String stringOfDrillIn = LoadedDrillInResult.getAttribute("innerHTML");
            System.out.println(stringOfDrillIn);
            numberOnly= stringOfDrillIn.replaceAll("[^0-9]", "");
            System.out.println("Refactored Drill in number is "+numberOnly);
            return numberOnly;
    }

//    public boolean checkIfDrillInMatchesSummarizedElement () {
//            innerTextInt = Integer.parseInt(innerText);
//            numberOnlyInt = Integer.parseInt(numberOnly);
//            boolean drillInValidate = false;
//
//            if (innerTextInt == numberOnlyInt) {
//                drillInValidate = true;
//                System.out.println("If else found a match! Drill in matches summarized number");
//            } else {
//                System.out.println("Drill does not match summarized number");
//            }
//            return drillInValidate;
//    }
}
