import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public static void main(String[] args) {
        // Sleepers - ceka odredjen broj milisekundi
        // Cekanje je fiksno i moze se koristiti tokom kreiranja testova
        // ne preporucuje se u praksi da se nalazi ova vrsta cekanja u testovima

        //Implicit wait - proverava na svakih 500ms da li postoji element
        // proverava onoliko dugo sekundi koliko mu zadamo
        // Definisemo ga samo jednom u kodu (na pocetku idealno)

        // Explicit wait - ceka zadato vreme dok se ne ispuni uslov

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu-item-20"))));
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        wait.until(ExpectedConditions.elementToBeClickable(testLoginPageButton));

        testLoginPageButton.click();

        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/practice-test-login"));




    }
}
