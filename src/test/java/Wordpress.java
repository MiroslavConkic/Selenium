import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Wordpress {
    public static void main(String[] args) throws InterruptedException {
        String username = "mirens83";
        String password = "Ivikivi20001#";


        WebDriverManager.chromedriver().driverVersion("156.0.8078.79").setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).pause(Duration.ofMillis(500)).sendKeys(Keys.SPACE).perform();

        Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();
        usernameField.sendKeys(username);
        actions.sendKeys(Keys.TAB).pause(Duration.ofMillis(500)).sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        continueButton.click();

        Thread.sleep(5000);
        WebElement title = driver.findElement(By.className("wrap"));

        Assert.assertTrue(driver.findElement(By.id("wpadminbar")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://mirenscom.wordpress.com/wp-admin/");
        Assert.assertEquals(driver.findElement(By.className("display-name")).getText(), "mirens");
        Assert.assertEquals(title.findElement(By.tagName("h1")).getText(), "Dashboard");

    }
}
