package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "_username" )
    private WebElement inputEmail;

    @FindBy (name = "_password")
    private WebElement inputPass;

    @FindBy (xpath = ".// *[@class='top-auth__login']")
    private WebElement buttonAuth;

    @FindBy (xpath = ".// *[@class='active-form__input active-form__input_submit']")
    private  WebElement buttonSubmit;


    public void openPage() {
        try {
            webDriver.get("https://avtozvuk.ua/");
            logger.info("Page was open");
        } catch (Exception e) {
            logger.error("Can not open page" + e);
            Assert.fail("Can not open page" + e);
        }
    }

    public void clickOnButtonAuth() {
        actionsWithOurElements.clickOnElement(buttonAuth);
//        try {
//
//            webDriver.findElement (By.xpath(".// *[@class='top-auth__login']")).click();
//            System.out.println("Button submit was clicked");
//        }catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }

    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputEmail,login);
    }

    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }

    public void clickOnButtonSubmit() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
//        try {
//            webDriver.findElement (By.xpath(".// *[@class='active-form__input active-form__input_submit']")).click();
//            System.out.println("Button submit was clicked");
//        }catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }
}
