package tests;

import data.ReadGuru99ExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;

import java.io.IOException;

public class LoginSuccessTC extends BaseTest {
    @Test (dataProvider = "successLoginTestData")
    public void validCredentials(String email, String password) {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickOnSigninBtn();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setLoginEmail(email);
        loginPage.setPassword(password);
        loginPage.ClickOnLoginBtn();
        MyAccount myaccount = new MyAccount(driver, wait);
        Assert.assertEquals(myaccount.getSuccessText(), "Welcome to your account. Here you can manage all of your personal information and orders.");

    }
    @DataProvider (name = "successLoginTestData")
    public Object [][] getSuccessLoginTestData () throws IOException {
        ReadGuru99ExcelFile object1 = new ReadGuru99ExcelFile();

        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data";
       return object1.readExcel(filePath,"TestData.xlsx","Sheet1");

    }


}
