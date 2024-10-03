package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class crossBrowser {
	private WebDriver driver =null;
	@Test
	public  void setup() {
		// TODO Auto-generated method stub
		String baseURL = "https://www.makemytrip.com/";
		
			executetest(driver,"chrome",baseURL);
			
		}
	@BeforeMethod
	public  void executetest(WebDriver driver, String browserset, String baseURL) {

		String[] broswers = {"chrome","Edge"};
		for (String browser:broswers) {
			
			switch(browser.toLowerCase()) {
			case "chrome" :
				driver = new ChromeDriver();
				break;
			case "edge" :
				driver = new EdgeDriver();
				break;
			default :
				System.out.println("un supported browser "+ browser);
			}
			driver.get(baseURL);
			System.out.println("title of the page "+browserset+" in "+driver.getTitle());
		}
	}

			
	@AfterMethod
	public void quitbrowser() {
			driver.quit();
			
	}
		
	
}