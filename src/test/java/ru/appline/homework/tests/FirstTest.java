package ru.appline.homework.tests;

import org.junit.jupiter.api.Test;
import ru.appline.homework.baseTest.BaseTest;

public class FirstTest extends BaseTest {

    @Test
    public void test() {
        app.getStartPage()
                .selectMenu("ипотека")
                .selectSubMenu("Ипотека на готовое жильё")
                .changeValue("срок кредита", "30")
                .changeValue("Стоимость недвижимости", "5180000")
                .changeValue("Первоначальный взнос", "3058000")
                .switchOption("скидка 0,3% при покупке квартиры на домклик", false)
                .switchOption("Страхование жизни и здоровья", false)
                .switchOption("молодая семья", true)
                .switchOption("электронная регистрация сделки", false)
                .checkField("cумма кредита", "2122000")
                .checkField("Ежемесячный платеж", "16922")
                .checkField("Необходимый доход", "21784")
                .checkField("Процентная ставка", "11");
    }
}
