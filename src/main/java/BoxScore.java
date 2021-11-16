import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BoxScore extends BasePage {
    private final By findBoxScoreLink = By.cssSelector("li[data-report-title ='Box Score'] a");
    private final By addPropertiesButton = By.xpath( "//*[@id=\"addbutton\"]/i");
    private final By summarizeByDropDown = By.id("summarize_by");
    private final By summarizeByProperty = By.cssSelector("#summarize_by option[value='property']");
    private final By generateReportButton = By.cssSelector("#report_form > fieldset > div > div:nth-child(7) > ul > li:nth-child(1) > a");
    private final By selectOneProperty = By.cssSelector("ul.open");
    private final By propertyPulseDatasetID = By.id("property_pulse");
    private final By OccupiedSummarizedNumber = By.cssSelector("#availability > table > tbody > tr:nth-child(1) > td:nth-child(13) > a");
    private final By SummarizedDrillInCount = By.cssSelector("#dataset_1 > table > tbody > tr:nth-child(1) > td");

    public BoxScore (WebDriver driver) {
        super(driver);
    }
    //pass in driver by constructor
    public boolean findBoxscoreReport () {
        return locateAndClickOnElement(findBoxScoreLink);
    }
    public boolean clickAddPropertiesButton () {
        return locateAndClickOnElement(addPropertiesButton);
    }
    public boolean pickFirstProperty (){
        return pickFirstItemInAList(selectOneProperty);
    }
    public boolean summarizeByProperty () {
        return moveToAndSelectItemInDropDown(summarizeByDropDown, summarizeByProperty);
    }
    public boolean generateReport () {
        return locateAndClickOnElement(generateReportButton);
    }
    public boolean verifyGeneration () {
        try {
            waitForElementToAppear(propertyPulseDatasetID, wt.longWait);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //refactored code
    public boolean summarizedOccupied () {
        try {
            findSummarizedReportNumber(OccupiedSummarizedNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean clickOnSummarizedElement () {
        try {
            clickOnSummarizedElement(OccupiedSummarizedNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean locateDrillInOccupiedCount () {
        try {
            locateDrillInElement(SummarizedDrillInCount);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//    public boolean validateOccupiedMatchesDrillIn () {
//        try {
//            checkIfDrillInMatchesSummarizedElement();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
