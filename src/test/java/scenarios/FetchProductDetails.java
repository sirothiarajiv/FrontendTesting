package scenarios;

import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.ProductPage;
import utilities.TestBase;
import java.io.IOException;

/**
 * author : Rajiv Sirothia
 */
public class FetchProductDetails extends TestBase {
    @Test
    public void getPhoneInfo() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.searchMobilePhones();
        ProductPage productPage = new ProductPage(driver);
        productPage.fetchPhoneDetails();
    }
}
