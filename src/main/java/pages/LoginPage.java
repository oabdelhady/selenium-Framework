package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void setLoginEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement enterEmail = driver.findElement(By.id("email"));
        enterEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement enterPassw0rd = driver.findElement(By.id("passwd"));
        wait.until(ExpectedConditions.visibilityOf(enterPassw0rd));
        enterPassw0rd.sendKeys(password);
    }

    public void ClickOnLoginBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("//i[@class='icon-lock left']"));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }

    public String getLoginErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-danger']")));
        return driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText();
    }

    public String getCreateAccountErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));
        return driver.findElement(By.id("create_account_error")).getText();
    }

    public void setRegisterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        WebElement createEmail = driver.findElement(By.id("email_create"));
        createEmail.sendKeys(email);
    }

    public void clickOnCreateAccountBtn() {
        WebElement createAccountBtn = driver.findElement(By.xpath("//i[@class='icon-user left']"));
        createAccountBtn.click();
    }
}
