package productsTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;

public class ChoiceProducts extends ParentTest {
    @Test
    public void choiceProducts() {
        homePage.goToProductPage();
        homePage.bringToElements();
        homePage.bringToSubElements();
        homePage.clickOnSubMenuCatalog();
        homePage.chooseSystem();
        homePage.chooseClickSystem();
        parktronikSystem.findSystem();
        parktronikSystem.chooseSystem();
    }

    @Test
    public void checkFiltr () throws InterruptedException {
        loginPage.openPage();
        homePage.bringToElements();
        homePage.bringToSubElements();
        homePage.clickOnSubMenuCatalog();
        homePage.chooseSystem();
        homePage.chooseClickSystem();
        parktronikSystem.enterPrace();
    }
}
