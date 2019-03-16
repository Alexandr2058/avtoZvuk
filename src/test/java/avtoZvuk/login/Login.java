package avtoZvuk.login;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test
            public void validLogin() {
        File file = new File ("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://avtozvuk.ua/");

        System.out.println("Site was open");

        webDriver.findElement(By.xpath(".// *[@class='top-auth__login']")).click();
        webDriver.findElement(By.name("_username")).sendKeys("chepik2058@gmail.com");
        webDriver.findElement(By.name("_password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".// *[@class='active-form__input active-form__input_submit']")).click();

   //     webDriver.quit();
    }
}
