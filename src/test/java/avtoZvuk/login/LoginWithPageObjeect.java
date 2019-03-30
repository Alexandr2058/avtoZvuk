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

        checkExpectedResult("Avatar is not present", homePage.isAvatarPresent());

    }
}
