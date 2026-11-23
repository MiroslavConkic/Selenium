import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2_Vezba {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");


        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.danas.rs");

        driver.switchTo().window(listaTabova.get(4));
        driver.navigate().to("https://www.facebook.com");

        driver.switchTo().window(listaTabova.get(5));
        driver.navigate().to("https://www.github.com");

        driver.close();

        for(int i= 1; i< listaTabova.size(); i++){
            driver.switchTo().window(listaTabova.get(i));
            driver.close();
        }

    }
}
//Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google