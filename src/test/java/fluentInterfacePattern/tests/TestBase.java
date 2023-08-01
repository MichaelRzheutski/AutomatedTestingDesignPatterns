package fluentInterfacePattern.tests;

import fluentInterfacePattern.Browser;
import fluentInterfacePattern.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static fluentInterfacePattern.Browser.CHROME;

public class TestBase {
    protected final String HOME_PAGE = "https://litecart.stqa.ru/en/";
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup() {
        Browser browser = Browser.getEnumByLabel(
                System.getProperty("browser", CHROME.getBrowserName())
        );

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get(HOME_PAGE);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
