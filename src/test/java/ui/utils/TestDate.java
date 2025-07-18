package ui.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.model.Product;

public class TestDate {

    public static Product productOnDisplay;
    public static Product productOnCart;

    @Step("Получаю данные о товаре перед отправкой в корзину")
    public static Product setProductOnDisplay(WebDriver driver) {

        String color = driver.findElement(By.xpath("((//div[@class='modal-body']/div/div)[2]/div)[3]"))
                .getText()
                .replace("Color: ", "");
        String size = driver.findElement(By.xpath("((//div[@class='modal-body']/div/div)[2]/div)[4]"))
                .getText()
                .replace("Size: ", "");
        String quantity = driver.findElement(By.xpath("((//div[@class='modal-body']/div/div)[2]/div)[5]"))
                .getText()
                .replace("Qty: ", "");
        String price = driver.findElement(By.xpath("//div[contains(@class, 'text-bold')]/span"))
                .getText();

        return new Product(color, size, quantity, price);
    }

    @Step("Получаю данные о товаре находящемся в корзине")
    public static Product setProductOnCart(WebDriver driver) {

        String color = driver.findElement(By.xpath("//div[@class='cart-item-color']"))
                .getText()
                .replace("Color: ", "");
        String size = driver.findElement(By.xpath("//div[contains(@class, 'qa-cart-item-size')]"))
                .getText()
                .replace("Size: ", "");
        String quantity = driver.findElement(By.xpath("//div[contains(@class, 'cart-item-quantity')]"))
                .getText()
                .replace("Qty: ", "");
        String price = driver.findElement(By.xpath("//div[contains(@class, 'cart-item-price')]/span"))
                .getText();

        return new Product(color, size, quantity, price);
    }
}
