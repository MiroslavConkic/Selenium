import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Selenium8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        List<WebElement> cards = driver.findElements(By.className("card-body"));

        for(int i=0; i<cards.size(); i++){
            if (cards.get(i).getText().equals("Book Store Application")){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cards.get(i));
                Thread.sleep(1000);
                cards.get(i).click();
                break;
            }
        }


    }
}
