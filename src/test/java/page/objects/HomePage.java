package page.objects;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Team;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.TestBase;

import java.time.Duration;

/**
 * author : Rajiv Sirothia
 */
public class HomePage {
    WebDriver driver;
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchTextBox;
    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchSubmitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchMobilePhones(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(searchTextBox)).sendKeys("Mobile Phone");
        searchSubmitButton.click();
        Assert.assertEquals("Amazon.in : Mobile Phone", driver.getTitle());
    }
}
