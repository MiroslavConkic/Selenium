import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Selenium7Anotations {

    WebDriver driver;
        

    @BeforeClass
    public void beforeClass(){
    }

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().driverVersion("156.0.8078.79").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebElement navCartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(navCartCount.getText(), "0");

    }

    @Test
    public void test1(){
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass() {

    }
}