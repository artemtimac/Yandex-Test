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
    static int phonesCount;
    static int appleCount;
    static int rating;

    @Test
    public void scenario() throws Exception {
        open("http://yandex.ru");
        $(byText("Маркет")).click();
        $(byText("Электроника")).click();
        $(byText("Мобильные телефоны")).click();
        $(byXpath("//*[contains(text(),'Расширенный поиск')]")).click();
        $(byName("gf-pricefrom-var")).setValue("35000"); // set price
        $(byXpath("//*[contains(text(),'Диагональ экрана')]")).click();
        $(byName("gf-2142557926-from")).setValue("3"); // set diagonal
        $(byXpath("//*[span[text()='Применить']]")).click();

        String text = $(byXpath("//*[contains(@class,'filter-panel-counter')]")).shouldBe(visible).text();
        phonesCount = Integer.parseInt(text.substring(0, text.indexOf(" ")));
        System.out.printf("%d моделей от 35000 рублей от 3 дюймов" + '\n', phonesCount);

        $(byText("Apple")).click();
        $(byXpath("//*[span[text()='Применить']]")).shouldBe(visible).click();

        text = $(byXpath("//*[contains(@class,'filter-panel-counter')]")).shouldBe(visible).text();
        appleCount = Integer.parseInt(text.substring(0, text.indexOf(" ")));
        System.out.printf("%d из них Apple" + '\n', appleCount);

        $(byText("по новизне")).click();
        click("Apple iPhone 5S 16Gb");

        text = $(byXpath("//*[@class='product-card__offer']//*[@data-rate]")).attr("data-rate"); // get rating
        rating = Integer.parseInt(text);
        System.out.printf("Оценка: %d" + '\n', rating);
    }

    private void click(String text){
        try { $(byText(text)).click(); } // try to find our first element and click
        catch (Exception e)
        {
            // if our element was not found - open next page and back to searching our element
            $(byXpath("//*[span[text()='2']]")).shouldBe(visible).click();
            click(text);
        }
    }
}