package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends ParentPage{

    @FindBy (xpath = ".//*/h1[text()='Контакты'] ")
    private WebElement contact;

    public FavoritesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isContactPresent() {
        return actionsWithOurElements.isElementPresent(contact);
    }
}
