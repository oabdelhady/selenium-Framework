package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginFailureTC extends BaseTest {
    @Test
    public void validCredentials() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickOnSigninBtn();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setLoginEmail("vtest@test.com");
        loginPage.setPassword("12345");
        loginPage.ClickOnLoginBtn();
        Assert.assertTrue(loginPage.getLoginErrorMsg().contains("Authentication failed."));

    }
}
