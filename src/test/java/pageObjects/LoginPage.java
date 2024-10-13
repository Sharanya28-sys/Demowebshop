package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final By loginLink = By.className("ico-login");
    private final By enterEmail = By.id("Email");
    private final By enterPassword = By.id("Password");
    private final By loginBtn = By.xpath("//input[normalize-space(@value)='Log in']");
    private final By successsMsg = By.xpath("//div[@class='header-links']//li//a[@class='account']");
    private final By errorMsg = By.xpath("//div[@class='message-error']//span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicklogin() {
        driver.findElement(loginLink).click();
    }

    public void enterLoginDetails(String email, String password) {
        driver.findElement(enterEmail).sendKeys(email);
        driver.findElement(enterPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String successsMsg() {
        String msg = driver.findElement(successsMsg).getText();
        return msg;
    }

    public String errorMsg() {
        String msg = driver.findElement(errorMsg).getText();
        return msg;
    }
}
