package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PropertyUtilities;
import utilities.WindowHandler;
import java.io.IOException;
import java.time.Duration;

/**
 * author : Rajiv Sirothia
 */
public class IphonePage {
    WebDriver driver;
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchTextBox;
    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchButton;
    @FindBy(xpath = "//span[contains(text(),'64 GB')]")
    private WebElement sort64GB;
    @FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    private WebElement clickIphone64GB;
    @FindBy(css = "div[id='contextualIngressPt']")
    private WebElement locationButton;
    @FindBy(css = "input[id='GLUXZipUpdateInput']")
    private WebElement addPinButton;
    @FindBy(css = "span[id='GLUXZipUpdate-announce']")
    private WebElement applyButton;
    @FindBy(css = "span[id='submit.add-to-cart-announce']")
    private WebElement addToCartText;
    @FindBy(css = "input[id='add-to-cart-button']")
    private WebElement clickAddToCartButton;
    @FindBy(css = "span[id='submit.buy-now-announce']")
    private WebElement clickBuyNowButton;
    @FindBy(css = "#attach-sidesheet-checkout-button > span > input")
    private WebElement clickProceedButton;
    @FindBy(css = "div[class='a-column a-span8']")
    private WebElement checkoutText;
    @FindBy(css = "#add-new-address-popover-link")
    private WebElement clickAddNewAddress;
    @FindBy(css = "#address-ui-widgets-enterAddressFullName")
    private WebElement sendFullName;
    @FindBy(css = "#address-ui-widgets-enterAddressPhoneNumber")
    private WebElement sendMobileNumber;
    @FindBy(css="#address-ui-widgets-enterAddressPostalCode")
    private WebElement sendPinCode;
    @FindBy(css = "#address-ui-widgets-enterAddressLine1")
    private WebElement sendHouseNumber;
    @FindBy(css = "#address-ui-widgets-enterAddressLine2")
    private WebElement sendStreetNo;
    @FindBy(css = "#address-ui-widgets-landmark")
    private WebElement sendLandmark;
    @FindBy(css = "#address-ui-widgets-form-submit-button > span > input")
    private WebElement useThisAddress;

    public IphonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @throws IOException
     */
    public void searchIPhone() throws IOException {
        PropertyUtilities props = new PropertyUtilities();
        String searchPhone =  props.readData("configs","searchIPhone");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(searchTextBox)).sendKeys(searchPhone);
        searchButton.click();
        Assert.assertEquals("Amazon.in : iPhone 12", driver.getTitle());
        sort64GB.click();
    }

    /**
     *
     * @throws InterruptedException
     * @throws IOException
     */
    public void purchaseIphone() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WindowHandler windowHandler=new WindowHandler();

        if(clickIphone64GB.getText().contains("64GB")==true){
            clickIphone64GB.click();
            windowHandler.windowHandler();
            Assert.assertEquals("Add to Cart", addToCartText.getText());
            Assert.assertEquals("Buy Now", clickBuyNowButton.getText());
            wait.until(ExpectedConditions.elementToBeClickable(clickAddToCartButton)).click();
            wait.until(ExpectedConditions.visibilityOf(clickProceedButton)).click();
            Thread.sleep(500);
            Assert.assertEquals("Checkout", checkoutText.getText());
            Assert.assertEquals("Select a delivery address", driver.getTitle());
            clickAddNewAddress.click();
            PropertyUtilities props = new PropertyUtilities();
            Thread.sleep(5000);
            String name=props.readData("configs","name");
            sendFullName.sendKeys(name);
            String phoneNumber=props.readData("configs","phoneNumber");
            sendMobileNumber.sendKeys(phoneNumber);
            Thread.sleep(5000);
            String pinCodeAddress=props.readData("configs","pinCode");
            sendPinCode.sendKeys(pinCodeAddress);
            String houseNo=props.readData("configs","houseNumber");
            sendHouseNumber.sendKeys(houseNo);
            String streetName=props.readData("configs","street");
            sendStreetNo.sendKeys(streetName);
            String landMarks=props.readData("configs","landmark");
            sendLandmark.sendKeys(landMarks);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(useThisAddress)).click();
            Thread.sleep(6000);
        }
        else{
            System.out.println("Apple iPhone 12 not found");
        }
    }
}

