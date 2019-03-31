package avtoZvuk.login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObjeect extends ParentTest {
    @Test
    public void validLogin () {
        loginPage.openPage();
        loginPage.clickOnButtonAuth();
        loginPage.enterTextInToInputLogin("chepik2058@gmail.com");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();
//        loginPage.clickOnButtonOut();

        checkExpectedResult("Avatar is not present", homePage.isAvatarPresent());

    }

    @Test
    public void invalidLogin() {
        loginPage.login("opa", "909090");
        checkExpectedResult("Login should hot be present", !homePage.isAvatarPresent() );
    }

    @Test
    public void contactPage() {
        loginPage.login("chepik2058@gmail.com", "909090");
        loginPage.clickOnElementContact();
        checkExpectedResult("Contact is present", favoritesPage.isContactPresent());
    }
}
