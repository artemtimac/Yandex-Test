package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import ru.yandex.qatools.allure.annotations.*;

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
        String counter = $(withText("модел")).shouldBe(visible).getText();
        int phones = Integer.parseInt(counter.substring(0, counter.indexOf(" ")));
        printToAllure("Number of phones", phones + text);
    }

    private void rememberFirstPhoneName()
    {
        firstPhoneName = $(by("class", "snippet-card__header-text")).shouldBe(visible).getText();;
    }

    @Step
    public void fillForm()
    {
        $(byId("gf-pricefrom-var")).sendKeys("35000");
        $(withText("Диагональ экрана")).click();
        $(byId("gf-2142557926-from")).sendKeys("3");
        printCount(" phones from 35000 rub and from 3 inches");
        $(byText("Apple")).click();
        printCount(" of them - Apple phones");
        rememberFirstPhoneName();
    }

    @Step("Sort By {0}")
    public void sortBy(String filter)
    {
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

    @Step
    public void findMostPopular()
    {
        try
        {
            if ($(byTitle(firstPhoneName)).isDisplayed())
            {
                $(byTitle(firstPhoneName)).click();
                printToAllure("Most popular phone", firstPhoneName + " is most popular");
                phonePage = page(PhonePage.class);
            }
            else { throw new Exception(); }
        }
        catch (Exception e)
        {
            openPage(++page);
            sleep(1500);
            findMostPopular();
        }
    }
}