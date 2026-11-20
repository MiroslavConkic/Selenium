import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4_negativan {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement loginLink = driver.findElement(By.linkText("Test Login Page"));
        loginLink.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("student1");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("Password1231");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);
        WebElement error = driver.findElement(By.className("show"));
        Assert.assertTrue(error.isDisplayed());

        driver.quit();

    }
}
