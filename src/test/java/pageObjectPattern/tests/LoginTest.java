package pageObjectPattern.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pageObjectPattern.LocatorHelper.getLocator;

public class LoginTest extends TestBase {

    @Test
    public void attemptValidCredentialsTest() throws Exception {
        loginPage.attemptValidCredentials();
        loginPage.checkSuccessMessage();
        Assert.assertEquals(
                driver.findElement(getLocator("PageObject.SUCCESS_MESSAGE")).getText(),
                loginPage.EXPECTED_SUCCESS_MESSAGE
        );
    }

    @Test
    public void attemptInvalidCredentialsTest() throws Exception {
        loginPage.attemptInvalidCredentials();
        loginPage.checkErrorMessage();
        Assert.assertEquals(
                driver.findElement(getLocator("PageObject.ERROR_MESSAGE")).getText(),
                loginPage.EXPECTED_ERROR_MESSAGE
        );
    }

    @Test
    public void rememberMeTest() throws Exception {
        loginPage.rememberMe();
        loginPage.checkSuccessMessage();
        Assert.assertEquals(
                driver.findElement(getLocator("PageObject.SUCCESS_MESSAGE")).getText(),
                loginPage.EXPECTED_SUCCESS_MESSAGE
        );
    }

    @Test
    public void orderHistoryLinkTest() throws Exception {
        loginPage.clickOrderHistoryLink();
        loginPage.checkOrderHistoryTitle();
        Assert.assertEquals(
                driver.findElement(getLocator("PageObject.ORDER_HISTORY_TITLE")).getText(),
                loginPage.EXPECTED_ORDER_HISTORY_TITLE
        );
    }

    @Test
    public void customerServiceLinkTest() throws Exception {
        loginPage.clickCustomerServiceLink();
        loginPage.checkCustomerServiceTitle();
        Assert.assertEquals(
                driver.findElement(getLocator("PageObject.CUSTOMER_SERVICE_TITLE")).getText(),
                loginPage.EXPECTED_CUSTOMER_SERVICE_TITLE
        );
    }
}
