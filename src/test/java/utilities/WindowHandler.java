package utilities;

import java.util.Iterator;
import java.util.Set;
import static utilities.TestBase.driver;

/**
 * author @ Rajiv Sirothia
 */

public class WindowHandler {
    public void windowHandler(){
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
            driver.switchTo().window(subWindowHandler);
            System.out.println(subWindowHandler);
        }
        driver.switchTo().window(subWindowHandler);
        System.out.println(driver.getWindowHandle());
    }
}
