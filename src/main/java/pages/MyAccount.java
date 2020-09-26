package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount {
    WebDriver driver;
    WebDriverWait wait;

    public MyAccount(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getSuccessText() {
        return driver.findElement(By.xpath("//p[@class='info-account']")).getText();
    }
}

