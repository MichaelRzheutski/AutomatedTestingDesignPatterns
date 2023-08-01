package fluentInterfacePattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static fluentInterfacePattern.LocatorHelper.getLocator;

public class LoginPage extends PageBase {
    protected final String CORRECT_EMAIL = "michael.test@gmail.com";
    protected final String CORRECT_PASSWORD = "30203050";

    protected final String INCORRECT_EMAIL = "test@mail.com";
    protected final String INCORRECT_PASSWORD = "sdf325fhg";

    public final String EXPECTED_SUCCESS_MESSAGE = "You are now logged in as Michał Ržavucki.";
    public final String EXPECTED_ERROR_MESSAGE = "Wrong password or the account is disabled, or does not exist";

    public final String EXPECTED_ORDER_HISTORY_TITLE = "Order History";
    public final String EXPECTED_CUSTOMER_SERVICE_TITLE = "Contact Us";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage attemptValidCredentials() throws Exception {
        driver.findElement(
                getLocator("FluentInterface.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(
                getLocator("FluentInterface.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("FluentInterface.LOGIN_BUTTON")).click();

        return this;
    }

    public LoginPage attemptInvalidCredentials() throws Exception {
        driver.findElement(
                getLocator("FluentInterface.EMAIL_FIELD")).sendKeys(INCORRECT_EMAIL);
        driver.findElement(
                getLocator("FluentInterface.PASSWORD_FIELD")).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(getLocator("FluentInterface.LOGIN_BUTTON")).click();

        return this;
    }

    public LoginPage rememberMe() throws Exception {
        driver.findElement(
                getLocator("FluentInterface.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(
                getLocator("FluentInterface.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("FluentInterface.REMEMBER_ME_CHECKBOX")).click();
        driver.findElement(getLocator("FluentInterface.LOGIN_BUTTON")).click();

        return this;
    }

    public LoginPage clickOrderHistoryLink() throws Exception {
        driver.findElement(
                getLocator("FluentInterface.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(
                getLocator("FluentInterface.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("FluentInterface.LOGIN_BUTTON")).click();
        driver.findElement(getLocator("FluentInterface.ORDER_HISTORY_LINK")).click();

        return this;
    }

    public LoginPage clickCustomerServiceLink() throws Exception {
        driver.findElement(
                getLocator("FluentInterface.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(
                getLocator("FluentInterface.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("FluentInterface.LOGIN_BUTTON")).click();
        driver.findElement(getLocator("FluentInterface.CUSTOMER_SERVICE_LINK")).click();

        return this;
    }

    public LoginPage checkErrorMessage() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("FluentInterface.ERROR_MESSAGE"))
        );
        System.out.println(driver.findElement(
                getLocator("FluentInterface.ERROR_MESSAGE")).getText()
        );

        return this;
    }
    public LoginPage checkSuccessMessage() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("FluentInterface.SUCCESS_MESSAGE")
        ));
        System.out.println(driver.findElement(
                getLocator("FluentInterface.SUCCESS_MESSAGE")).getText());

        return this;
    }

    public LoginPage checkOrderHistoryTitle() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("FluentInterface.ORDER_HISTORY_TITLE")
        ));
        System.out.println(driver.findElement(
                getLocator("FluentInterface.ORDER_HISTORY_TITLE")).getText());

        return this;
    }

    public LoginPage checkCustomerServiceTitle() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("FluentInterface.CUSTOMER_SERVICE_TITLE")
        ));
        System.out.println(driver.findElement(
                getLocator("FluentInterface.CUSTOMER_SERVICE_TITLE")).getText());

        return this;
    }
}
