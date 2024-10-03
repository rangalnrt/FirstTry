import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestNG {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
               // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
               // System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
                driver = new FirefoxDriver();
                break;
            case "edge":
                //System.setProperty("webdriver.edge.driver", "path_to_edgedriver");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unsupported browser: " + browser);
                break;
        }
    }

    @Test
    public void testTitle() {
        String baseUrl = "https://makemytrip.com/";
        driver.get(baseUrl);
        System.out.println("Title of the page in " + driver.getClass().getSimpleName() + ": " + driver.getTitle());
        // Add assertions or other test steps as needed
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
