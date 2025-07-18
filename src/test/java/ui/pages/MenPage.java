package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MenPage extends BasePage {

    public MenPage(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(xpath = "//div[@data-testid='product-content']/div/div/div/a[@data-testid='xm-link']/div[@class='product-tile-image-container']/.."))
    private List<WebElement> listProducts;

    @FindBy(xpath = "//div[@data-testid='product-content']/div/div/div/a")
    private WebElement element;

    @Step("Кликаю по товару под номером {numberInProductArray}")
    public ProductPage productClick(int numberInProductArray) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement product = listProducts.get(numberInProductArray);
        js.executeScript("arguments[0].scrollIntoView(true);", product);
        product.click();

        return new ProductPage(driver);
    }
}
