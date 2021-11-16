import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("browser test");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\cdonohue\\Downloads\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.google.com");
         driver.navigate().to("https://www.google.com/");
        WebElement autocomplete = driver.findElement(By.name("q"));
        autocomplete.sendKeys("test search");
        //WebElement search = driver.findElement(By.name("btnK"));
        autocomplete.submit();

        driver.findElement(By.id("rso")).findElements(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).get(0).click();

        driver.quit();
    }
}
