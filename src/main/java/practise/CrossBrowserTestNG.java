package practise;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestNG {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
             //  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");
                driver = new ChromeDriver();
                break;
            case "firefox":
             //  System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox");
                driver = new FirefoxDriver();
                break;
            case "edge":
             //   System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Microsoft Office\\Office16");
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

