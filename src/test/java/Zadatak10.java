import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak10 {

    WebDriver driver;
    String userFirstName = "Ime";
    String userLastName = "Prezime";
    String userEmailAddress = "test@test.com";
    String userSalary = "4000";
    String userAge = "40";
    String userDepartment = "Department2";

    @BeforeClass
    public void setUp(){
        //WebDriverManager.chromedriver().driverVersion().setup();
    }
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");
    }
    @Test
    public void addToWebTable(){
        WebElement elementsLink = driver.findElement(By.cssSelector("a[href='/elements']"));
        elementsLink.click();
        WebElement webTablesLink = driver.findElement(By.cssSelector("a[href='/webtables']"));
        webTablesLink.click();
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.clear();
        firstName.sendKeys(userFirstName);
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.clear();
        lastName.sendKeys(userLastName);
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.clear();
        userEmail.sendKeys(userEmailAddress);
        WebElement age = driver.findElement(By.id("age"));
        age.clear();
        age.sendKeys(userAge);
        WebElement salary = driver.findElement(By.id("salary"));
        salary.clear();
        salary.sendKeys(userSalary);
        WebElement department = driver.findElement(By.id("department"));
        department.clear();
        department.sendKeys(userDepartment);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement tableContent = driver.findElement(By.cssSelector(".-striped.-highlight.table.table-striped.table-bordered.table-hover"));
        System.out.println(tableContent.getText());

        String userCompleteText = userFirstName+" "+userLastName+" "+userAge+" "+userEmailAddress+" "+userSalary+" "+userDepartment;
        Assert.assertTrue(tableContent.getText().contains(userCompleteText));

    }
    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
