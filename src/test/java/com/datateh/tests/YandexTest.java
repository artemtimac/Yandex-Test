package com.datateh.tests;
/**
 * Created by atugushev on 27.01.2016.
 */
import org.junit.*;
import com.datateh.pages.*;

public class YandexTest
{
    @Before
    public void openHomePage()
    {
        HomePage.open();
    }

    @Test
    public void testMarket() throws Exception
    {
        Page.homePage.open("Market");
        Page.marketPage.open("Phones");
        Page.phonesPage.open("Advanced Search");
        Page.phonesSearchPage.fillForm();
        Page.phonesSearchPage.sortBy("Novelty");
        Page.phonesSearchPage.findMostPopular();
        Page.phonePage.getRating();
    }
}