package com.datateh.pages;

/**
 * Created by atugushev on 07.04.2016.
 */
import ru.yandex.qatools.allure.annotations.Attachment;

public abstract class Page
{
    public static HomePage homePage;
    public static MarketPage marketPage;
    public static PhonesPage phonesPage;
    public static PhonesSearchPage phonesSearchPage;
    public static PhonePage phonePage;

    @Attachment(type = "text/plain")
    public String printToAllure(String message)
    {
        return message;
    }
}
