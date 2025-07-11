package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@role='menu']/li/a")
    private WebElement sizeFirst;

    @FindBy(xpath = "//button[@data-test-btn='addToBag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div[@aria-label='Size']/span")
    private WebElement sizes;

    @FindBy(xpath = "//div[@class='modal-dialog']//button[@name='viewBag']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//div[@class='modal-dialog']//button[@class='btn-close sidetray-close-button qa-btn-cancel']")
    private WebElement closeModal;

    @FindBy(xpath = "//div[@class='modal-body']")
    private WebElement modal;

    @Step("Кликаю по первому размеру")
    public ProductPage sizeFirstClick() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(sizes));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", sizes);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(sizes)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(sizeFirst)).click();

        return new ProductPage(driver);
    }

    @Step("Кликаю по кнопке добавить в корзину")
    public ProductPage addToBagButtonClick() {

        addToBagButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-dialog']"))));

        return new ProductPage(driver);
    }

    @Step("Перехожу в корзину")
    public CartPage goToCartPage() {

        wait.until(ExpectedConditions.elementToBeClickable(modal));
        wait.until(ExpectedConditions.elementToBeClickable(viewBagButton)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new CartPage(driver);
    }

    @Step("Закрываю окно Added to bag!")
    public ProductPage closeModal() {

        wait.until(ExpectedConditions.elementToBeClickable(modal));
        wait.until(ExpectedConditions.elementToBeClickable(closeModal)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
}
