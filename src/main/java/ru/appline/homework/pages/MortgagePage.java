package ru.appline.homework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.homework.managers.DriverManager;
import ru.appline.homework.utils.MyAllureListener;

import java.util.List;

public class MortgagePage extends BasePage {

    @FindBy(xpath = "//div[text()='Цель кредита']/..//input")
    WebElement creditPurpose;

    @FindBy(xpath = "//div[text()='Стоимость недвижимости']/..//input")
    WebElement propertyValue;

    @FindBy(xpath = "//div[text()='Первоначальный взнос']/..//input")
    WebElement initialFee;

    @FindBy(xpath = "//div[text()='Срок кредита']/..//input")
    WebElement creditTerm;

    @FindBy(xpath = "//span[@class='dropdown-title-4-0-10']")
    List<WebElement> dropDownList;

    @FindBy(xpath = "//span[text()='Скидка 0,3% при покупке квартиры на ДомКлик']")
    WebElement DomClick;

    @FindBy(xpath = "//span[text()='Страхование жизни и здоровья']")
    WebElement lifeInsurance;

    @FindBy(xpath = "//span[text()='Молодая семья']")
    WebElement youngFamily;

    @FindBy(xpath = "//span[text()='Электронная регистрация сделки']")
    WebElement digitalRegister;

    @FindBy(xpath = "//span[@class='_1ZfZYgvLm4KBWPL41DOSO']")
    List<WebElement> switchers;

    @FindBy(xpath = "//span[text()='Сумма кредита']/..//span[contains(@data-e2e-id, 'mland-calculator/mobile')]//span")
    WebElement creditAmount;

    @FindBy(xpath = "//span[text()='Ежемесячный платеж']/..//span[contains(@data-e2e-id, 'mland-calculator/mobile')]//span")
    WebElement monthlyPayment;

    @FindBy(xpath = "//span[text()='Необходимый доход']/..//span[contains(@data-e2e-id, 'mland-calculator/mobile')]//span")
    WebElement requiredIncome;

    @FindBy(xpath = "//span[text()='Процентная ставка']/..//span[contains(@data-e2e-id, 'mland-calculator/mobile')]//span")
    WebElement interestRate;

    @FindBy(xpath = "//h2[contains(text(), 'Рассчитайте ипотеку')]")
    WebElement calcHeader;

    @Step("Изменить значение {element} на {value}")
    public MortgagePage changeValue(String element, String value) {
        DriverManager.getWebDriver().switchTo().frame("iFrameResizer0");
        switch (element.toLowerCase()) {
            case ("цель кредита"):
                chooseField(creditPurpose, dropDownList, value);
                break;

            case ("стоимость недвижимости"):
                fillInputField(propertyValue, value);
                break;

            case ("первоначальный взнос"):
                fillInputField(initialFee, value);
                break;

            case ("срок кредита"):
                fillInputField(creditTerm, value);
                break;

            default:
                Assertions.fail("Параметра " + element + " нет на странице");
        }
        DriverManager.getWebDriver().switchTo().parentFrame();
        return this;
    }

    @Step("Переключение опции {element}")
    public MortgagePage switchOption(String element, boolean flag) {
        DriverManager.getWebDriver().switchTo().frame("iFrameResizer0");
        switch (element.toLowerCase()) {
            case ("скидка 0,3% при покупке квартиры на домклик"):
                switchOption(DomClick, flag);
                break;

            case ("страхование жизни и здоровья"):
                switchOption(lifeInsurance, flag);
                break;

            case ("молодая семья"):
                switchOption(youngFamily, flag);
                break;

            case ("электронная регистрация сделки"):
                switchOption(digitalRegister, flag);
                break;

            default:
                MyAllureListener.addScreenshot();
                Assertions.fail("Опции " + element + " нет на странице");
        }
        DriverManager.getWebDriver().switchTo().parentFrame();
        return this;
    }

    @Step("Проверка поля {name}")
    public MortgagePage checkField(String name, String value) {
        scrollToElementJs(calcHeader);
        DriverManager.getWebDriver().switchTo().frame("iFrameResizer0");
        switch (name.toLowerCase()) {
            case ("cумма кредита"):
                checkField(creditAmount, value, name);
                break;

            case ("ежемесячный платеж"):
                checkField(monthlyPayment, value, name);
                break;

            case ("необходимый доход"):
                checkField(requiredIncome, value, name);
                break;

            case ("процентная ставка"):
                checkField(interestRate, value, name);
                break;

            default:
                Assertions.fail("Показатель " + name + " отсутствует на странице");
        }
                DriverManager.getWebDriver().switchTo().parentFrame();
                return this;
        }
    }
