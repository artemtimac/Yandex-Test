package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.support.*;

public class Apple5sPage extends Page
{
    @CacheLookup
    @FindBy(xpath = "//*[@class='product-card__offer']//*[@data-rate]")
    private SelenideElement phoneRating;

    public int getRating()
    {
        int rating = Integer.parseInt(phoneRating.shouldBe(visible).attr("data-rate"));
        System.out.println("Rating: " + rating);
        return rating;
    }
}
