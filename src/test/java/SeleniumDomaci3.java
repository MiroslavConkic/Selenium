import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class SeleniumDomaci3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement buttonStart = driver.findElement(By.id("start")).findElement(By.tagName("button"));
        buttonStart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        Assert.assertTrue(finish.isDisplayed());
    }
}
