package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * author : Rajiv Sirothia
 */
public class TestBase {
    public ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
    public static WebDriver driver = null;

    /**
     *
     * @param browserName
     * @throws IOException
     */
    @Parameters({"browserName"})
    @BeforeClass
    public void openBrowser(@Optional String browserName)
            throws IOException {
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("UI Automation Report");
        extent.attachReporter(spark);

        PropertyUtilities props = new PropertyUtilities();
        String chromeBrowser=props.readData("configs","browserOneName");
        String baseUrl = props.readData("configs","baseUrl");
        String firefoxBrowser=props.readData("configs","browserTwoName");

        if(browserName.equalsIgnoreCase(chromeBrowser)){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
        } else if (browserName.equalsIgnoreCase(firefoxBrowser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
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
