import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
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
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement postTitle = driver.findElement(By.className("post-title"));
        String actualPostTitle = postTitle.getText();
        String expectedPostTitle = "Logged In Successfully";
        Assert.assertEquals(actualPostTitle, expectedPostTitle);

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        String actualLogoutButton = logoutButton.getText();
        String expectedLogoutButton = "Log out";
        Assert.assertEquals(actualLogoutButton, expectedLogoutButton);

        driver.quit();
    }
}
//Zadatak 4
//Na linku https://practicetestautomation.com/ otici do
// login stranice, uradite log in i dodajte asertacije