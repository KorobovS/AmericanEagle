package ui.tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.TopPanel;
import ui.utils.BaseTest;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
@Feature("UI")
public class TopPanelTest extends BaseTest {

    @Test
    @Description("При клике по иконке 'search' появляется окно 'Search'")
    @Severity(CRITICAL)
    @TmsLink("US-1")
    public void testSearchIcon() {

        Allure.step("Кликаем по иконке 'search'");
        new TopPanel(getDriver()).searchIconClick();

        Allure.step("Проверяем появление окна 'Search'");
        Assert.assertNotNull(getDriver().findElement(By.xpath("//div[@data-id='modalSidetraySearch']")));
    }

    @Test
    @Description("При клике по иконке 'account' появляется окно 'Account'")
    @Severity(CRITICAL)
    @TmsLink("US-1")
    public void testAccountIcon() {

        Allure.step("Кликаем по иконке 'account'");
        new TopPanel(getDriver()).accountIconClick();

        Allure.step("Проверяем появление окна 'Account'");
        Assert.assertNotNull(getDriver().findElement(By.xpath("//div[@data-id='modalSidetrayAccount']")));
    }

    @Test
    @Description("При клике по иконке 'favorites' загружается стараница 'Favorites'")
    @Severity(CRITICAL)
    @TmsLink("US-1")
    public void testFavoritesIcon() {

        Allure.step("Кликаем по иконке 'favorites'");
        new TopPanel(getDriver()).favoritesIconClick();

        Allure.step("Проверяем загрузку стараницы 'Favorites' с состветсвенным url");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.ae.com/us/en/favorites");
        Allure.step("Проверяем название стараницы 'Favorites'");
        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Favorites");
    }

    @Test
    @Description("При клике по иконке 'cart' загружается стараница 'Shopping Bag'")
    @Severity(CRITICAL)
    @TmsLink("US-1")
    public void testCartIcon() {

        Allure.step("Кликаем по иконке 'cart'");
        new TopPanel(getDriver()).cartIconClick();

        Allure.step("Проверяем название стараницы 'Shopping Bag'");
        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Shopping Bag");
        Allure.step("Проверяем загрузку стараницы 'Shopping Bag' с состветсвенным url");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.ae.com/us/en/cart");
    }
}
