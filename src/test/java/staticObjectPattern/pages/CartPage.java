package staticObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static staticObjectPattern.LocatorHelper.getLocator;

public class CartPage {
    protected static final String CORRECT_EMAIL = "michael.test@gmail.com";
    protected static final String CORRECT_PASSWORD = "30203050";

    public static final String ZERO_ITEMS_IN_CART = "0";

    public static final String EXPECTED_ORDER_SUMMARY_HEADER = "Order Summary";

    public static final String EXPECTED_ORDER_STATUS = "Your order is successfully completed!";

    public static final String EXPECTED_REMOVING_SUCCESS_TEXT = "There are no items in your cart.";

    public static void clickYellowDuck(WebDriver driver) throws Exception {
        driver.findElement(getLocator("StaticObject.EMAIL_FIELD")).sendKeys(CORRECT_EMAIL);
        driver.findElement(getLocator("StaticObject.PASSWORD_FIELD")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(getLocator("StaticObject.LOGIN_BUTTON")).click();
        driver.findElement(getLocator("StaticObject.RUBBER_DUCKS_LINK")).click();
        driver.findElement(getLocator("StaticObject.YELLOW_DUCK")).click();
    }

    public static void selectDuckSize(WebDriver driver) {
        WebElement DUCK_SIZE_SELECT = driver.findElement(By.tagName("select"));
        Select select = new Select(DUCK_SIZE_SELECT);
        select.selectByValue("Small");
    }

    public static void addToCartLink(WebDriver driver) throws Exception {
        driver.findElement(getLocator("StaticObject.ADD_TO_CART_LINK")).click();
    }

    public static void checkQuantityDucksInCart(WebDriver driver,
                                                WebDriverWait wait) throws Exception {
        wait.until(
                ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(
                        getLocator("StaticObject.QUANTITY_DUCKS_IN_CART"),
                        driver.findElement(getLocator("StaticObject.QUANTITY_DUCKS_IN_CART")).getText()))
        );
    }

    public static void clickCheckoutLink(WebDriver driver) throws Exception {
        driver.findElement(getLocator("StaticObject.CHECKOUT_LINK")).click();
    }

    public static void checkOrderSummaryHeader(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("StaticObject.ORDER_SUMMARY_HEADER"))
        );
    }

    public static void clickConfirmOrderLink(WebDriver driver) throws Exception {
        driver.findElement(getLocator("StaticObject.CONFIRM_ORDER_LINK")).click();
    }

    public static void checkOrderStatus(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("StaticObject.ORDER_STATUS")));
    }

    public static void checkRemoveButton(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("StaticObject.REMOVE_BUTTON")));
    }

    public static void clickRemoveButton(WebDriver driver) throws Exception {
        driver.findElement(getLocator("StaticObject.REMOVE_BUTTON")).click();
    }

    public static void checkRemovingSuccessText(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("StaticObject.REMOVING_SUCCESS_TEXT"))
        );
    }

    public static void checkTotalDucksPrice(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                getLocator("StaticObject.TOTAL_DUCKS_PRICE"))
        );
    }

    public static String getTotalDucksPrice(WebDriver driver) throws Exception {
        return driver.findElement(getLocator("StaticObject.TOTAL_DUCKS_PRICE")).getText();
    }

}
