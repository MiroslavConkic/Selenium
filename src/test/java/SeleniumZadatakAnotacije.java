import org.testng.annotations.*;

public class SeleniumZadatakAnotacije {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Dobrodosli na kurs");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Ucim za test");
    }

    @Test(priority = 1)
    public void prviTest(){
        System.out.println("SQL");
    }

    @Test(priority = 2)
    public void drugiTest(){
        System.out.println("Java");
    }

    @Test(priority = 3)
    public void treciTest(){
        System.out.println("Selenium");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Polozen test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Polozen kurs");
    }
}