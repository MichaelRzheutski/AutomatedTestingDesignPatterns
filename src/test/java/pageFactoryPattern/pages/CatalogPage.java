package pageFactoryPattern.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage {
    @FindBy(xpath = "//li[@class='category-1']/a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']")
    public WebElement rubberDucksButton;
    @FindBys(@FindBy(css = ".product.column.shadow.hover-light"))
    public List<WebElement> ducks;
    public final int EXPECTED_DUCKS_QUANTITY = 5;

    @FindBy(xpath = "//nav[@class='filter']/a[last()]")
    public WebElement dateButton;
    @FindBy(xpath = "//a[@title='Yellow Duck']/div/strong")
    public WebElement yellowDuckPriceFilteredByDate;
    public final String EXPECTED_YELLOW_DUCK_PRICE_BY_DATE = "$18";

    @FindBy(css = "nav.filter :first-child")
    public WebElement nameButton;
    @FindBy(xpath = "//a[@title='Blue Duck']/div/span")
    public WebElement blueDuckPriceFilteredByName;
    public final String EXPECTED_BLUE_DUCK_PRICE_BY_NAME = "$20";

    @FindBy(xpath = "//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/purple-duck-p-5']")
    public WebElement purpleDuck;
    @FindBy(xpath = "//div[@class='stock-partly-available']/span")
    public WebElement temporarySoldOutText;
    public final String EXPECTED_TEMPORARY_SOLD_OUT_TEXT = "Temporary sold out";

    @FindBy(xpath = "//a[@href='#tab-details']/..")
    public WebElement parentLiDetailsTab;
    @FindBy(xpath = "//a[@href='#tab-details']")
    public WebElement detailsTab;
    public final String EXPECTED_ACTIVE_ATTRIBUTE = "active";

    public void checkRubberDucksButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(rubberDucksButton));
    }

    public void clickRubberDucksButton() {
        rubberDucksButton.click();
    }

    public void checkDucks(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(ducks));
    }

    public List<WebElement> getDucksQuantity() {
        return ducks;
    }

    public void checkDateButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(dateButton));
    }

    public void clickDateButton() {
        dateButton.click();
    }

    public void checkNameButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(nameButton));
    }

    public void clickNameButton() {
        nameButton.click();
    }

    public void checkPurpleDuck(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(purpleDuck));
    }

    public void clickPurpleDuck() {
        purpleDuck.click();
    }

    public void checkTemporarySoldOutTest(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(temporarySoldOutText));
    }

    public void checkDetailsTab(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElements(detailsTab));
    }

    public void clickDetailsTab() {
        detailsTab.click();
    }
}
