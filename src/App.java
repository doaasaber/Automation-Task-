import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

        public static WebDriver init() {
                // static WebDriver driver;
                String driver_path = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver",
                                driver_path + "\\src\\drivers\\chromedriver.exe");
                Dimension dm = new Dimension(1024, 768);
                WebDriver driver = new ChromeDriver();
                driver.manage().window().setSize(dm);
                return driver;

        }

        public static void main(String[] args) throws Exception {
                WebDriver driver = init();
                 amazon.add_item(driver);
                 driver.close();
                 driver = init();
                 amazon.select_item(driver);
                 driver.close();
                 driver = init();
                ksrtc.book_seat(driver);
                driver.close();
                driver.quit();

        }
}
