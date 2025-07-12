package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MenPage extends BasePage {

    public MenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-testid='product-content']/div/div/div/a")
    private WebElement productFirst;

    @Step("Кликаю по первому товару")
    public ProductPage productFirstClick() {

        menLinkClick();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        wait.until(ExpectedConditions.elementToBeClickable(productFirst));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", productFirst);
        js.executeScript("arguments[0].click();", productFirst);

        return new ProductPage(driver);
    }

    @Step("Кликаю по товару под номером {}")
    public ProductPage productClick(int numberInProductArray) {

        menLinkClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(productFirst));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", productFirst);
        List<WebElement> products = driver.findElements(By.xpath("//div[@data-testid='product-content']/div/div/div/a[@data-testid='xm-link']/div[@class='product-tile-image-container']/.."));
        WebElement product = products.get(numberInProductArray);
        product.click();

        return new ProductPage(driver);
    }
}
