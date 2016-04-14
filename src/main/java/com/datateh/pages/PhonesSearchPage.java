package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

public class PhonesSearchPage extends Page
{
    private String firstPhoneName;
    private int page = 1;

    private void openPage(int number)
    {
        switch (number)
        {
            case 2:
                $(byXpath("//a[contains(@href,'page=2')]")).click();
                break;
            case 3:
                $(byXpath("//a[contains(@href,'page=3')]")).click();
                break;
            default :
                System.out.println("Page with this number doesn't exist!");
                break;
        }
    }

    private void printCount(String text)
    {
        $(byText("Применить")).click();
        String counterText = $(withText("модел")).shouldBe(visible).getText();
        int phones = Integer.parseInt(counterText.substring(0, counterText.indexOf(" ")));
        System.out.println(phones + text);
    }

    public void fillForm()
    {
        $(byId("gf-pricefrom-var")).shouldBe(visible).setValue("35000");
        $(withText("Диагональ экрана")).click();
        $(byId("gf-2142557926-from")).setValue("3");
        printCount(" phones from 35000 rub and from 3 inches");
        $(byText("Apple")).click();
        printCount(" of them - Apple phones");
    }

    public void sortBy(String filter)
    {
        firstPhoneName = $(byValue("snippet-card__header-text")).shouldBe(visible).getText();
        switch (filter.toLowerCase())
        {
            case "novelty" :
                $(byText("по новизне")).click();
                sleep(1500);
                break;
            default :
                System.out.println("Filter doesn't exist!");
                break;
        }
    }

    public void openMostPopular()
    {
        try
        {
            $(byTitle(firstPhoneName)).click();
            System.out.println(firstPhoneName + " is most popular");
            phonePage = page(PhonePage.class);
        }
        catch (Exception e)
        {
            page++;
            openPage(page);
            openMostPopular();
        }
    }
}