package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowSearch extends WindowBase {

    public WindowSearch(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-id='modalSidetraySearch']")
    private WebElement window;

    @Step("Проверяем появление окна 'Search'")
    public boolean isVisibly() {

        return wait.until(ExpectedConditions.visibilityOf(window)).isDisplayed();
    }
}
