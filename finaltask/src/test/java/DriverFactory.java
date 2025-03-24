import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static DriverFactory instance;

    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver(String browser) {
        if (driverThreadLocal.get() == null) {
            switch (browser.toLowerCase()) {
                case "edge":
                    logger.info("Initializing EdgeDriver for thread: {}", Thread.currentThread().getName());
                    WebDriverManager.edgedriver().setup();
                    driverThreadLocal.set(new EdgeDriver());
                    break;
                default:
                    logger.info("Initializing FirefoxDriver for thread: {}", Thread.currentThread().getName());
                    WebDriverManager.firefoxdriver().setup();
                    driverThreadLocal.set(new FirefoxDriver());
                    break;
            }
        }
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        if (driverThreadLocal.get() != null) {
            logger.info("Quitting WebDriver for thread: {}", Thread.currentThread().getName());
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
