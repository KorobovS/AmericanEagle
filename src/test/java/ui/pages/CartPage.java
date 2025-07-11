package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@data-testid='commerce-items']//button[@name='editCommerceItem']")
    private WebElement buttonEdit;

    @FindBy(xpath = "//div[@class='extras-content']//div[@role='button']")
    private WebElement color;

    @FindBy(xpath = "//div[@aria-label='Size']/span")
    private WebElement size;

    @FindBy(xpath = "//button[@aria-label='increase']")
    private WebElement plus;

    @FindBy(xpath = "//button[text()='Update Bag']")
    private WebElement buttonUpdateBag;

    @Step("Нажимаю ссылку edit в корзине")
    public CartPage clickLinkEdit() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonEdit);
        buttonEdit.click();

        return this;
    }

    @Step("Меняю цвет продукта в корзине")
    public CartPage updateColor() {

        updateField(color, "//div[@class='extras-content']//div[@role='button']");

        return this;
    }

    @Step("Меняю размер продукта в корзине")
    public CartPage updateSize() {

        size.click();
        updateField(size, "//ul[@role='menu']/li/a");

        return this;
    }

    @Step("Меняю количество продукта в корзине")
    public CartPage updateQuantity() {

        while (true) {
            try {
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(plus));
                button.click();
            } catch (Exception e) {
                System.out.println("Кнопка больше не активна: " + e.getMessage());
                break;
            }
        }

        return this;
    }

    @Step("Кликаю кнопку UpdateBag в корзине")
    public CartPage clickButtonUpdateBag() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonUpdateBag);
        js.executeScript("window.scrollTo(0, 0)");

        return this;
    }

    @Step("Меняю {field} продукта в корзине")
    public void updateField(WebElement field, String location) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", field);
        List<WebElement> listColor = driver.findElements(By.xpath(location));
        if (listColor.size() > 1) {
            listColor.get(1).click();
        }
    }
}
