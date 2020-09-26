package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RegistrationFailureTC extends BaseTest {
    @Test
    public void registerInvalidEmail() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickOnSigninBtn();
        LoginPage loginpage = new LoginPage(driver, wait);
        loginpage.setRegisterEmail("test4@test.com");
        loginpage.clickOnCreateAccountBtn();
        Assert.assertTrue(loginpage.getCreateAccountErrorMsg().contains("An account using this email address has already been registered."));
    }
}
