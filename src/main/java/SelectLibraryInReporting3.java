import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SelectLibraryInReporting3 extends BasePage{

    private final By REPORT_TAB = By.id("reports");
    private final By LIBRARY_TAB = By.cssSelector("li[data-module-title ='Library'] a");

    public SelectLibraryInReporting3 (WebDriver driver) {
        super(driver);
    }

    public boolean dropDownSelect (){
        return moveToAElement(REPORT_TAB);
    }
    public boolean librarySelect () {
        return moveToItemInDropdownAndClickItem(LIBRARY_TAB);
    }
}
