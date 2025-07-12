package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[@data-test-active-logo='aeo']/a[@data-testid='xm-link']")
    private WebElement linkCenterHomePage;

    @FindBy(xpath = "//h1")
    private WebElement h1;

    @Step("Кликаю ссылку Men")
    public MenPage menLinkClick() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(menLink)).click();
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
    public FavoritesPage favoritesIconClick() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        favoritesIcon.click();

        return new FavoritesPage(driver);
    }

    @Step("Кликаю иконку корзины")
    public CartPage cartIconClick() {

        cartIcon.click();

        return new CartPage(driver);
    }

    @Step("Перехожу на главную")
    public HomePage goToHome() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        linkCenterHomePage.click();

        return new HomePage(driver);
    }

    @Step("Получаю текст h1")
    public String getH1() {

        wait.until(ExpectedConditions.elementToBeClickable(h1));

        return h1.getText();
    }

    @Step("Получаю url страницы")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
