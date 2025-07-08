package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenPage extends BasePage {

    public MenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-testid='product-content']/div/div/div/a")
    private WebElement productFirst;

    @Step("Кликаю по первому товару")
    public ProductPage productFirstClick() {

        menLinkClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(productFirst));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", productFirst);
        productFirst.click();

        return new ProductPage(driver);
    }
}
