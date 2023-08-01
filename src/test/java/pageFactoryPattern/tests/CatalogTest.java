package pageFactoryPattern.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactoryPattern.pages.CatalogPage;

public class CatalogTest extends TestBase {

    @Test
    public void countDucksTest() {
        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.checkRubberDucksButton(wait);
        catalogPage.clickRubberDucksButton();

        catalogPage.checkDucks(wait);

        Assert.assertEquals(catalogPage.ducks.size(), catalogPage.EXPECTED_DUCKS_QUANTITY);
        System.out.println("Ducks found on the page: " + catalogPage.ducks.size());
    }

    @Test
    public void yellowDuckPriceFilteredByDateTest() {
        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.checkRubberDucksButton(wait);
        catalogPage.clickRubberDucksButton();

        catalogPage.checkDateButton(wait);
        catalogPage.clickDateButton();

        catalogPage.checkDucks(wait);

        Assert.assertEquals(catalogPage.yellowDuckPriceFilteredByDate.getText(),
                catalogPage.EXPECTED_YELLOW_DUCK_PRICE_BY_DATE
        );
        System.out.println("Yellow duck price sorted by Date: " +
                catalogPage.yellowDuckPriceFilteredByDate.getText());
    }

    @Test
    public void blueDuckPriceTest() {
        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.checkRubberDucksButton(wait);
        catalogPage.clickRubberDucksButton();

        catalogPage.checkDucks(wait);

        catalogPage.checkNameButton(wait);
        catalogPage.clickNameButton();

        catalogPage.checkDucks(wait);

        Assert.assertEquals(
                catalogPage.blueDuckPriceFilteredByName.getText(),
                catalogPage.EXPECTED_BLUE_DUCK_PRICE_BY_NAME
        );
        System.out.println("Blue duck price sorted by Name: " +
                catalogPage.blueDuckPriceFilteredByName.getText());
    }

    @Test
    public void temporarySoldOutTest() {
        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.checkRubberDucksButton(wait);
        catalogPage.clickRubberDucksButton();

        catalogPage.checkDucks(wait);

        catalogPage.checkPurpleDuck(wait);
        catalogPage.clickPurpleDuck();
        catalogPage.checkTemporarySoldOutTest(wait);

        Assert.assertEquals(catalogPage.temporarySoldOutText.getText(),
                catalogPage.EXPECTED_TEMPORARY_SOLD_OUT_TEXT
        );
        System.out.println(
                "Duck is: " +
                        catalogPage.temporarySoldOutText.getText().toLowerCase()
        );
    }

    @Test
    public void openDetailsTabTest() {
        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.checkRubberDucksButton(wait);
        catalogPage.clickRubberDucksButton();

        catalogPage.checkDucks(wait);

        catalogPage.checkPurpleDuck(wait);
        catalogPage.clickPurpleDuck();

        catalogPage.checkDetailsTab(wait);
        catalogPage.clickDetailsTab();

        Assert.assertEquals(
                catalogPage.parentLiDetailsTab.getAttribute("class"),
                catalogPage.EXPECTED_ACTIVE_ATTRIBUTE
        );
        System.out.println(
                "Current information tab has class: " +
                        catalogPage.parentLiDetailsTab.getAttribute("class")
        );
    }

}
