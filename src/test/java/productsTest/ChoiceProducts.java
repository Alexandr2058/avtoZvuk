package productsTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class ChoiceProducts extends ParentTest {
    @Test
    public void choiceProducts() {
        homePage.goToProductPage();
        homePage.clickOnMenuCatalog();
        homePage.clickOnSubMenuCatalog("Электроника");
        homePage.clickOnSSMenuCatalog();
    }
}
