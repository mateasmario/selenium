package ro.upt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * The platform under test can be found at https://magento.softwaretestingboard.com/.
 */
public class LumaTest {
    private WebDriver webDriver;

    private static WebDriverManager webDriverManager;

    @BeforeAll
    static void beforeAll() {
        if (WebDriverManager.firefoxdriver().getBrowserPath().isPresent()) {
            webDriverManager = WebDriverManager.firefoxdriver();
            return;
        }
    }

    @BeforeEach
    public void setup() {
        Assertions.assertNotNull(webDriverManager);
        webDriverManager.setup();
        webDriver = webDriverManager.create();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

    /*
        Test the website's title
     */
    // ToDo: Implement testTitle()

    /*
        Test the search functionality (search box on the top-right corner)

        Hint: Search for a product that exists (navigate the website a little bit before) and make sure that it is
        displayed in the search results.

        BE CAREFUL: It may not be possible for you to press the search button, as it overlaps with the search box.
        In this case, after typing in the product you want to search for, you can sendKeys(Keys.ENTER) on the
        search box and simulate the user hitting enter instead of clicking on the button to search (this is also more
        realistic)
     */
    // ToDo: Implement testSearch()

    /*
        MANUALLY register on the website using fake data (create a test account) and test the login functionality
        with those credentials
     */
    // ToDo: Implement testLoginCorrect()

    /*
        Now test the login process with invalid data and make sure that a proper error is displayed
     */
    // ToDo: Implement testLoginInvalidData()

    /*
        After logging in on the website (with the credentials created manually), buy a product at your choice
        and proceed with the checkout
     */
    // ToDo: Implement testCheckoutProcess()

}
