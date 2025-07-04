package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopPanel extends BasePage {

    public TopPanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search-cta")
    private WebElement searchIcon;

    @FindBy(xpath = "//a[@class='clickable qa-show-sidetray-account sidetray-account']/..")
    private WebElement accountIcon;

    @FindBy(id = "ember3")
    private WebElement favoritesIcon;

    @FindBy(id = "ember4")
    private WebElement cartIcon;

    public void searchIconClick() {
        searchIcon.click();
    }

    public void accountIconClick() {
        accountIcon.click();
    }

    public void favoritesIconClick() {
        favoritesIcon.click();
    }

    public void cartIconClick() {
        cartIcon.click();
    }
}

