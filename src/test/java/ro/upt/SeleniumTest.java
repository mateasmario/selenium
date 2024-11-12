package ro.upt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SeleniumTest {
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
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

    @Test
    public void checkTitleIsCorrect() {
        webDriver.get("https://www.saucedemo.com/");
        String title = webDriver.getTitle();
        Assertions.assertEquals("SwagLabs", title);
    }

    @Test
    public void checkAuthenticationWorked() {
        webDriver.get("https://www.saucedemo.com/");
        Actions actions = new Actions(webDriver);

        WebElement usernameTextBox = webDriver.findElement(By.name("user-name"));
        actions.sendKeys(usernameTextBox, "standard_user");

        WebElement passwordTextBox = webDriver.findElement(By.name("password"));
        actions.sendKeys(passwordTextBox, "secret_sauce").perform();

        WebElement loginButton = webDriver.findElement(By.name("login-button"));
        loginButton.click();

        WebElement headingText = webDriver.findElement(By.className("title"));
        Assertions.assertEquals("Products", headingText.getText());
    }

    /*
        Enter invalid login data and check if the website responded properly.
     */
    @Test
    public void testAuthenticationFailed() {
        // ToDo: Implement
    }

    /*
        After logging in, click on the filter and select "Price (low to high)", then write your assertion based
        on the first element that is shown
     */
    @Test
    public void testOrderProductsByPrice() {
        // ToDo: Implement
    }

    /*
        After logging in, add one item to the cart and make sure that the button got transformed into a "Remove" button
     */
    @Test
    public void testAddToCartDisplaysRemoveButton() {
        // ToDo: Implement
    }

    /*
        After logging in, add a product (or more) to the cart and go further with the checkout process by filling in
        all the required inputs. Then, make sure that the "Thank you for your order!" page is displayed.
     */
    @Test
    public void testEntireCheckoutProcess() {
        // ToDo: Implement
    }

    /*
        After logging in, log out and check if the user is properly redirected to the login page
     */
    @Test
    public void testLogoutWorks() {
        // ToDo: Implement
    }

    /*
        Try logging in with a locked out user, and make sure that it doesn't work, and that the proper message is
        displayed.
     */
    @Test
    public void testLockedOutUser() {
        // ToDo: Implement
    }

}
