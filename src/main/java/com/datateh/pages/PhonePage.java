package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import ru.yandex.qatools.allure.annotations.*;
import java.io.IOException;

public class PhonePage extends Page
{
    @Step
    public int getRating() throws IOException
    {
        int rating = Integer.parseInt($(byXpath("//*[@class='product-card__offer']//*[@data-rate]")).attr("data-rate"));
        imageToAllure("Phone");
        printToAllure("Rating", "Rating: " + rating);
        return rating;
    }
}
