
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "firefox");
        logger.info("Launching browser: {}", browser);
        driver = DriverFactory.getInstance().getDriver(browser);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        logger.info("Closing browser for thread: {}", Thread.currentThread().getName());
        DriverFactory.getInstance().quitDriver();
    }
}
