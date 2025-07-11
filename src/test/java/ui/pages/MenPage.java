package ui.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MenPage extends BasePage {

    public MenPage(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(xpath = "//div[@data-testid='product-content']/div/div/div/a[@data-testid='xm-link']/div[@class='product-tile-image-container']/.."))
//    @FindAll(@FindBy(xpath = "//div[@data-testid='product-content']/div/div/div/a"))
    private List<WebElement> listProduct;

    @Step("Кликаю по первому товару")
    public ProductPage productFirstClick() {

        menLinkClick();
        Allure.step("0");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Allure.step("1");
        JavascriptExecutor js = (JavascriptExecutor) driver;
                Allure.step("1.1");
                WebElement element = listProduct.get(0);
        Allure.step("2");
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Allure.step("3");
        js.executeScript("arguments[0].click();", listProduct.get(0));

        return new ProductPage(driver);
    }

    @Step("Кликаю по товару под номером {numberInProductArray}")
    public ProductPage productClick(int numberInProductArray) {

        Allure.step("4");
        menLinkClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Allure.step("5");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Allure.step("6");
        js.executeScript("arguments[0].scrollIntoView(true);", listProduct);
        Allure.step("7");
        List<WebElement> products = driver.findElements(By.xpath("//div[@data-testid='product-content']/div/div/div/a[@data-testid='xm-link']/div[@class='product-tile-image-container']/.."));
        Allure.step("8");
        WebElement product = products.get(numberInProductArray);
        Allure.step("9");
        product.click();

        return new ProductPage(driver);
    }
}
