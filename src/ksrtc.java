import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ksrtc {
        public static void book_seat(WebDriver driver) throws InterruptedException {
                driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(locators.header)));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(locators.routes)));
                driver.findElement(By.xpath(locators.routes)).click();
                js.executeScript("window.scrollBy(0,1000)");
                driver.findElement(By.xpath(locators.date)).click();
                js.executeScript("window.scrollBy(0,-300)");

                driver.findElement(By.xpath(locators.search_bus_button)).click();

                wait.until(ExpectedConditions

                                .elementToBeClickable(By.xpath(locators.route_title)));
                js.executeScript("window.scrollBy(0,400)");

                driver.findElement(By.xpath(locators.select_seat_button)).click();
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(locators.seat_details)));
                driver.findElement(By.xpath(locators.chosse_seat)).click();

                driver.findElement(By.xpath(locators.dropping_point)).click();

                List<WebElement> options = driver.findElements(By.xpath(
                                "/html/body/main/form/section/div/div[6]/div[3]/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/ul"));
                options.get(0).click();

                driver.findElement(By.xpath(
                                "/html/body/main/form/section/div/div[6]/div[3]/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/ul/li[3]/a"))
                                .click();
                driver.findElement(By.xpath(locators.mobile_num)).sendKeys("6789125987");
                String[] email = email_data();
                for (int i = 0; i < email.length; i++) {
                        driver.findElement(By.xpath(locators.email)).clear();
                        driver.findElement(By.xpath(locators.email)).sendKeys(email[i]);

                }
                String[] name = name_data();
                for (int i = 0; i < email.length; i++) {
                        driver.findElement(By.xpath(locators.name)).clear();
                        driver.findElement(By.xpath(locators.name)).sendKeys(name[i]);

                }
                int[] age = age_data();
                for (int i = 0; i < email.length; i++) {
                        driver.findElement(By.xpath(locators.age)).clear();
                        driver.findElement(By.xpath(locators.age)).sendKeys(String.valueOf(age[i]));

                }
                List<WebElement> gender = driver.findElements(By.xpath(
                                locators.gender));
                gender.get(0).click();
                List<WebElement> consession = driver.findElements(By.xpath(
                                locators.consession));
                consession.get(0).click();
                driver.findElements(By.xpath(locators.make_payment));

        }

        public static String[] email_data() {
                String[] data = new String[4];
                data[0] = "dd@gmail.com";
                data[1] = "dd@outlook.com";
                data[2] = "dd22@gmail.com";
                data[3] = "DD@gmail.com";

                return data;

        }

        public static String[] name_data() {
                String[] data = new String[4];
                data[0] = "Lura";
                data[1] = "lura";
                data[2] = "LURA";
                data[3] = "lura's";

                return data;

        }

        public static int[] age_data() {
                int[] data = new int[4];
                int min = 12;
                int max = 100;
                for (int i = 0; i < 4; i++) {
                        data[i] = (int) (Math.random() * (max - min + 1) + min);
                }

                return data;

        }
}
