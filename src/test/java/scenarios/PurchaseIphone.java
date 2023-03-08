package scenarios;

import org.testng.annotations.Test;
import page.objects.IphonePage;
import page.objects.LoginPage;
import utilities.TestBase;
import java.io.IOException;

/**
 * author : Rajiv Sirothia
 */
public class PurchaseIphone extends TestBase {

    /**
     *
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void loginAndSearchIPhone() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        IphonePage iphonePage = new IphonePage(driver);
        loginPage.login();
        iphonePage.searchIPhone();
        iphonePage.purchaseIphone();
    }
}
