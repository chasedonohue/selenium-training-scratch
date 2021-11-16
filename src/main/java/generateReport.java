//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.Assert;
////import static org.junit.Assert.assertTrue;
//import java.time.Duration;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//
//public class generateReport {
//    private WebDriver driver;
//    private preformLogin preformMyLogin;
//    private SelectLibraryInReporting3 navigateTo;
//
//
//    @Before
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cdonohue\\Downloads\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//        preformMyLogin = new preformLogin();
//        preformMyLogin.preformLoginUser(driver, "Entrata_2012", "Xento123","https://greystarinvestmentgroup.stage.entratadev.com/");
//
//    }
//    //test stage env for greystar investment group 15077
//    @Test
//    public void myTest () {
//        //assert that log in worked
//
//
//        navigateTo = new SelectLibraryInReporting3();
//        navigateTo.dropDownSelect(driver);
//        //page 2
//
//
//        //page 3
//        //find box score
//        WebElement boxScore = driver.findElement(By.xpath("//*[@id=\"report_groups_list\"]/div[12]/ul/li[8]/a"));
//        boxScore.click();
//        //add properties list
//        //WebDriverWait wait = new WebDriverWait(driver, 600);
//        WebElement adProperties = new WebDriverWait(driver, Duration.ofSeconds(600)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addbutton\"]/i")));
//        adProperties.click();
//        //add first property
//        driver.findElements(By.cssSelector("ul.open")).get(0).click();
//        //generate report
//        WebElement generateReport = driver.findElement(By.cssSelector("#report_form > fieldset > div > div:nth-child(6) > ul > li:nth-child(1) > a"));
//        generateReport.click();
//
//        //check generation time
//        WebElement verifyGeneration = new WebDriverWait(driver, Duration.ofSeconds(600)).until(ExpectedConditions.visibilityOfElementLocated(By.id("property_pulse")));
//        assertNotNull(verifyGeneration);
//        System.out.println("generation successfully");
//    }
//    @After
//    public void quitDriver() {
//
//        driver.quit();
//    }
//
//
//}
