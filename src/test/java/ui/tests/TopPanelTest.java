package ui.tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.*;
import ui.utils.BaseTest;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
@Feature("UI")
public class TopPanelTest extends BaseTest {

    @Test
    @Description("При клике по иконке 'Search' появляется окно 'Search'")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testSearchIcon() {

        WindowSearch windowSearch = new HomePage(getDriver()).searchIconClick();

        Allure.step("Проверяем появление окна 'Search'");
        Assert.assertTrue(windowSearch.isVisibly());
        Allure.step("Проверяем название окна 'Search");
        Assert.assertEquals(windowSearch.getTitle(), "Search");
    }

    @Test
    @Description("При клике по иконке 'Account' появляется окно 'Account'")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testAccountIcon() {

        WindowAccount windowAccount = new HomePage(getDriver()).accountIconClick();

        Allure.step("Проверяем появление окна 'Account'");
        Assert.assertTrue(windowAccount.isVisibly());
        Allure.step("Проверяем название окна");
        Assert.assertEquals(windowAccount.getTitle(), "Account");
    }

    @Test
    @Description("При клике по иконке 'Favorites' загружается стараница 'Favorites'")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testFavoritesIcon() {

        FavoritesPage favoritesPage = new HomePage(getDriver()).favoritesIconClick();

        Allure.step("Проверяем загрузку стараницы 'Favorites' с состветсвенным url");
        Assert.assertEquals(favoritesPage.getCurrentUrl(), "https://www.ae.com/us/en/favorites");
        Allure.step("Проверяем название стараницы 'Favorites'");
        Assert.assertEquals(favoritesPage.getH1(), "Favorites");
    }

    @Test
    @Description("При клике по иконке 'Cart' загружается стараница 'Shopping Bag'")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testCartIcon() {

        CartPage cartPage = new HomePage(getDriver())
                .cartIconClick();

        Allure.step("Проверяем название стараницы 'Shopping Bag'");
        Assert.assertEquals(cartPage.getH1(), "Shopping Bag");
        Allure.step("Проверяем загрузку стараницы 'Shopping Bag' с состветсвенным url");
        Assert.assertEquals(cartPage.getCurrentUrl(), "https://www.ae.com/us/en/cart");
    }
}
