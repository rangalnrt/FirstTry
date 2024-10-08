package practise;

import static org.testng.Assert.assertEquals;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class base {
	private static final TakesScreenshot WebDriver = null;
	static WebDriver driver;
	@BeforeClass
	public static Object[][] readexcel(String filename, String sheetname) throws IOException {
		
		FileInputStream f= new FileInputStream(filename);
		Workbook wb = new XSSFWorkbook(f);
		Sheet sg= wb.getSheet(sheetname);
		
		int rows = sg.getPhysicalNumberOfRows();
		int cols = sg.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rows);
		System.out.println(cols);
		Object[][] data = new Object[rows-1][cols];
		for(int i=0;i<rows;i++) {
			Row row = sg.getRow(i);
			
			for(int j=0;j<cols;j++) {
				Cell ce=row.getCell(j);
				data[i-1][j] = ce;
			}
		}
		
		
		wb.close();
		f.close();
		System.out.println(data);
		return data;
		
		
	}
	
	@BeforeClass
	public static void setup() throws InterruptedException {
		//System.out.println("First");
		 // Initialize ChromeDriver
         driver = new ChromeDriver();

        // Open chewy.com
        driver.get("https://www.chewy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement elemnt = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("element")));
        driver.manage().window().maximize();
      /*  Select select = new Select(elemnt);
        SoftAssert assert = new SoftAssert();
        assert.as
        
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        WebElement ele = wait1.until((ExpectedConditions.elementToBeClickable(By.id("name"))));
        
                TakesScreenshot srcshot = ((TakesScreenshot)WebDriver);
		File srcfile = srcshot.getScreenshotAs(OutputType.FILE);
		
		File destfile = new File("C:\\Users\\ranga\\OneDrive\\Desktop");
		FileUtils.copyFile(srcfile,destfile);*/
	}
	@AfterClass
	public void Cleanup() {
		System.out.println("Cleanup");
		 // Close the browser
        driver.quit();
	} 
	
	 public static void highlight(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
	    }
	
	//WebDriverWait(driver, 10).until(		    EC.visibility_of_element_located((By.ID, "searchInput")))

}
