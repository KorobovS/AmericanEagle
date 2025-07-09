package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@data-testid='commerce-items']//button[@name='editCommerceItem']")
    private WebElement buttonEdit;

    @Step("Нажимаю ссылку edit в корзине")
    public CartPage clickLinkEdit() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonEdit);
        buttonEdit.click();

        return this;
    }
}
