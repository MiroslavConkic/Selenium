import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

import static org.openqa.selenium.Keys.ENTER;

public class SeleniumDomaci1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");

        Thread.sleep(3000);
        WebElement search = driver.findElement(By.className("ytSearchboxComponentInput"));
        search.sendKeys("sectionx galaxian");
        search.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        WebElement rezultatPretrage = driver.findElement(By.linkText("Section X - Galaxian"));
        rezultatPretrage.click();

    }
}
