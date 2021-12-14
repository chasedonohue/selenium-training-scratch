import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoxScore extends BasePage {
    private final By FIND_BOX_SCORE_LINK = By.cssSelector("li[data-report-title ='Box Score'] a");
    private final By ADD_PROPERTIES_BUTTON = By.xpath( "//*[@id=\"addbutton\"]/i");
    private final By SUMMARIZE_BY_DROPDOWN = By.id("summarize_by");
    private final By SUMMARIZE_BY_PROPERTY = By.cssSelector("#summarize_by option[value='property']");
    private final By GENERATE_REPORT_BUTTON = By.cssSelector("#report_form > fieldset > div > div:nth-child(7) > ul > li:nth-child(1) > a");
    private final By SELECT_ONE_PROPERTY = By.cssSelector("ul.open");
    private final By PROPERTY_PULSE_DATASET_ID = By.id("property_pulse");
    private final By OCCUPIED_SUMMARIZED_NUMBER = By.cssSelector("#availability > table > tbody > tr:nth-child(1) > td:nth-child(13) > a");
    private final By SUMMARIZED_DRILL_IN_COUNT = By.cssSelector("#dataset_1 > table > tbody > tr:nth-child(1) > td");
    private final By COLLECTION_STATUS_REPORT = By.cssSelector("#report_groups_list > div:nth-child(35) > ul > li:nth-child(18) > a");

    public BoxScore (WebDriver driver) {
        super(driver);
    }
//    pass in driver by constructor
    public boolean scrollPastBoxScore () {
        return moveToAElement(COLLECTION_STATUS_REPORT);
    }
    public boolean clickOnBoxscoreReport () {
        return locateAndClickOnElement(FIND_BOX_SCORE_LINK);
    }
    public boolean clickAddPropertiesButton () {
        return locateAndClickOnElement(ADD_PROPERTIES_BUTTON);
    }
    public boolean pickFirstProperty (){
        return pickFirstItemInAList(SELECT_ONE_PROPERTY);
    }
    public boolean summarizeByProperty () {
        return moveToAndSelectItemInDropDown(SUMMARIZE_BY_DROPDOWN, SUMMARIZE_BY_PROPERTY);
    }
    public boolean generateReport () {
        return locateAndClickOnElement(GENERATE_REPORT_BUTTON);
    }
    public boolean verifyGeneration () {
            return waitForElementToAppear(PROPERTY_PULSE_DATASET_ID, wt.LONG_WAIT);
    }

    //The try catch needs to remain here since the Base page is returning a string for this method
    public boolean summarizedOccupied () {
        try {
            locateNumberAndStoreAsString(OCCUPIED_SUMMARIZED_NUMBER);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean clickOnSummarizedElement () {
            return doubleClickOnElementIfInnerTextNotEqualZero(OCCUPIED_SUMMARIZED_NUMBER);
    }
    //The try catch needs to remain here since the Base page is returning a string for this method
    public boolean locateDrillInOccupiedCount () {
        try {
            removeLettersFromString(SUMMARIZED_DRILL_IN_COUNT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
