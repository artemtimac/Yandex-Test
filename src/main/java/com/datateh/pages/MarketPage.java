package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class MarketPage extends Page
{
    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "phones" :
                $(byText("Электроника")).waitUntil(visible, 3000).hover();
                $(byText("Мобильные телефоны")).shouldBe(visible).click();
                phonesPage = page(PhonesPage.class);
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}