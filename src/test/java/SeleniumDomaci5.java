import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class SeleniumDomaci5 {

    WebDriver driver;
    String[] user = {"Petar Petrovic", "petrovic@test.com", "Somborski put 14", "Sencanski put 14/a"};

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
    }

    @BeforeMethod
    public void pageSetUp(){

    }

    @Test
    public void formSubmitTest(){
        WebElement fullNameField = driver.findElement(By.id("userName"));
        WebElement emailField = driver.findElement(By.id("userEmail"));
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        fullNameField.clear();
        fullNameField.sendKeys(user[0]);
        emailField.clear();
        emailField.sendKeys(user[1]);
        currentAddressField.clear();
        currentAddressField.sendKeys(user[2]);
        permanentAddressField.clear();
        permanentAddressField.sendKeys(user[3]);
        submitButton.click();

        WebElement resultingTable = driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));
        List<WebElement> resultingCells = resultingTable.findElements(By.tagName("p"));

        for(int i=0; i<resultingCells.size(); i++){
            Assert.assertTrue(resultingCells.get(i).getText().contains(user[i]));
        }
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @AfterClass
    public void afterClass(){

    }
}
