package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

/**
 * author : Rajiv Sirothia
 */
public class TestBase {
    public ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
    public static WebDriver driver = null;

    @Parameters({"browserName"})
    @BeforeClass
    public void openBrowser(@Optional String browserName){
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("UI Automation Report");
        extent.attachReporter(spark);

        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");
        }else {
            System.out.println("Enter correct browser configs.");
        }
    }
    @AfterClass
    public void closeBrowser(){
        extent.flush();
        driver.quit();
    }
}
