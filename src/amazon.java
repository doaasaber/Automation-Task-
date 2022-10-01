import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon {

        public static void add_item(WebDriver driver) {
                driver.get("https://www.amazon.com/");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(locators.search_bar)));
                driver.findElement(By.xpath(locators.search_bar))
                                .sendKeys("car accessories");
                driver.findElement(
                                By.xpath(locators.search_button))
                                .click();
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(locators.first_item)));
                driver.findElement(By.xpath(locators.first_item))
                                .click();

                WebElement element = driver.findElement(By.id("productTitle"));
                String item_name = element.getText();
                driver.findElement(By.xpath(locators.cart))
                                .click();
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(
                                                locators.go_to_cart_button)));
                driver.findElement(By.xpath(locators.go_to_cart_button)).click();
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(
                                                locators.shopping_cart_title)));
                element = driver.findElement(By.xpath(
                                locators.check_title));
                String title = element.getText();
                assert item_name.contains(title);

        }

        public static void select_item(WebDriver driver) throws InterruptedException {
                driver.get("https://www.amazon.com/");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(
                                                locators.address)));
                driver.findElement(By.xpath(locators.address)).click();
                driver.findElement(By.xpath(locators.todays_deals)).click();
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(
                                                locators.today_deals_title)));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,1000)");
                driver.findElement(By.xpath(locators.grocery)).click();
                driver.findElement(By.xpath(locators.headphone)).click();
                js.executeScript("window.scrollBy(0,1000)");
                Thread.sleep(5000);
                driver.findElement(By.xpath(locators.discount)).click();
                js.executeScript("window.scrollBy(0,12000)");
                Thread.sleep(5000);
                driver.findElement(By.xpath(locators.third_page)).click();
                Thread.sleep(5000);

                js.executeScript("window.scrollBy(0,15000)");
                Thread.sleep(5000);

                driver.findElement(By.xpath(locators.fourth_page)).click();

                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(
                                                locators.item2)));
                driver.findElement(By.xpath(locators.item2)).click();
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath(
                                                locators.add_to_cart)));
                driver.findElement(By.xpath(locators.add_to_cart)).click();
        }

}
