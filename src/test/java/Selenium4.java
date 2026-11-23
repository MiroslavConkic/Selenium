import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class Selenium4 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 3
//Otvoriti bing pretrazivac, pretrazite 'Wikipedia'
//otvorite wikipedia stranicu i na njoj uradite pretragu 'Nikola Tesla'

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");

        WebElement searchBoxBing = driver.findElement(By.id("sb_form_q"));
        searchBoxBing.clear();
        searchBoxBing.sendKeys("Wikipedia -ai");

        Thread.sleep(3000);

        WebElement searchButtonBing = driver.findElement(By.id("sb_hp_go"));
        searchButtonBing.click();

        Thread.sleep(3000);

        WebElement wikipediaLink = driver.findElement(By.linkText("Wikipedia"));
        wikipediaLink.click();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        WebElement searchBoxWikipedia = driver.findElement(By.id("searchInput"));
        searchBoxWikipedia.clear();
        searchBoxWikipedia.sendKeys("Nikola Tesla");

        //WebElement searchButtonWikipedia = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        WebElement searchButtonWikipedia = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButtonWikipedia.click();

        //------------------

        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        Assert.assertEquals(actualURL, expectedURL);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Nikola Tesla - Wikipedia";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement pageHeading = driver.findElement(By.id("firstHeading"));
        String actualHeading = pageHeading.getText();
        String expectedHeading = "Nikola Tesla";
        Assert.assertEquals(actualHeading, expectedHeading);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImage.isDisplayed());

        WebElement imageAlt = pageImage.findElement(By.tagName("img"));
        String expectedAltText = "Head-and-shoulder photograph of a slender man with dark hair and moustache, dark suit and white-collar shirt";
        String actualAltText = imageAlt.getAttribute("alt");
        Assert.assertEquals(actualAltText, expectedAltText);
        //driver.quit();

    }
}