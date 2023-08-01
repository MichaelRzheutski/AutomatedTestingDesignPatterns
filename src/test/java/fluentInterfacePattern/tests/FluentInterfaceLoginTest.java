package fluentInterfacePattern.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static fluentInterfacePattern.LocatorHelper.getLocator;

public class FluentInterfaceLoginTest extends TestBase {

    @Test
    public void attemptValidCredentialsTest() throws Exception {
        loginPage
                .attemptValidCredentials()
                .checkSuccessMessage();

        Assert.assertEquals(
                driver.findElement(getLocator("FluentInterface.SUCCESS_MESSAGE")).getText(),
                loginPage.EXPECTED_SUCCESS_MESSAGE
        );
    }

    @Test
    public void attemptInvalidCredentialsTest() throws Exception {
        loginPage
                .attemptInvalidCredentials()
                .checkErrorMessage();

        Assert.assertEquals(
                driver.findElement(
                        getLocator("FluentInterface.ERROR_MESSAGE")).getText(),
                loginPage.EXPECTED_ERROR_MESSAGE
        );
    }

    @Test
    public void rememberMeTest() throws Exception {
        loginPage
                .rememberMe()
                .checkSuccessMessage();

        Assert.assertEquals(
                driver.findElement(
                        getLocator("FluentInterface.SUCCESS_MESSAGE")).getText(),
                loginPage.EXPECTED_SUCCESS_MESSAGE
        );
    }

    @Test
    public void orderHistoryLinkTest() throws Exception {
        loginPage
                .clickOrderHistoryLink()
                .checkOrderHistoryTitle();

        Assert.assertEquals(
                driver.findElement(
                        getLocator("FluentInterface.ORDER_HISTORY_TITLE")).getText(),
                loginPage.EXPECTED_ORDER_HISTORY_TITLE
        );
    }

    @Test
    public void customerServiceLinkTest() throws Exception {
        loginPage
                .clickCustomerServiceLink()
                .checkCustomerServiceTitle();

        Assert.assertEquals(
                driver.findElement(
                        getLocator("FluentInterface.CUSTOMER_SERVICE_TITLE")).getText(),
                loginPage.EXPECTED_CUSTOMER_SERVICE_TITLE
        );
    }
}
