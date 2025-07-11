package ui.tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.CartPage;
import ui.pages.HomePage;
import ui.utils.BaseTest;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("KorobovS")
@Feature("UI")
public class CrudProductToCartTest extends BaseTest {

    @Test
    @Description("Добавляю товар в корзину")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testAddProductToCart() {

        Allure.step("Добавляю товар в корзину");
        String actualH1 = new HomePage(getDriver())
                .menLinkClick()
                .productClick(1)
                .sizeFirstClick()
                .addToBagButtonClick()
                .goToCartPage()
                .getH1();

        Allure.step("Проверяю актуальный Н1");
        Assert.assertEquals(actualH1, "Shopping Bag");
    }

    @Test
    @Description("Обновляю данные о товаре в корзине")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testUpdateProductToCart() {

        Allure.step("Обновляю данные о товаре в корзине");
        String actualH1 = new HomePage(getDriver())
                .addProductToCart(1)
                .goToCart()
                .clickLinkEdit()
                .updateColor()
                .updateSize()
                .updateQuantity()
                .clickButtonUpdateBag()
                .getH1();

        Allure.step("Проверяю актуальный Н1");
        Assert.assertEquals(actualH1, "Shopping Bag");
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
