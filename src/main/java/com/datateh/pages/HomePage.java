package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

public class HomePage extends Page
{
    private final static String URL = "http://yandex.ru";

    public static void open()
    {
        homePage = Selenide.open(URL, HomePage.class);
    }
    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "market":
                $(byText("Маркет")).shouldBe(visible).click();
                marketPage = page(MarketPage.class);
                break;
            default:
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
