import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vezbanje {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().driverVersion("156.0.8078.79").setup();
        WebDriver driver = new ChromeDriver();


        driver.navigate().to("https://www.linkedin.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.joberty.com");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
