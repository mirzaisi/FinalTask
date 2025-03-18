import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "firefox");
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
