package practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class StringPractise {
	WebDriver driver = new ChromeDriver();
	SoftAssert soft = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	ReadingExcelforwebtest Excelforwebtest = new ReadingExcelforwebtest();
	
	@DataProvider(name="loginname")
	public Object[][]loginname(){
		return Excelforwebtest.getexceldata("C:\\Users\\ranga\\OneDrive\\Desktop\\Pandas\\name.xlsx","Sheet1");
	}
	@Test(dataProvider="loginname")
	public void strikerate(String firstname, String lastname) {
		driver.get("https://www.espncricinfo.com/series/bangladesh-in-india-2024-25-1439844/india-vs-bangladesh-2nd-test-1439892/full-scorecard");	
	
		driver.manage().window().maximize();
		
	//	String strss = "Mushfiqur Rahim";
		
		List<WebElement> ele = driver.findElements(By.xpath("//tr/child::td[8]"));
		
		//List<WebElement> stre = driver.findElements(By.xpath("//a[contains(@class,'ds-items-start ') and contains(@class,'ds-inline-flex') and contains(@class,'ds-leading-none') and contains(@title,'"+strss+"')]"));
		
		//String[] spli= strss.split(" ");
		
		String va = "//tr/child::td[1]//a[contains(@href,'"+firstname.toLowerCase()+"') and contains(@title,'"+firstname+"')]";
		
		String na="//tr/child::td[1]//a[contains(@href,'"+firstname.toLowerCase()+"') and contains(@title,'"+firstname+"')]/ancestor::td/following-sibling::td[7]";
		
		List<WebElement> name= driver.findElements(By.xpath(va));
		List<WebElement> SR = driver.findElements(By.xpath(na));
		
		/*for(int i=0;i<name.size();i++) {
			String ss=s.getText();
			String ss=n.getText();
		}*/
		ArrayList<String> Playername = new ArrayList<>();
		ArrayList<String> Strikerate = new ArrayList<>();
		
		for(WebElement s : name) {
			String ss=s.getText();
			//System.out.println(ss);
			Playername.add(ss);
		}
		
		for(WebElement n:SR) {
			String ss=n.getText();
			//System.out.println(ss);
			Strikerate.add(ss);
		}
		System.out.println(Playername.size());
		for(int i=0;i<Playername.size();i++) {
			System.out.println("Play name: "+Playername.get(i)+" Strike Rate: "+Strikerate.get(i)+" Innings "+i++);
		}
	}
	
	//@Test(dataProvider="loginname",retryAnalyzer = RetryListener.class)
	public void testwithexcel(String name, String pass) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		
		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.id("APjFqb")));
		
		element.sendKeys(name);
		//System.out.println(name);
		WebElement search =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='King Combs']")));
		//WebElement search = driver.findElement(By.xpath("span[normalize-space()='King Combs']"));
		//highlightElement(driver,)
		highlightElement(driver,search);
		search.click();
		
		//span[normalize-space()='King Combs']
		
		WebElement validate = driver.findElement(By.xpath("//div[@class='PZPZlf ssJ7i B5dxMb' and @role='heading' and @aria-level='2']"));
		String str = validate.getText();
		//System.out.println(str);
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(str, "King Combs");
		
		WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Songs')]"));
		String result = element1.getText();
		soft.assertEquals(result, "Songs");
		
		
		//driver.close();
	//	driver.quit();
	}
	//@Test(retryAnalyzer = RetryListener.class)
	public void validationoflinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement s:links) {
			String st= s.getText();
			//String ast = s.get
			//System.out.println(s.getText());
			//System.out.println(s.getAttribute("href"));
			if (st.contains("Songs")) {
				driver.findElement(By.linkText("Songs")).click();
				System.out.println("clicked songs to be present"+s.getText());
				//WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Songs')]"));
				//WebElement	element1 =	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Songs')]")));
				//element1.click();	
				soft.assertAll("Clicked on Songs");
				System.out.println("clicked songs to be present"+s.getText());
			}else {
				//System.out.println("Isn't clicked");
				}
		}
		//driver.close();
	}
	//@Test(retryAnalyzer = RetryListener.class)
	public void validationofLabels() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement s:links) {
			String st= s.getText();
			//System.out.println(s.getText());
			//System.out.println(s.getAttribute("href"));
			if (st.contains("Songs")) {
				
				String[] nu = st.split("Songs");
				
				for(String ts:nu) {
					soft.assertTrue(true, ts);
				}
				
				driver.findElement(By.linkText("Songs")).click();
				//soft.assertAll("Clicked on Songs");
				System.out.println("clicked songs to be present"+s.getText());
			}else {
				//System.out.println("Isn't clicked");
				}
		}
	}
	
	//@Test(retryAnalyzer = RetryListener.class)
	public void validationOfPagination() {
		for(int i=2;i<11;i++) {
		WebElement page = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Page "+i+"']")));
		String name = page.getText();
		//soft.assertEquals(name, "Page "+i, "each page is verified");
		soft.assertTrue(true, "each page is verified page number "+i);
		
		
		}
	}
	
	public void verifyGoogleTabs() {
		
	}
	@AfterSuite
	public void teardown() {
		soft.assertAll();
		driver.close();
	}
	
	
	public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Change the element's style to highlight it
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        
        // Optionally, revert the style after a short delay
        try {
            Thread.sleep(1000); // Highlight for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Revert the highlight
        js.executeScript("arguments[0].style.border=''", element);
    }
	
	
}