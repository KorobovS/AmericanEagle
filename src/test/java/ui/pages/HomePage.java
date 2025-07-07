package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//a[@data-text='Men']")
//    private WebElement menLink;

    public MenPage menLinkClick() {
        driver.findElement(By.xpath("//a[@data-text='Men']")).click();
        return new MenPage(driver);
    }
}
