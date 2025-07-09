package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='top-section']")
    private WebElement topPanel;

    @Step("Добавляю в корзину товар под номером {numberInProductArray}")
    public HomePage addProductToCart(int numberInProductArray) {

        new HomePage(driver)
                .menLinkClick()
                .productClick(numberInProductArray - 1)
                .sizeFirstClick()
                .addToBagButtonClick()
                .closeModal();

        return this;
    }

    @Step("Перехожу в корзину")
    public CartPage goToCart() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.cartIconClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new CartPage(driver);
    }
}
