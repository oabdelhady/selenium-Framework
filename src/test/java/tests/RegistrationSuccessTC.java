package tests;

import data.ReadGuru99ExcelFile;
import data.RegistrationTestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.RegistrationPage;

import java.io.IOException;
import java.util.Random;

public class RegistrationSuccessTC extends BaseTest {
    @Test (dataProvider = "registrationSuccessTestData")
    public void registerValidData(String firstName, String lastName , String addressFirst, String addressLast, String City) {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickOnSigninBtn();
        LoginPage loginpage = new LoginPage(driver, wait);
        Random rand = new Random();
        int n = rand.nextInt(100000);
        loginpage.setRegisterEmail(n + "999@test.com");
        loginpage.clickOnCreateAccountBtn();
        RegistrationPage register = new RegistrationPage(driver, wait);
        register.setFirstName(firstName);
        register.setLastName(lastName);
        register.setPassword("12345");
        register.setAddressFirstName(addressFirst);
        register.setAddressLastName(addressLast);
        register.setAddress("Degla Plaza");
        register.setCity(City);
        register.setZipCode("11223");
        register.setCountry("United States");
        register.setState("California");
        register.setMobileNo("01009898989");
        register.clickOnRegisterBtn();
        MyAccount myaccount = new MyAccount(driver, wait);
        Assert.assertEquals(myaccount.getSuccessText(), "Welcome to your account. Here you can manage all of your personal information and orders.");

    }
    @DataProvider(name = "registrationSuccessTestData")
    public Object [][] getRegistrationSuccessTestData () throws IOException {
        RegistrationTestData object1 = new RegistrationTestData();

        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data";
        return object1.readRegistrationDataExcel(filePath,"TestData.xlsx","registration");

    }
}
