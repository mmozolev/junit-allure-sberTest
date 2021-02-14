package ru.appline.homework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link') and @role='button']")
    List<WebElement> menuList;

    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link_second')]")
    List<WebElement> menuSubList;


    @Step("Выбрать в меню {name}")
    public StartPage selectMenu(String name) {
        for (WebElement element : menuList) {
            if (element.getText().equalsIgnoreCase(name)) {
                elementToBeClickable(element).click();
                return this;
            }
        }
        Assertions.fail(name + "не найдено в меню");
        return this;
    }

    @Step("Выбрать в подменю {name}")
    public MortgagePage selectSubMenu(String name) {
        for (WebElement element : menuSubList) {
            if (element.getText().equalsIgnoreCase(name)) {
                elementToBeClickable(element).click();
                return app.getMortgagePage();
            }
        }
        Assertions.fail("name " + " не найдено в подменю");
        return app.getMortgagePage();
    }

}
