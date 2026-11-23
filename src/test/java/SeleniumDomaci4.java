import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class SeleniumDomaci4 {

    WebDriver driver;
    String username = "miroslavConkic";
    String password = "miroslav123";

    @BeforeClass
    public void beforeClass(){
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://practice.expandtesting.com/login/");
    }

    @Test(priority=1)
    public void registracija(){

        driver.navigate().to("https://practice.expandtesting.com/login/");
        WebElement registerLink = driver.findElement(By.linkText("here"));
        registerLink.click();
        // Prvi klik na links "here" otvara popup i dodaje #google_vignette na kraj URL-a
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://practice.expandtesting.com/login/#google_vignette"));
        // Kliknuo sam na back da bih ugasio popup i ponovo kliknuo na link "here" i ovog puta ne otvara popup
        // tako da mogu da nastavim dalje bez ometanja.
        driver.navigate().back();
        registerLink.click();
        wait.until(ExpectedConditions.urlToBe("https://practice.expandtesting.com/register"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://practice.expandtesting.com/register");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmField = driver.findElement(By.id("confirmPassword"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});", submitButton);

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        confirmField.clear();
        confirmField.sendKeys(password);
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        WebElement successfullyRegistered = driver.findElement(By.id("flash"));
        Assert.assertEquals(successfullyRegistered.getText(), "Successfully registered, you can log in now.");
    }

    @Test(priority=2)
    public void logIn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://practice.expandtesting.com/login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitLogin = driver.findElement(By.id("submit-login"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});", submitLogin);
        wait.until(ExpectedConditions.visibilityOf(submitLogin));


        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitLogin.click();


        wait.until(ExpectedConditions.urlToBe("https://practice.expandtesting.com/secure"));
        WebElement successMessage = driver.findElement(By.id("flash"));
        Assert.assertEquals(successMessage.getText(), "You logged into a secure area!");
        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "Hi, "+username.toLowerCase()+"!");
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){

    }

}
