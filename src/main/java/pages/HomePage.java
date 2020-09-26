package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickOnSigninBtn() {
        WebElement signinbtn = driver.findElement(By.xpath("//a[@class='login']"));
        wait.until(ExpectedConditions.visibilityOf(signinbtn));
        signinbtn.click();
    }
}
