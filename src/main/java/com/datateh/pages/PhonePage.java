package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import ru.yandex.qatools.allure.annotations.*;

public class PhonePage extends Page
{
    @Step
    public int getRating()
    {
        int rating = Integer.parseInt($(byXpath("//*[@class='product-card__offer']//*[@data-rate]")).attr("data-rate"));
        System.out.println("Rating: " + rating);
        return rating;
    }
}
