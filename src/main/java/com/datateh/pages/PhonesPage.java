package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.support.*;

public class PhonesPage extends Page
{
    @CacheLookup
    @FindBy(xpath = "//*[contains(text(),'Расширенный поиск')]")
    private SelenideElement advancedSearch;

    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "advanced search" :
                advancedSearch.click();
                phonesSearchPage = page(PhonesSearchPage.class);
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
