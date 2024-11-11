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
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title = webDriver.getTitle();
        Assertions.assertEquals("OrangeHRM", title);
    }

    @Test
    public void checkAuthenticationWorked() {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Actions actions = new Actions(webDriver);

        WebElement usernameTextBox = webDriver.findElement(By.name("username"));
        actions.sendKeys(usernameTextBox, "Admin");

        WebElement passwordTextBox = webDriver.findElement(By.name("password"));
        actions.sendKeys(passwordTextBox, "admin123").perform();

        WebElement loginButton = webDriver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        WebElement usernameText = webDriver.findElement(By.className("oxd-userdropdown-name"));
        Assertions.assertEquals("manda user", usernameText.getText());
    }

    /*
        Enter invalid login data and check if the website responded properly
     */
    @Test
    public void checkAuthenticationFailed() {
        // ToDo: Implement
    }

    /*
        By clicking on the "My Info" button in the menu, make sure that the Driver's license number is properly displayed
        and equal tu 56796
     */
    @Test
    public void checkEmployeeIdIsDisplayedProperly() {
        // ToDo: Implement
    }

    /*
        After logging in on the website, select the "Candidate to interview" in My Actions and click the button to see their application.
        Then, check that the displayed e-mail address is indeed martinetennat@gmail.com
     */
    @Test
    public void checkNameOfCandidateToInteviewIsDisplayed() {
        // ToDo: Implement
    }

    /*
        After clicking on the "Admin" button, delete a record (click on the 'trash' icon next to a record), and check
        that only three records left remain. Be careful, as you cannot delete the first item. Try with the other ones.
     */
    @Test
    public void checkDeleteButtonInAdminPanelWorks() {
        // ToDo: Implement
    }

}
