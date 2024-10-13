package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchProduct;

public class SearchProductTest extends BaseTest {

    @Test
    public void serachProduct() {
        SearchProduct sp = new SearchProduct(driver);
        sp.enterProductName("Desktop PC with CDRW");
        Assert.assertEquals(sp.validateProduct(), "Desktop PC with CDRW");
    }

}
