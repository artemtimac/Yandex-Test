package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

public class PhonesSearchPage extends Page
{
    private void printCount(String text)
    {
        $(byText("Применить")).click();
        String counterText = $(byXpath("//*[contains(@class,'filter-panel-counter')]")).shouldBe(visible).getText();
        int phones = Integer.parseInt(counterText.substring(0, counterText.indexOf(" ")));
        System.out.println(phones + text);
    }
    public void fillForm()
    {
        $(byName("gf-pricefrom-var")).shouldBe(appears).setValue("35000");
        $(withText("Диагональ экрана")).click();
        $(byName("gf-2142557926-from")).setValue("3");
        printCount(" phones from 35000 rub and from 3 inches");
        $(byText("Apple")).click();
        printCount(" of them - Apple phones");
    }
    public void sortBy(String filter)
    {
        switch (filter.toLowerCase())
        {
            case "novelty" :
                $(byText("по новизне")).click();
                sleep(2000);
                break;
            default :
                System.out.println("Filter doesn't exist!");
                break;
        }
    }
    public void openPhone(String phone)
    {
        switch (phone.toLowerCase())
        {
            case "apple iphone 5s 16gb" :
                $(byText(phone)).click();
                apple5sPage = page(Apple5sPage.class);
                break;
            default :
                System.out.println("Phone not found!");
                break;
        }
    }
    public void openPage(String number)
    {
        switch (number)
        {
            case "2" :
                $(byXpath("//a[contains(@href,'page=2')]")).click();
                break;
            default :
                System.out.println("Page with this number doesn't exist!");
                break;
        }
    }
}