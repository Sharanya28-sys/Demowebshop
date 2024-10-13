package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    private final By maleGender = By.id("gender-male");
    private final By femaleGender = By.id("gender-female");
    private final By registerLink = By.className("ico-register");
    private final By enterFirstName = By.id("FirstName");
    private final By enterLastName = By.id("LastName");
    private final By enterEmail = By.id("Email");
    private final By enterPassword = By.id("Password");
    private final By enterConfirmPassword = By.id("ConfirmPassword");
    private final By clickRegister = By.id("register-button");
    private final By successsMsg = By.xpath("//div[normalize-space(text())='Your registration completed']");
    private final By errorMsg = By.xpath("//span[text()='Email is required.']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void enterRegistrationDetails(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleGender).click();
        } else {
            driver.findElement(femaleGender).click();
        }
        driver.findElement(enterFirstName).sendKeys(firstName);
        driver.findElement(enterLastName).sendKeys(lastName);
        driver.findElement(enterEmail).sendKeys(email);
        driver.findElement(enterPassword).sendKeys(password);
        driver.findElement(enterConfirmPassword).sendKeys(confirmPassword);
        driver.findElement(clickRegister).click();
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
