package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//*[@class='main-menu__catalog']" )
    private WebElement menuCatalog;

    @FindBy (xpath = ".//*[@href='/avtoelektronika/c10']" )
    private WebElement avtoelEktronika;

    @FindBy (xpath = ".//*[@href='/parkovochnye-sistemy/c162']")
    private WebElement parkovochnye;

    @FindBy(xpath = ".//*/a[text()='Парковочные системы']")// .//*/a[text()='Парктроники']  .//*[@href='/parktroniki/c15']
    private WebElement parktroniki;

    @FindBy (xpath = ".//ul[@data-id='162']//a[@href='/parktroniki/c15']")
    private WebElement parktroniki1;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = ".//*[@href='/useraccount']")
    private WebElement avatar;

    public boolean isAvatarPresent() {
       return actionsWithOurElements.isElementPresent(avatar);
   }

    public void goToProductPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("chepik2058@gmail.com", "909090");
        Assert.assertEquals("Avatar is not present", true, isAvatarPresent());
    }

//    public void clickOnMenuCatalog() {
//        actionsWithOurElements.clickOnElement(menuCatalog);
//    }

    public void clickOnSubMenuCatalog() {
        actionsWithOurElements.moveToElements(parkovochnye);
    }

    public void bringToElements() {
        actionsWithOurElements.moveToElements(menuCatalog);
    }

    public void bringToSubElements() {
        actionsWithOurElements.moveToElements(avtoelEktronika);
    }

    public void chooseSystem() {
        actionsWithOurElements.moveToElements(parktroniki);
    }

    public void chooseClickSystem() {
        actionsWithOurElements.clickOnElement(parktroniki1);
    }
}
