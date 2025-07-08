package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search-cta")
    private WebElement searchIcon;

    @FindBy(xpath = "//a[@class='clickable qa-show-sidetray-account sidetray-account']/..")
    private WebElement accountIcon;

    @FindBy(id = "ember3")
    private WebElement favoritesIcon;

    @FindBy(id = "ember4")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[@data-text='Men']")
    private WebElement menLink;

    @FindBy(xpath = "//div[@class='modal-body']")
    private WebElement modal;

    @Step("Кликаю ссылку Men")
    public MenPage menLinkClick() {
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Кликаю иконку поиска")
    public void searchIconClick() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
    }

    @Step("Кликаю иконку аккаунта")
    public void accountIconClick() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(accountIcon)).click();
    }

    @Step("Кликаю иконку понравившееся")
    public void favoritesIconClick() {
        favoritesIcon.click();
    }

    @Step("Кликаю иконку корзины")
    public void cartIconClick() {
        cartIcon.click();
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
