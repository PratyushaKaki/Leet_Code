package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(3000);
        if(actualUrl.contains("leetcode")) {
            System.out.println("Url Contains LeetCode");
        } else {
            System.out.println("Url doesnot Contains LeetCode");
        }
        System.out.println("end Test case: testCase01");
    }

     public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");
        Thread.sleep(3000);
        //click on sign in btn
        WebElement signin = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signin.click();
        Thread.sleep(2000);
        //click on problem tab
        WebElement problemtab = driver.findElement(By.linkText("Problems"));
        problemtab.click();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains("problemset")) {
            System.out.println("The URL Contains problemset");
        } else {
            System.out.println("The URL doesnot Contains problemset");
        }
        //retrive first five problems
        List<WebElement> problemList = driver.findElements(By.xpath("//div[@class='overflow-hidden']"));
        for(int i=0; i<6; i++) {
            System.out.println(problemList.get(i).getText());
        }
        //retive first problem
        // WebElement firstProblem = driver.findElement(By.xpath("//div[@class='overflow-hidden']"));
        // String firstProblemText = firstProblem.getText();
        // Thread.sleep(2000);
        // System.out.println("The Problem Statment is: " +firstProblemText);
        System.out.println("end Test case: testCase02");
    }

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");
        //click on sign in btn
        WebElement signin = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signin.click();
        Thread.sleep(2000);
        //click on problem tab
        WebElement problemtab = driver.findElement(By.linkText("Problems"));
        problemtab.click();
        Thread.sleep(2000);
        //click on two sum problem
        WebElement twoSum = driver.findElement(By.xpath("//a[@href ='/problems/two-sum']"));
        twoSum.click();
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(3000);
        if(actualUrl.contains("two-sum")) {
            System.out.println("Url Contains two-sum");
        } else {
            System.out.println("Url doesnot Contains two-sum");
        }
        System.out.println("end Test case: testCase03");
    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");
        //click on sign in btn
        WebElement signin = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signin.click();
        Thread.sleep(2000);
        //click on problem tab
        WebElement problemtab = driver.findElement(By.linkText("Problems"));
        problemtab.click();
        Thread.sleep(2000);
        //click on two sum problem
        WebElement twoSum = driver.findElement(By.xpath("//a[@href ='/problems/two-sum']"));
        twoSum.click();
        Thread.sleep(3000);
        //click on dynamic layout btn
        WebElement dynamicLayout = driver.findElement(By.xpath("//button[text()='Enable Dynamic Layout']"));
        Thread.sleep(2000);
        dynamicLayout.click();
        Thread.sleep(2000);
        //click on skiptour btn 
        WebElement skipTour = driver.findElement(By.xpath("//button[text()='Skip tour']"));
        Thread.sleep(3000);
        skipTour.click();
        Thread.sleep(3000);
        //click on submissions limk
        WebElement submissions = driver.findElement(By.xpath("(//div[text()='Submissions'])[2]"));
        // WebDriverWait wait = new WebDriverWait(driver, 20);
        // wait.until(ExpectedConditions.elementToBeClickable(submissions));
        submissions.click();
        Thread.sleep(2000);
        //verify register btn is present or not
        WebElement registerbtn = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String registerbtntext = registerbtn.getText();
        if(registerbtntext.contains("Register or Sign In")) {
            System.out.println("Register or Sign In is displayed");
        } else {
            System.out.println("Register or Sign In is not displayed");
        }
        System.out.println("end Test case: testCase04");
    }


}
