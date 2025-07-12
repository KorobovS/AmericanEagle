package ui.tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.CartPage;
import ui.pages.FavoritesPage;
import ui.pages.HomePage;
import ui.utils.BaseTest;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
@Feature("UI")
public class TopPanelTest extends BaseTest {

    @Test
    @Description("При клике по иконке 'search' появляется окно 'Search'")
    @Severity(CRITICAL)
    public void testSearchIcon() {

        new HomePage(getDriver()).searchIconClick();

        Allure.step("Проверяем появление окна 'Search'");
        Assert.assertNotNull(getDriver().findElement(By.xpath("//div[@data-id='modalSidetraySearch']")));
    }

    @Test
    @Description("При клике по иконке 'account' появляется окно 'Account'")
    @Severity(CRITICAL)
    public void testAccountIcon() {

        new HomePage(getDriver()).accountIconClick();

        Allure.step("Проверяем появление окна 'Account'");
        Assert.assertNotNull(getDriver().findElement(By.xpath("//div[@data-id='modalSidetrayAccount']")));
    }

    @Test
    @Description("При клике по иконке 'favorites' загружается стараница 'Favorites'")
    @Severity(CRITICAL)
    public void testFavoritesIcon() {

        FavoritesPage favoritesPage = new HomePage(getDriver()).favoritesIconClick();

        Allure.step("Проверяем загрузку стараницы 'Favorites' с состветсвенным url");
        Assert.assertEquals(favoritesPage.getCurrentUrl(), "https://www.ae.com/us/en/favorites");
        Allure.step("Проверяем название стараницы 'Favorites'");
        Assert.assertEquals(favoritesPage.getH1(), "Favorites");
    }

    @Test
    @Description("При клике по иконке 'cart' загружается стараница 'Shopping Bag'")
    @Severity(CRITICAL)
    public void testCartIcon() {

        CartPage cartPage = new HomePage(getDriver())
                .cartIconClick();

        Allure.step("Проверяем название стараницы 'Shopping Bag'");
        Assert.assertEquals(cartPage.getH1(), "Shopping Bag");
        Allure.step("Проверяем загрузку стараницы 'Shopping Bag' с состветсвенным url");
        Assert.assertEquals(cartPage.getCurrentUrl(), "https://www.ae.com/us/en/cart");
    }
}
