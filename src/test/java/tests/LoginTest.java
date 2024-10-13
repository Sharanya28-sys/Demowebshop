package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.clicklogin();
        lp.enterLoginDetails("demouser2004@gmail.com", "Demo@123");
        Assert.assertEquals(lp.successsMsg(), "demouser2004@gmail.com");
    }

    @Test(priority = 2)
    public void inValidLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.clicklogin();
        lp.enterLoginDetails("invaliduser2001@gmail.com", "Demo@123");
        Assert.assertEquals(lp.errorMsg(), "Login was unsuccessful. Please correct the errors and try again.");
    }
}
