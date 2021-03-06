import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GenerateTest extends BaseTest {
    private SelectLibraryInReporting3 navigateTo;
    private BoxScore boxScoreReport;
    //Strings need to be stored here for Assert Equals
    public String innerText;
    public String numberOnly;

    @Test
    public void performanceTest() {
        navigateTo = new SelectLibraryInReporting3(driver);
        assertTrue("Cant Find Reporting Tab",navigateTo.dropDownSelect());
        assertTrue("Reporting 3.0 cant find library from dropdown",navigateTo.librarySelect());
        //page 3
        boxScoreReport = new BoxScore(driver);
        assertTrue("cant find box score in Library", boxScoreReport.scrollPastBoxScore());
        assertTrue("cant click on box score report link",boxScoreReport.clickOnBoxscoreReport());
        assertTrue("Box score report is not found",boxScoreReport.clickAddPropertiesButton());
        //add first property in report library list
        assertTrue("unable to add property during generation",boxScoreReport.pickFirstProperty());
        //click summarize
        assertTrue("Couldn't select summarize option", boxScoreReport.summarizeByProperty());
        //click generate
        assertTrue("could not find generate report button",boxScoreReport.generateReport());
        //check generation time
        assertTrue("Generation failed in 600 secs",boxScoreReport.verifyGeneration());
//        boxScoreReport drillIn validation;
        System.out.println("generation successful in under 600 secs");

    }
    @Test
    public void drillInTest (){

        navigateTo = new SelectLibraryInReporting3(driver);
        assertTrue("Cant Find Reporting Tab",navigateTo.dropDownSelect());
        assertTrue("Reporting 3.0 cant find library from dropdown",navigateTo.librarySelect());

        boxScoreReport = new BoxScore(driver);
        assertTrue("cant find box score", boxScoreReport.scrollPastBoxScore());
        assertTrue("cant click on box score",boxScoreReport.clickOnBoxscoreReport());
        assertTrue("Box score report is not found",boxScoreReport.clickAddPropertiesButton());
        //add first property in report library list
        assertTrue("unable to add property during generation",boxScoreReport.pickFirstProperty());
        //click summarize
        assertTrue("Couldn't select summarize option", boxScoreReport.summarizeByProperty());
        //click generate
        assertTrue("could not find generate report button",boxScoreReport.generateReport());
        //check generation time
        assertTrue("Generation failed in 600 secs",boxScoreReport.verifyGeneration());
//        boxScoreReport drillIn validation;
        assertEquals("failed to find drill in occupied counts or unable to select drill in", boxScoreReport.summarizedOccupied(), boxScoreReport.clickOnSummarizedElement());
        assertEquals("Unable to locate drill in",boxScoreReport.innerText, boxScoreReport.locateDrillInOccupiedCount());
        System.out.println("generate test file String = " + innerText + ":inner text" + numberOnly + ":numbers only");
        assertEquals("drill in does not match summarized number", boxScoreReport.innerText, boxScoreReport.numberOnly);

        System.out.println("generation successful");
    }




}
