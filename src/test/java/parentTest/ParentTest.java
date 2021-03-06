package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FavoritesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ParktronikSystem;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected FavoritesPage favoritesPage;
    protected ParktronikSystem parktronikSystem;


    @Before
    public void setUp() {
        File file = new File ("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        favoritesPage = new FavoritesPage(webDriver);
        parktronikSystem = new ParktronikSystem(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkExpectedResult (String message, boolean actualResult) {
        Assert.assertEquals(message, actualResult, true);
    }
}
