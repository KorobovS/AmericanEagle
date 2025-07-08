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
    @Description("Добавляем товар в корзину")
    @Severity(CRITICAL)
    @Tag("EndToEnd")
    public void testCrudToCart() {
        Allure.step("Добавляем товар в корзину");
        new HomePage(getDriver())
                .menLinkClick()
                .productFirstClick()
                .sizeFirstClick()
                .addToBagButtonClick()
                .goToCartPage();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Shopping Bag");
    }
}
