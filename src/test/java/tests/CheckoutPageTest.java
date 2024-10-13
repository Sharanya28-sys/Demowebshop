package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;

import java.util.Set;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void placeOrder() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.clicklogin();
        lp.enterLoginDetails("demouser2004@gmail.com", "Demo@123");
        Assert.assertEquals(lp.successsMsg(), "demouser2004@gmail.com");
        CheckoutPage cp = new CheckoutPage(driver);
        Set<String> productsInShop = cp.addProductsToCart();
        cp.clickShoppingCart();
        Set<String> productsInCart = cp.getProductsInCart();
        boolean productsValidate = productsInShop.equals(productsInCart);
        Assert.assertTrue(productsValidate);

        cp.clickCheckout();
        cp.checkoutOrder("Bangalore", "Bangalore", "583483", "9807638278");
        Assert.assertEquals(cp.getPlacedOrderMsg(), "Your order has been successfully processed!");
    }
}
