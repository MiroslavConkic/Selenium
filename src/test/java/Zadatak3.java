import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
////Zadatak 3
////Otvoriti bing pretrazivac, pretrazite 'Wikipedia'
////otvorite wikipedia stranicu i na njoj uradite pretragu 'Nikola Tesla'
public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com/");

        Thread.sleep(2000);
        WebElement bingSearch = driver.findElement(By.id("sb_form_q"));
        bingSearch.sendKeys("wikipedia");
        bingSearch.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement linkWikipedia = driver.findElement(By.linkText("Wikipedia"));
        linkWikipedia.click();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        Thread.sleep(2000);
        WebElement wikiSearch = driver.findElement(By.id("searchInput"));
        wikiSearch.sendKeys("Nikola Tesla");
        wikiSearch.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        driver.quit();

    }
}

