package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PropertyUtilities;
import java.io.IOException;

/**
 * author : Rajiv Sirothia
 */
public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "(//span[@class='nav-action-inner'])[2]")
    private WebElement clickSignInButton;
    @FindBy(css = "#ap_email")
    private WebElement sendEmail;
    @FindBy(css = "#continue")
    private WebElement clickNextButton;
    @FindBy(css = "#ap_password")
    private WebElement sendPassword;
    @FindBy(css = "#signInSubmit")
    private WebElement clickSubmitButton;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void login() throws InterruptedException, IOException {

        PropertyUtilities props=new PropertyUtilities();
        driver.navigate().refresh();
        Thread.sleep(2000);
        clickSignInButton.click();
        sendEmail.sendKeys(props.readData("configs","email"));
        clickNextButton.click();
        sendPassword.sendKeys(props.readData("configs","password"));
        clickSubmitButton.click();
    }
}
