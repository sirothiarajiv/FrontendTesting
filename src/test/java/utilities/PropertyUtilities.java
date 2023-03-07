package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * author ; Rajiv Sirothia
 */
public class PropertyUtilities {

    /**
     * readData()
     * @param fileName
     * @param key
     * @return
     * @throws IOException
     */
    public String readData(String fileName,String key) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/"+fileName+".properties");
        Properties properties = new Properties();
        properties.load(fis);
        String pass =properties.getProperty(key);
        return pass;
    }
}
