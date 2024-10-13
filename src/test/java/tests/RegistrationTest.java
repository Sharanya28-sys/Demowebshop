package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(priority = 1)
    public void validRegistration() {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.clickRegister();
        rp.enterRegistrationDetails("male", "Demo", "User", "demouser2004@gmail.com", "Demo@123", "Demo@123");
        Assert.assertEquals(rp.successsMsg(), "Your registration completed");
    }

    @Test(priority = 2)
    public void inValidRegistration() {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.clickRegister();
        rp.enterRegistrationDetails("male", "Demo", "User", "", "Demo@123", "Demo@123");
        Assert.assertEquals(rp.errorMsg(), "Email is required.");
    }
}
