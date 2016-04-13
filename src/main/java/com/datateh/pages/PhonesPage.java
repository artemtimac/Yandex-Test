package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class PhonesPage extends Page
{
    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "advanced search" :
                $(withText("Расширенный поиск")).click();
                phonesSearchPage = page(PhonesSearchPage.class);
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
