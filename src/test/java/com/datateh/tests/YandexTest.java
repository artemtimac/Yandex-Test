package com.datateh.tests;
/**
 * Created by atugushev on 27.01.2016.
 */
import org.junit.*;
import com.datateh.pages.*;

public class YandexTest
{
    @Test
    public void testMarket() throws Exception
    {
        HomePage.open();
        Page.homePage.open("Market");
        Page.marketPage.open("Phones");
        Page.phonesPage.open("Advanced Search");
        Page.phonesSearchPage.fillForm();
        Page.phonesSearchPage.sortBy("Novelty");
        Page.phonesSearchPage.openPage("2");
        Page.phonesSearchPage.openPhone("Apple iPhone 5S 16Gb");
        Page.apple5sPage.getRating();
    }
}