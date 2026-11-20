import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Selenium7Annotations {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().driverVersion("156.0.8078.79").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        //Setting prerequisites
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        // Checking if cart is empty
        WebElement navCartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(navCartCount.getText(), "0");
        // Going to cart page to see if cart is actually empty
        navCartCount.click();
        WebElement emptyCartPage = driver.findElement(By.className("sc-your-amazon-cart-is-empty"));
        Assert.assertEquals(emptyCartPage.getText(), "Your Amazon Cart is empty");
        // Go back to product page
        driver.navigate().back();
    }

    @Test
    public void addToCart(){
        // Adding product name to variable for later Assertation
        WebElement item = driver.findElement(By.id("productTitle"));
        String expectedItemName = item.getText();
        // Adding item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        // Assertation
        WebElement successMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertEquals(successMessage.getText(), "Added to cart");
        WebElement navCartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(navCartCount.getText(), "1");
        navCartCount.click();
        // Checking cart page to see if item name is correct
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
        WebElement productName = driver.findElement(By.cssSelector(".a-truncate.sc-grid-item-product-title.a-size-base-plus"));
        Assert.assertEquals(productName.getText(), expectedItemName);
    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}