package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import ru.yandex.qatools.allure.annotations.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class MarketPage extends Page
{
    @Step("Open {0}")
    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "phones" :
                $(byText("Электроника")).shouldBe(visible).click();
                $(byText("Мобильные телефоны")).shouldBe(visible).click();
                phonesPage = page(PhonesPage.class);
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
