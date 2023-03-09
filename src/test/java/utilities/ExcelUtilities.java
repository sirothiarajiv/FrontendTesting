package utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * author : Rajiv Sirothia
 */
public class ExcelUtilities {

    /**
     * writeIntoExcelFile() write data into excel sheet
     * @param Row
     * @param column
     * @param data
     * @throws IOException
     */
    public void writeIntoExcelFile(int Row, int column, Object data) throws IOException {
        Workbook book ;
        FileInputStream inputStream = new FileInputStream("./src/test/resources/test-result/mobile-details.xlsx");
        book = WorkbookFactory.create(inputStream);
        book.getSheet("Sheet1").getRow(Row).getCell(column).setCellValue(String.valueOf(data));
        FileOutputStream fos = new FileOutputStream("./src/test/resources/test-result/mobile-details.xlsx");
        book.write(fos);
        book.close();
    }
}
