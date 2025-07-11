package ui.tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        new HomePage(getDriver())
                .menLinkClick()
                .productFirstClick()
                .sizeFirstClick()
                .addToBagButtonClick()
                .goToCartPage();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Shopping Bag");
    }

    @Test
    @Description("Обновляю данные о товаре в корзине")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testUpdateProductToCart() {

        Allure.step("Обновляю данные о товаре в корзине");
        new HomePage(getDriver())
                .addProductToCart(1)
                .goToCart()
                .clickLinkEdit()
                .updateColor()
                .updateSize()
                .updateQuantity()
                .clickButtonUpdateBag();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Shopping Bag");
    }

    @Test
    @Description("Удаляю товар из корзины")
    @Severity(CRITICAL)
    @Tag("Smoke")
    public void testDeleteProductToCart() {

        Allure.step("Удаляю товар из корзины");
        new HomePage(getDriver())
                .addProductToCart(1)
                .goToCart()
                .clickLinkRemove();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Shopping Bag");
    }
}
