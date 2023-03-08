package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtilities;
import java.io.IOException;
import java.util.List;

/**
 * author : Rajiv Sirothia
 */
public class ProductPage {
    WebDriver driver;
    ExcelUtilities writeDataToExcel = new ExcelUtilities();
    @FindBy(css = "span[class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> phoneDescription;
    @FindBy(css = "span[class='a-price-whole']")
    private List<WebElement> phonePrice;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @throws IOException
     */
    public void fetchPhoneDetails() throws IOException {
        int row = 0;
        writeDataToExcel.writeIntoExcelFile(row, 0,"Phones");
        writeDataToExcel.writeIntoExcelFile(row, 1,"Prices");
        row += 1;
        for(int i=0;i<phoneDescription.size();i++){
            writeDataToExcel.writeIntoExcelFile(row,0,phoneDescription.get(i).getText());
            writeDataToExcel.writeIntoExcelFile(row,1,phonePrice.get(i).getText());
            row += 1;
        }
    }
}
