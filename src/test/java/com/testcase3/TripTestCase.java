package com.testcase3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TripTestCase {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		
		report=new ExtentReports("./test-output/TestReport.html");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		logger=report.startTest("GET");
		logger.log(LogStatus.INFO, "Go to MakeMyTrip.com");
		
		driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.log(LogStatus.PASS, "Test Verified");
        
        logger.log(LogStatus.INFO, "Select Round Trip");
        
        WebElement roundtrip=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/ul/li[2]"));
        roundtrip.click();
        
        logger.log(LogStatus.PASS, "Test Verified");
        
        logger.log(LogStatus.INFO, "Select From City");
        
        WebElement we = driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));
        we.click();
        WebElement we1=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
      
        we1.sendKeys("chandi");
        Thread.sleep(3000);
        we1.sendKeys(Keys.ARROW_DOWN );
        we1.sendKeys(Keys.ENTER);
        

        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "Test Verified");
        
        logger.log(LogStatus.INFO, "Select To City");
        
        WebElement se1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input"));
        se1.sendKeys("pune");
        Thread.sleep(3000);
        se1.sendKeys(Keys.ARROW_DOWN );
        se1.sendKeys(Keys.ENTER);
        
        logger.log(LogStatus.PASS, "Test Verified");
        
        logger.log(LogStatus.INFO, "Select Dates and submit");
        
        Thread.sleep(3000);
        
        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        
        WebElement ele=driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Jun 28 2022')]"));
        Thread.sleep(5000);
        ele.click();
        
        WebElement ele1=driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Jul 03 2022')]"));
        Thread.sleep(5000);
        ele1.click();
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
        
        logger.log(LogStatus.PASS, "Test Verified");
        
        Thread.sleep(15000);
        
        report.endTest(logger);
		report.flush();
        
        driver.close();
		
	}
}
