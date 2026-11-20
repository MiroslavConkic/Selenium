import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak7 {

    WebDriver driver;
    WebDriverWait wait;
    String validUsername = "student";
    String validPassword = "Password123";
    String invalidUsername = "222";
    String invalidPassword = "222";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().driverVersion("156.0.8078.79").setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    @Test(priority=1)
    public void userCanLogIn() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");

        String actualLogInMessage = driver.findElement(By.className("post-title")).getText();
        String expectedLogInMessage = "Logged In Successfully";
        Assert.assertEquals(actualLogInMessage, expectedLogInMessage);

        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

        WebElement message = driver.findElement(By.cssSelector(".has-text-align-center.wp-block-paragraph"));
        Assert.assertEquals(message.getText(), "Congratulations "+validUsername+". You successfully logged in!");
    }

    @Test(priority=2)
    public void userCanLogOut(){
        if(driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/")){
         WebElement logOutButton = driver.findElement(By.linkText("Log out"));
         logOutButton.click();
         Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
         Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
         Assert.assertTrue(driver.findElement(By.id("submit")).isDisplayed());
        } else {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.id("submit"));

            usernameField.clear();
            usernameField.sendKeys(validUsername);

            passwordField.clear();
            passwordField.sendKeys(validPassword);

            submitButton.click();
            WebElement logOutButton = driver.findElement(By.linkText("Log out"));
            logOutButton.click();

            Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("submit")).isDisplayed());
        }
    }

    @Test(priority=3)
    public void wrongUsernameAndPassword() throws InterruptedException {

        driver.manage().deleteAllCookies();
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys(invalidUsername);

        passwordField.clear();
        passwordField.sendKeys(invalidPassword);

        submitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("submit")).isDisplayed());

    }

    @Test(priority=4)
    public void emptyUsername(){
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        driver.manage().deleteAllCookies();
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys("");

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("submit")).isDisplayed());

    }

    @Test(priority=5)
    public void loginWithUrl() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        String loggedInUrl = driver.getCurrentUrl();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.navigate().to(loggedInUrl);
    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}