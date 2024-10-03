package practise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChewyLogin extends base {
	/*
	 * // public static void main(String[] args) throws InterruptedException { //
	 * setup(); // logintest(); // logout(); // // }
	 */

	@dataprovider(name="readinput")
	public static Object[][] readingdata() throws IOException{
	System.out.println(base.readexcel("C:\\Users\\ranga\\OneDrive\\Desktop\\name.xlsx", "Sheet1"));	
		return base.readexcel("C:\\Users\\ranga\\OneDrive\\Desktop\\name.xlsx", "Sheet1");
	}
	
	
	@Test(dataProvider="readinput")
	public static void logintest(String col1, String col2) throws InterruptedException {
		
		System.out.println(col1);
		System.out.println(col2);
		// Set path to ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

//Thread.sleep(3000);
		///div[@class='desktop-header']//a//*[text()='Sign In']/following-sibling::span
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='desktop-header']//a//*[text()='Sign In']")));

		// Find the sign-in link and click on it
		// WebElement signInLink = driver.findElement();

		
		
		Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='desktop-header']//a//*[text()='Sign In']")));
		highlight(signInLink);
		
		boolean b=signInLink.isEnabled();
		
		Assert.assertEquals(b, true);
		SoftAssert softassert = new SoftAssert();
Select s = new Select(signInLink);
		
		softassert.assertEquals("","");
		signInLink.click();

		// Find the email input field and enter your email
		WebElement emailInput = driver.findElement(By.id("username"));
		emailInput.sendKeys("ranga.lnrt1@gmail.com");

		// Find the password input field and enter your password
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("Jaanu@2017");
		//button[@id='kc-login']
		// Find the submit button and click on it to login
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='kc-login']"));
		
		signInButton.click();
		Actions actions = new Actions(driver);
		
		WebElement account = driver.findElement(By.xpath("//a[@data-testid='account-link']//div[@class='accountNavContent js-nav-spa-test-activation-trigger']"));
		actions.moveToElement(account).perform();
		WebElement signOut = driver.findElement(By.xpath("//a[@class='AccountNavList__sign-out-link']"));
		Assert.assertEquals(false, false);
		
		signOut.click();
		//a[@class='AccountNavList__sign-out-link']
		//a[@data-testid='account-link']//div[@class='accountNavContent js-nav-spa-test-activation-trigger']
		// Wait for a while to see the result before closing the browser
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void logout() {
		// TODO Auto-generated method stub

		System.out.println("ZLoging out");

	}
}
