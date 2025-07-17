package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowAccount extends WindowBase {

    public WindowAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-id='modalSidetrayAccount']")
    private WebElement window;

    @Step("Проверяем появление окна 'Account'")
    public boolean isVisibly() {

        return wait.until(ExpectedConditions.visibilityOf(window)).isDisplayed();
    }
}
