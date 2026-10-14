package trails.WinAppDriver;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AutomateCalc {

        public static void main(String[] args) throws Exception {


            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

            WindowsDriver driver = new WindowsDriver(new URL(" http://127.0.0.1:4723/"),capabilities);

            driver.findElementByAccessibilityId("num1Button").click();
            System.out.println("Clicked ONE");



        }


}