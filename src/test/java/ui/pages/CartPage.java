package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='editCommerceItem']")
    private WebElement linkEdit;

    @FindBy(xpath = "//button[@name='removeCommerceItem']")
    private WebElement linkRemove;

    @FindBy(xpath = "//div[@class='extras-content']//div[@role='button']")
    private WebElement color;

    @FindBy(xpath = "//div[@aria-label='Size']/span")
    private WebElement size;

    @FindBy(xpath = "//button[@aria-label='increase']")
    private WebElement plus;

    @FindBy(xpath = "//button[text()='Update Bag']")
    private WebElement buttonUpdateBag;

    @FindAll(@FindBy(xpath = "//ul[@data-testid='commerce-items']/li"))
    private List<WebElement> arrayProduct;

    @Step("Нажимаю ссылку edit в корзине")
    public CartPage clickLinkEdit() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", linkEdit);
        linkEdit.click();

        return this;
    }

    @Step("Нажимаю ссылку remove в корзине")
    public CartPage clickLinkRemove() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", linkRemove);
        linkRemove.click();

        return this;
    }

    @Step("Меняю цвет продукта в корзине")
    public CartPage updateColor() {

        updateField(color, "//div[@class='extras-content']//div[@role='button']");

        return this;
    }

    @Step("Меняю размер продукта в корзине")
    public CartPage updateSize() {

        wait.until(ExpectedConditions.elementToBeClickable(size));
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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(field));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", field);
        List<WebElement> listColor = driver.findElements(By.xpath(location));
        if (listColor.size() > 1) {
            listColor.get(1).click();
        }
    }

    @Step("Обновляю {numberProductToCart} продукт в корзине")
    public CartPage updateProductToCart(int numberProductToCart) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement product = driver.findElement(By.xpath(String.format("(//ul[@data-testid='commerce-items']/li//button[@name='editCommerceItem'])[%s]", numberProductToCart)));
        js.executeScript("arguments[0].scrollIntoView(true);", product);
        product.click();
        updateColor();
        updateSize();
        updateQuantity();
        clickButtonUpdateBag();

        return this;
    }

    @Step("Удаляю {numberProductToCart} продукт в корзине")
    public CartPage removeProductToCart(int numberProductToCart) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        WebElement product = driver.findElement(By.xpath(String.format("(//ul[@data-testid='commerce-items']/li//button[@name='removeCommerceItem'])[%s]", numberProductToCart)));
        js.executeScript("arguments[0].scrollIntoView(true);", product);
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
        js.executeScript("window.scrollTo(0, 0)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    @Step("Получаю список продуктов из корзины")
    public List<WebElement> getArrayProduct() {

        wait.until(ExpectedConditions.visibilityOfAllElements(arrayProduct));

        return arrayProduct;
    }
}
