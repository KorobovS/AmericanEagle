package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ui.utils.TestDate.*;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@role='menu']/li/a")
    private WebElement sizeFirst;

    @FindBy(xpath = "//button[@name='addToBag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div[@aria-label='Size']/span[@class='dropdown-text']")
    private WebElement sizes;

    @FindBy(xpath = "//div[@class='modal-dialog']//button[@name='viewBag']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//div[@class='modal-dialog']//button[@class='btn-close sidetray-close-button qa-btn-cancel']")
    private WebElement closeModal;

    @FindBy(xpath = "//div[@class='modal-body']")
    private WebElement modal;

    @FindBy(xpath = "//div[@class='modal-dialog']")
    private WebElement modalWindow;

    @FindBy(xpath = "//div[contains(@class, 'cart-item-info-container')]")
    private WebElement productInCart;

    @FindBy(xpath = "//button[contains(@class, 'qa-btn-cancel')]")
    private WebElement canselButton;

    @Step("Кликаю по первому размеру")
    public ProductPage sizeFirstClick() {

        wait.until(ExpectedConditions.elementToBeClickable(sizes));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", sizes);
//        wait.until(ExpectedConditions.elementToBeClickable(sizes)).click();
        js.executeScript("arguments[0].click();", sizes);
        wait.until(ExpectedConditions.elementToBeClickable(sizeFirst)).click();

        return new ProductPage(driver);
    }

    @Step("Кликаю по кнопке добавить в корзину")
    public ProductPage addToBagButtonClick() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addToBagButton);
        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton)).click();
        wait.until(ExpectedConditions.visibilityOf(modalWindow));

        productOnDisplay = setProductOnDisplay(driver);

        return new ProductPage(driver);
    }

    @Step("Перехожу в корзину")
    public CartPage goToCartPage() {

        wait.until(ExpectedConditions.elementToBeClickable(modal));
        wait.until(ExpectedConditions.elementToBeClickable(viewBagButton)).click();
        wait.until(ExpectedConditions.visibilityOf(productInCart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", productInCart);

        productOnCart = setProductOnCart(driver);

        return new CartPage(driver);
    }

    @Step("Закрываю окно Added to bag!")
    public ProductPage closeModal() {

        wait.until(ExpectedConditions.elementToBeClickable(modal));
        wait.until(ExpectedConditions.elementToBeClickable(closeModal)).click();

        return this;
    }

    @Step("Закрыть окно 'оповещение о появлении твого размера'")
    public ProductPage canselNotifyMe() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(canselButton)).click();
        } catch (Exception ignored) {

        } finally {
            return new ProductPage(driver);
        }
    }
}
