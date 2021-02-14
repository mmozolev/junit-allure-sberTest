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
                //.switchOption("Страхование жизни и здоровья", false)
                .checkField("cумма кредита", "212200220");
//                .checkField("Ежемесячный платеж", "16922")
//                .checkField("Необходимый доход", "21784")
//                .checkField("Процентная ставка", "11");
    }
}
