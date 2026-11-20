import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().driverVersion("156.0.8078.79").setup();
        WebDriver driver = new ChromeDriver();



    }
}

////Zadatak 1
////Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
////vratite se nazad i odstampajte poslednji URL na kom se nalazite
////na kraju zatvorite driver