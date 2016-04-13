package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.support.*;

public class MarketPage extends Page
{
    @CacheLookup
    @FindBy(xpath = "//*[a[text()='Электроника']]")
    private SelenideElement electronics;
    @CacheLookup
    @FindBy(xpath = "//*[text()='Мобильные телефоны']")
    private SelenideElement phones;

    public void open(String section)
    {
        switch (section.toLowerCase())
        {
            case "phones" :
                electronics.hover();
                phones.shouldBe(visible).click();
                phonesPage = page(PhonesPage.class);
                break;
            default :
                System.out.println("Section doesn't exist!");
                break;
        }
    }
}
