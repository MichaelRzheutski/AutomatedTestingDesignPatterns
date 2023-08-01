package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pageObjectPattern.LocatorHelper.getLocator;

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

    public void attemptValidCredentials() throws Exception {
        driver.findElement(getLocator("PageObject.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(getLocator("PageObject.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("PageObject.LOGIN_BUTTON")).click();
    }

    public void attemptInvalidCredentials() throws Exception {
        driver.findElement(getLocator("PageObject.EMAIL_FIELD")).sendKeys(INCORRECT_EMAIL);
        driver.findElement(getLocator("PageObject.PASSWORD_FIELD")).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(getLocator("PageObject.LOGIN_BUTTON")).click();
    }

    public void rememberMe() throws Exception {
        driver.findElement(getLocator("PageObject.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(getLocator("PageObject.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("PageObject.REMEMBER_ME_CHECKBOX")).click();
        driver.findElement(getLocator("PageObject.LOGIN_BUTTON")).click();
    }

    public void clickOrderHistoryLink() throws Exception {
        driver.findElement(getLocator("PageObject.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(getLocator("PageObject.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("PageObject.LOGIN_BUTTON")).click();
        driver.findElement(getLocator("PageObject.ORDER_HISTORY_LINK")).click();
    }

    public void clickCustomerServiceLink() throws Exception {
        driver.findElement(getLocator("PageObject.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(getLocator("PageObject.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("PageObject.LOGIN_BUTTON")).click();
        driver.findElement(getLocator("PageObject.CUSTOMER_SERVICE_LINK")).click();
    }

    public void checkErrorMessage() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("PageObject.ERROR_MESSAGE")));
        System.out.println(driver.findElement(getLocator("PageObject.ERROR_MESSAGE")).getText());
    }
    public void checkSuccessMessage() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("PageObject.SUCCESS_MESSAGE")));
        System.out.println(driver.findElement(getLocator("PageObject.SUCCESS_MESSAGE")).getText());
    }

    public void checkOrderHistoryTitle() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("PageObject.ORDER_HISTORY_TITLE")));
        System.out.println(driver.findElement(getLocator("PageObject.ORDER_HISTORY_TITLE")).getText());
    }

    public void checkCustomerServiceTitle() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("PageObject.CUSTOMER_SERVICE_TITLE")));
        System.out.println(driver.findElement(getLocator("PageObject.CUSTOMER_SERVICE_TITLE")).getText());
    }
}
