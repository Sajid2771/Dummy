package com.shopperStack.generalUtility;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shopperStack.pom.HomePage;
import com.shopperStack.pom.LoginPage;
import com.shopperStack.pom.WelcomePage;

public class BaseTest  {
	
	public WebDriver driver;
		
	public static WebDriver listenerDriver;
	
	public FileUtility file = new FileUtility();
	public WebdriverUtility wbDriverUtil = new WebdriverUtility();
	public JavaUtility java = new JavaUtility();
	public HomePage hPage; 
	
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		spark= new ExtentSparkReporter("./repots/" + java.dateTime() + ".html");
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		
		System.out.println("Before Class");
		report = new ExtentReports();
		report.attachReporter(spark);
		test = report.createTest("Demo");
		
//		String url= file.readPropertyFile("url");
//		String browser= file.readPropertyFile("browser");
		String url=System.getProperty("url");
		String browser=System.getProperty("browser");
		
		 if(browser.equals("chrome")) {
			 driver= new ChromeDriver();
		 }
		 else if( browser.equals("fireFox")){
			 driver= new FirefoxDriver();
		 }
		 else {
			 System.out.println("Invalid Browser");
		 }
		 listenerDriver=driver;
		 hPage= new HomePage(driver);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		 driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Before Method");
		test.log(Status.INFO, "Verify Welcome Page Is Open");
		WelcomePage wPage= new WelcomePage(driver);
		wPage.getLoginButton().click();
		
		test.log(Status.INFO, "Verify User Is Able To Login");
		LoginPage lPage= new LoginPage(driver);
		lPage.getEmailId().sendKeys(file.readPropertyFile("email"));
		lPage.getPwd().sendKeys(file.readPropertyFile("pwd"));
		lPage.getLoginButton().click();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("After Method");
		
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("After Class");
		Thread.sleep(3000);
		driver.quit();
		report.flush();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");	
	}
}
