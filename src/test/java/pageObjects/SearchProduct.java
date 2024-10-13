package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PrivateKey;

public class SearchProduct {
    private final WebDriver driver;

    private final By searchProduct = By.xpath("//div[@class='search-box']//input[@id='small-searchterms']");
    private final By clickSearch = By.xpath("//div[@class='search-box']//input[@Value='Search']");
    private final By verifyProduct = By.xpath("//h2[@class='product-title']/child::a");

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
    }

    public void enterProductName(String productName) {
        driver.findElement(searchProduct).sendKeys(productName);
        driver.findElement((clickSearch)).click();
    }

    public String validateProduct() {
        String productName = driver.findElement(verifyProduct).getText();
        return productName;
    }
}
