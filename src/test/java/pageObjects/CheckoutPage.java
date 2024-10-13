package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckoutPage {

    private final WebDriver driver;

    private final By categories = By.linkText("Apparel & Shoes");
    private final By addToCart1 = By.xpath("//div[@class='product-item']//h2/a//parent::h2//parent::div//child::input");
    private final By addToCart2 = By.xpath("(//input[@value='Add to cart'])[1]");
    private final By productName = By.xpath("//input[@value='Add to cart']//parent::div[@class='buttons']//parent::div[@class='add-info']//preceding-sibling::h2//child::a");
    private final By shoppingCart = By.xpath("//span[text()='Shopping cart']");
    private final By addedProductsInCart = By.className("product-name");
    private final By consentCheckbox = By.id("termsofservice");
    private final By checkoutBtn = By.id("checkout");
    private final By countryDrpdown = By.id("BillingNewAddress_CountryId");
    private final By cityFld = By.id("BillingNewAddress_City");
    private final By address1Fld = By.id("BillingNewAddress_Address1");
    private final By zipCodeFld = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberFld = By.id("BillingNewAddress_PhoneNumber");
    private final By billingContinueBtn = By.cssSelector("input[onclick='Billing.save()']");
    private final By shippingAddressContinueBtn = By.cssSelector("input[onclick='Shipping.save()']");
    private final By shippingMethodContinueBtn = By.cssSelector("input[class='button-1 shipping-method-next-step-button']");
    private final By paymentMethodContinueBtn = By.cssSelector("input[class='button-1 payment-method-next-step-button']");
    private final By paymentInfoContinueBtn = By.cssSelector("input[class='button-1 payment-info-next-step-button']");
    private final By confirmBtn = By.cssSelector("input[value='Confirm']");
    private final By orderPlacedMsg = By.cssSelector("div[class='title'] strong");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public Set<String> addProductsToCart() throws InterruptedException {
        driver.findElement(categories).click();
        List<WebElement> products = driver.findElements(addToCart1);
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < products.size() / 2; i++) {
            set.add(driver.findElements(productName).get(i).getText());
            products.get(i).click();
            Thread.sleep(5000);
            driver.findElement(addToCart2).click();
            Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(5000);
        }
        return set;
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    public Set<String> getProductsInCart() {
        Set<String> set = new HashSet<>();
        List<WebElement> productsInCart = driver.findElements(addedProductsInCart);
        for (int i = 0; i < productsInCart.size(); i++) {
            set.add(productsInCart.get(i).getText());
        }
        return set;
    }

    public void clickCheckout() {
        driver.findElement(consentCheckbox).click();
        driver.findElement(checkoutBtn).click();
    }

    public void checkoutOrder(String city, String address1, String zipCode, String phoneNumber) {
        Select s = new Select(driver.findElement(countryDrpdown));
        s.selectByVisibleText("India");
        driver.findElement(cityFld).sendKeys(city);
        driver.findElement(address1Fld).sendKeys(address1);
        driver.findElement(zipCodeFld).sendKeys(zipCode);
        driver.findElement(phoneNumberFld).sendKeys(phoneNumber);
        driver.findElement(billingContinueBtn).click();
        driver.findElement(shippingAddressContinueBtn).click();
        driver.findElement(shippingMethodContinueBtn).click();
        driver.findElement(paymentMethodContinueBtn).click();
        driver.findElement(paymentInfoContinueBtn).click();
        driver.findElement(confirmBtn).click();
    }

    public String getPlacedOrderMsg() {
        String msg = driver.findElement(orderPlacedMsg).getText();
        return msg;
    }

}
