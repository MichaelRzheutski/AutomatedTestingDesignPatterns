package staticObjectPattern.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import staticObjectPattern.pages.CartPage;

import static staticObjectPattern.LocatorHelper.getLocator;

public class CartTest extends TestBase {

    @Test
    public void checkQuantityOfDucksInCartTest() throws Exception {
        CartPage.clickYellowDuck(driver);
        CartPage.selectDuckSize(driver);
        CartPage.addToCartLink(driver);

        CartPage.checkQuantityDucksInCart(driver, wait);

        Assert.assertNotEquals(
                driver.findElement(getLocator("StaticObject.QUANTITY_DUCKS_IN_CART")).getText(),
                CartPage.ZERO_ITEMS_IN_CART
        );
    }

    @Test
    public void isDuckAddedToCartTest() throws Exception {
        CartPage.clickYellowDuck(driver);
        CartPage.selectDuckSize(driver);
        CartPage.addToCartLink(driver);

        CartPage.checkQuantityDucksInCart(driver, wait);
        CartPage.clickCheckoutLink(driver);
        CartPage.checkOrderSummaryHeader(wait);

        Assert.assertEquals(
                driver.findElement(getLocator("StaticObject.ORDER_SUMMARY_HEADER")).getText(),
                CartPage.EXPECTED_ORDER_SUMMARY_HEADER
        );
    }

    @Test
    public void confirmOrderTest() throws Exception {
        CartPage.clickYellowDuck(driver);
        CartPage.selectDuckSize(driver);
        CartPage.addToCartLink(driver);

        CartPage.checkQuantityDucksInCart(driver, wait);
        CartPage.clickCheckoutLink(driver);
        CartPage.checkOrderSummaryHeader(wait);

        CartPage.clickConfirmOrderLink(driver);

        CartPage.checkOrderStatus(wait);

        Assert.assertEquals(
                driver.findElement(getLocator("StaticObject.ORDER_STATUS")).getText(),
                CartPage.EXPECTED_ORDER_STATUS
        );
    }

    @Test
    public void duckRemoveFromCartTest() throws Exception {
        CartPage.clickYellowDuck(driver);
        CartPage.selectDuckSize(driver);
        CartPage.addToCartLink(driver);

        CartPage.checkQuantityDucksInCart(driver, wait);
        CartPage.clickCheckoutLink(driver);

        CartPage.checkRemoveButton(wait);
        CartPage.clickRemoveButton(driver);

        CartPage.checkRemovingSuccessText(wait);

        Assert.assertEquals(
                driver.findElement(getLocator("StaticObject.REMOVING_SUCCESS_TEXT")).getText(),
                CartPage.EXPECTED_REMOVING_SUCCESS_TEXT
        );
    }

    @Test
    public void totalPriceInCartTest() throws Exception {
        CartPage.clickYellowDuck(driver);
        CartPage.selectDuckSize(driver);
        CartPage.addToCartLink(driver);

        CartPage.checkQuantityDucksInCart(driver, wait);
        CartPage.clickCheckoutLink(driver);

        CartPage.checkTotalDucksPrice(wait);

        Assert.assertEquals(
                driver.findElement(getLocator("StaticObject.TOTAL_DUCKS_PRICE")).getText(),
                CartPage.getTotalDucksPrice(driver)
        );
    }
}
