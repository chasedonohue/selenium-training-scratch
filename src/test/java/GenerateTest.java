import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GenerateTest extends BaseTest {
    private SelectLibraryInReporting3 navigateTo;
    private BoxScore boxScoreReport;
    public String innerText;
    public String numberOnly;

    @Test
    public void performanceTest() {
        navigateTo = new SelectLibraryInReporting3(driver);
        assertTrue("Reporting 3.0 cant find library from dropdown",navigateTo.dropDownSelect());
        //page 3
        boxScoreReport = new BoxScore(driver);
        assertTrue("Box Score is not in library",boxScoreReport.findBoxscoreReport());
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
        assertTrue("Reporting 3.0 cant find library from dropdown",navigateTo.dropDownSelect());
        boxScoreReport = new BoxScore(driver);
        assertTrue("Box Score is not in library",boxScoreReport.findBoxscoreReport());
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
        assertTrue("something in the massive drill in failed", boxScoreReport.summarizedOccupied());
        assertTrue("Could not click on summarized number",boxScoreReport.clickOnSummarizedElement());
        assertTrue("drill in number not found", boxScoreReport.locateDrillInOccupiedCount());
//        assertTrue("drill in does not match summarized number", boxScoreReport.validateOccupiedMatchesDrillIn());
        assertEquals("drill in does not match summarized number", innerText, numberOnly);

        System.out.println("generation successful");
    }


}
