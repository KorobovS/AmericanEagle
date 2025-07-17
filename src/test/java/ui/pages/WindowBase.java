package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowBase extends BasePage{

    public WindowBase(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2")
    private WebElement title;

    @Step("Получаю название окна")
    public String getTitle() {

        return  wait.until(ExpectedConditions.visibilityOf(title))
                .findElement(By.xpath("//h2")).getText();
    }
}
