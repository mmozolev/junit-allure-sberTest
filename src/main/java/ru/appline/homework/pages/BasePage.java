package ru.appline.homework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.homework.managers.DriverManager;
import ru.appline.homework.managers.PageManager;
import ru.appline.homework.utils.Parser;


import java.util.List;

import static ru.appline.homework.managers.DriverManager.getWebDriver;

public class BasePage {

    protected PageManager app = PageManager.getPageManager();

    protected Actions action = new Actions(getWebDriver());

    protected JavascriptExecutor js = (JavascriptExecutor) getWebDriver();

    protected WebDriverWait wait = new WebDriverWait(getWebDriver(), 10, 1000);

    public BasePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    protected WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement elementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillInputField(WebElement field, String value) {
        scrollWithOffset(field, 0, -400);
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(value);
    }

    public void chooseField(WebElement field, List<WebElement> dropDownList, String value) {
        action.moveToElement(field).click().build().perform();
        for (WebElement element : dropDownList) {
            if (element.getText().equalsIgnoreCase(value)) {
                action.moveToElement(element).click().build().perform();
            }
        }
    }

    public void switchOption(WebElement option, boolean flag) {
        WebElement switcher = option.findElement(By.xpath("./../..//input"));
        scrollWithOffset(switcher, 0, -400);
        if (Boolean.parseBoolean(switcher.getAttribute("aria-checked")) != flag) {
            wait.until(ExpectedConditions.visibilityOf(switcher)).click();
        }

    }

    public void checkField(WebElement element, String value, String name) {
        scrollWithOffset(element, 0, -400);
        System.out.println(element.getAttribute("innerText"));
        System.out.println(Parser.parse(element.getText()));
        System.out.println(value);
        //String elementInt = Parser.parseToInt(element.getAttribute("innerText"));
       // int valueInt = Parser.parseToInt(value);
        Assertions.assertEquals(Parser.parse(element.getAttribute("innerText")),
                value, "Не совпадает значения у показателя " + name);
    }

    public void fillDateField(WebElement field, String value) {
        scrollToElementJs(field);
        field.sendKeys(value);
    }

    public void scrollWithOffset(WebElement element, int x, int y) {
        String code = "window.scroll(" + (element.getLocation().x + x) + ","
                + (element.getLocation().y + y) + ");";
        js.executeScript(code, element, x, y);
    }
}
