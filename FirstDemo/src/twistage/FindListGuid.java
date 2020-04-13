package twistage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.chrome.ChromeDriver;
public class FindListGuid {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "//home//agnip//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://console-dev.twistage.com");

		String VideoGuidFixedStart = "/html[1]/body[1]/div[3]/div[1]/div[3]/div[2]/div[2]/form[1]/table[1]/tbody[2]/";
		String VideoGuidFixedEnd = "/td[6]/span[1]";
		String VideoGuidVariable = "tr[1]";
		String uID = "agnip.karmakar@hyland.com";
		String pswd = "Use your own";
		String company = "QA - New Test City";

		// Login
		Thread.sleep(5000);
		driver.findElement(By.id("login")).sendKeys(uID);
		driver.findElement(By.id("password")).sendKeys(pswd);
		driver.findElement(By.className("login_button")).click();

		WebDriverWait twisTageWaitVar = new WebDriverWait(driver, 10);

		// Set Company
		Thread.sleep(2000);
		// driver.findElement(By.id("company_name")).sendKeys("QA - New Test City");
		twisTageWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("company_name")));
		driver.findElement(By.id("company_name")).sendKeys(company);
		twisTageWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("company_name_auto_complete")));
		driver.findElement(By.id("company_name_auto_complete")).click();
		twisTageWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("dismiss")));
		driver.findElement(By.className("dismiss")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tab_video")).click();
		Thread.sleep(8000);

		// Set a Library
		/*
		 * twisTageWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "library_name")));
		 * 
		 * driver.findElement(By.id("library_name")).sendKeys(libraryName);
		 * twisTageWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "library_name_auto_complete")));
		 * driver.findElement(By.id("library_name_auto_complete")).click();
		 * twisTageWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * className("dismiss"))); driver.findElement(By.className("dismiss")).click();
		 */

		int j = 2;

		for (j = 2; j <= 80; j++) {
			for (int i = 1; i <= 19; i = i + 2) {
				System.out.print(driver.findElement(By.xpath(VideoGuidFixedStart + "tr[" + i + "]" + VideoGuidFixedEnd))
						.getText());

				System.out.println("");
			}
			driver.findElement(By.xpath("//a[@class='next_page']")).click();
			Thread.sleep(8000);
		}
		driver.close();
	}

	public static void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
}