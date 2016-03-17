package com.mycompany.app;
/**
 * Created by atugushev on 27.01.2016.
 */

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

import org.junit.Test;

public class YandexTest
{
    private int phonesCount;
    private int appleCount;
    private int rating;

    @Test
    public void scenario() throws Exception {
        open("http://yandex.ru");
        $(byText("Маркет")).click();
        $(byText("Электроника")).shouldBe(visible).hover();
        $(byText("Мобильные телефоны")).shouldBe(visible).click();
        $(withText("Расширенный поиск")).click();
        $(byName("gf-pricefrom-var")).setValue("35000"); // set price
        $(withText("Диагональ экрана")).click();
        $(byName("gf-2142557926-from")).setValue("3"); // set diagonal
        $(byText("Применить")).click();

        String text = $(byXpath("//*[contains(@class,'filter-panel-counter')]")).shouldBe(visible).getText();
        phonesCount = Integer.parseInt(text.substring(0, text.indexOf(" ")));
        System.out.printf("%d моделей от 35000 рублей от 3 дюймов" + '\n', phonesCount);

        $(byText("Apple")).click();
        $(byText("Применить")).shouldBe(visible).click();

        text = $(byXpath("//*[contains(@class,'filter-panel-counter')]")).shouldBe(visible).getText();
        appleCount = Integer.parseInt(text.substring(0, text.indexOf(" ")));
        System.out.printf("%d из них Apple" + '\n', appleCount);

        $(byText("по новизне")).shouldBe(visible).click();
		$(byXpath("//a[contains(@href,'page=2')]")).waitUntil(present, 5000).click();
        $(byText("Apple iPhone 5S 16Gb")).waitUntil(visible, 5000).click();

        rating = Integer.parseInt($(byXpath("//*[@class='product-card__offer']//*[@data-rate]")).attr("data-rate"));
        System.out.printf("Оценка: %d" + '\n', rating);
    }
}