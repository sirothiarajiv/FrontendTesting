package scenarios;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.ProductPage;
import utilities.TestBase;

import java.io.IOException;

/**
 * author : Rajiv Sirothia
 */
public class FetchProductDetails extends TestBase {

    /**
     *
     * @throws IOException
     */
    @Test
    public void getPhoneInfo() throws IOException {
        ExtentTest test = extent
                .createTest("Search the mobile and assert the page title.")
                .assignAuthor("Rajiv")
                .assignCategory("functional-test").assignDevice("Web_Application");

        HomePage homePage = new HomePage(driver);
        homePage.searchMobilePhones();
        ProductPage productPage = new ProductPage(driver);
        if (driver.getTitle().equals("Amazon.in : Mobile Phone")) {
            test.info("Title Asserted successfully.");
        } else {
            test.fail("Title assertion failed." + driver.getTitle());
        }
        productPage.fetchPhoneDetails();
    }
}
