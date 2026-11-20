import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.security.Key;

public class SelDomaci2Valid {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://the-internet.herokuapp.com/login";
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("username")).getText(), username);
    }
}