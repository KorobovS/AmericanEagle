package ui.tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.CartPage;
import ui.pages.HomePage;
import ui.utils.BaseTest;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static ui.utils.TestDate.productOnCart;
import static ui.utils.TestDate.productOnDisplay;

@Owner("KorobovS")
@Feature("UI")
public class CrudProductToCartTest extends BaseTest {

    @Test
    @Description("Добавляю товар в корзину и проверяю соответствие характеристик товара на витрине и в корзине")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testAddProductToCart() {

        Allure.step("Добавляю товар в корзину");
        CartPage cartPage = new HomePage(getDriver())
                .menLinkClick()
                .productClick(1)
                .canselNotifyMe()
                .sizeFirstClick()
                .addToBagButtonClick()
                .goToCartPage();

        Allure.step("Проверяю актуальный Н1");
        Assert.assertEquals(cartPage.getH1(), "Shopping Bag");
        Allure.step("Проверяю характеристики товара на ветрине и в корзине");
        Assert.assertEquals(productOnDisplay, productOnCart);
    }

    @Test
    @Description("Обновляю данные о товаре в корзине")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testUpdateProductToCart() {

        Allure.step("Обновляю данные о товаре в корзине");
        CartPage cartPage = new HomePage(getDriver())
                .addProductToCart(1)
                .goToCart()
                .clickLinkEdit()
                .updateColor()
                .updateSize()
                .updateQuantity()
                .clickButtonUpdateBag();

        Allure.step("Проверяю актуальный Н1");
        Assert.assertEquals(cartPage.getH1(), "Shopping Bag");
        Allure.step("Проверяю изменение характеристик товара после обновления");
        Assert.assertNotEquals(productOnDisplay, productOnCart);
    }

    @Test
    @Description("Удаляю товар из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testDeleteProductToCart() {

        Allure.step("Удаляю товар из корзины");
        String actualH1 = new HomePage(getDriver())
                .addProductToCart(1)
                .goToCart()
                .clickLinkRemove()
                .getH1();

        Allure.step("Проверяю актуальный Н1");
        Assert.assertEquals(actualH1, "Shopping Bag");
    }

    @Test
    @Description("Ложу 2 товара в корзину, изменяю у одного товара количество и удаляю другой товар из корзины")
    @Severity(CRITICAL)
    @Tag("EndToEnd")
    public void testCRUDCart() {

        Allure.step("Взаимодействие с товарами в корзине");
        CartPage cartPage = new HomePage(getDriver())
                .addProductToCart(1)
                .addProductToCart(2)
                .goToCart()
                .updateProductToCart(2)
                .removeProductToCart(1);

        Allure.step("Проверяю актуальный Н1");
        Assert.assertEquals(cartPage.getH1(), "Shopping Bag");
        Allure.step("Проверяю количество товаров в корзине");
        Assert.assertEquals(cartPage.getArrayProduct().size(), 1);
    }
}
