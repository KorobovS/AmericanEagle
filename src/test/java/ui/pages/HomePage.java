package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

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
        this.cartIconClick();

        return new CartPage(driver);
    }
}
