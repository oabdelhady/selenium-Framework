package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.Password;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void setFirstName(String FirstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys(FirstName);
    }

    public void setLastName(String LastName) {
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys(LastName);
    }

    public void setPassword(String psswrd) {
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(psswrd);
    }

    public void setAddressFirstName(String addressFirst) {
        WebElement addressFirstName = driver.findElement(By.id("firstname"));
        addressFirstName.sendKeys(addressFirst);
    }

    public void setAddressLastName(String addressLast) {
        WebElement addressLastName = driver.findElement(By.id("lastname"));
        addressLastName.sendKeys(addressLast);
    }

    public void setAddress(String addressValue) {
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys(addressValue);
    }

    public void setCity(String cityValue) {
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(cityValue);
    }

    public void setZipCode(String zipCodeValue) {
        WebElement zipCode = driver.findElement(By.id("postcode"));
        zipCode.sendKeys(zipCodeValue);
    }

    public void setCountry(String countryValue) {
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByVisibleText(countryValue);
    }

    public void setState(String stateValue) {
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText(stateValue);
    }

    public void setMobileNo(String MobileNumber) {
        WebElement mobileNo = driver.findElement(By.id("phone_mobile"));
        mobileNo.sendKeys(MobileNumber);
    }

    public void clickOnRegisterBtn() {
        WebElement registerbtn = driver.findElement(By.id("submitAccount"));
        registerbtn.click();
    }

    public String getSuccessText() {
        return driver.findElement(By.xpath("//p[@class='info-account']")).getText();
    }

    public String getErrorMsg() {
        return driver.findElement(By.id("create_account_error")).getText();
    }

}


