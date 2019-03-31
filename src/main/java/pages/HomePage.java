package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//*[@href='javascript:void(0)']" )
    private WebElement menuCatalog;

    @FindBy (xpath = ".//*[@href='/avtoelektronika/c10']" )
    private WebElement avtoelEktronika;

    @FindBy (xpath = ".//*[@href='/parkovochnye-sistemy/c162']")
    private WebElement parkovochnyeSistemy;

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

    public void clickOnMenuCatalog() {
        actionsWithOurElements.clickOnElement(menuCatalog);
    }

    public void clickOnSubMenuCatalog(String elektronika) {
        actionsWithOurElements.selectValueinDD(avtoelEktronika, elektronika);
    }

    public void clickOnSSMenuCatalog() {
        actionsWithOurElements.clickOnElement(parkovochnyeSistemy);
    }
}
