import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4_logout {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        //WebElement practiceLink = driver.findElement(By.linkText("Practice"));
        practiceLink.click();

        WebElement loginLink = driver.findElement(By.linkText("Test Login Page"));
        loginLink.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        logoutButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement headerLogIn = driver.findElement(By.id("login"));
        WebElement headerLogInText = headerLogIn.findElement(By.tagName("h2"));
        String actualHeaderText = headerLogInText.getText();
        String expectedHeaderText = "Test login";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);


        //driver.quit();
    }
}
//Zadatak 4
//Na linku https://practicetestautomation.com/ otici do
// login stranice, uradite log in i dodajte asertacije