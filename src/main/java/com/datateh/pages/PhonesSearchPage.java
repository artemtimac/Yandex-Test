package com.datateh.pages;
/**
 * Created by atugushev on 07.04.2016.
 */
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.support.*;

public class PhonesSearchPage extends Page
{
    //region WebElements
    @CacheLookup
    @FindBy(xpath = "//*[contains(text(),'Диагональ')]")
    private SelenideElement diagonalForm;
    @CacheLookup
    @FindBy(id = "gf-pricefrom-var")
    private SelenideElement priceFrom;
    @CacheLookup
    @FindBy(id = "gf-2142557926-from")
    private SelenideElement diagonalFrom;
    @CacheLookup
    @FindBy(id = "gf-1801946-1871375")
    private SelenideElement appleBox;
    @CacheLookup
    @FindBy(xpath = "//*[contains(@class,'button_action_filter-apply')]")
    private SelenideElement applyButton;
    @CacheLookup
    @FindBy(xpath = "//*[contains(@class,'filter-panel-counter')]")
    private SelenideElement counter;
    @CacheLookup
    @FindBy(xpath = "//*[span[text()='Apple iPhone 5S 16Gb']]")
    private SelenideElement apple5s;
    @CacheLookup
    @FindBy(xpath = "//*[text()='по новизне']")
    private SelenideElement byNovelty;
    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'page=2')]")
    private SelenideElement pageTwo;
    //endregion

    private void printCount(SelenideElement counter, String text)
    {
        String counterText = counter.shouldBe(visible).getText();
        int phones = Integer.parseInt(counterText.substring(0, counterText.indexOf(" ")));
        System.out.println(phones + text);
    }
    public void fillForm()
    {
        priceFrom.setValue("35000");
        diagonalForm.click();
        diagonalFrom.setValue("3");

        printCount(counter, " phones from 35000 rub and from 3 inches");
        $(byText("Apple")).click();

        printCount(counter, " of them - Apple phones");
    }
    public void sortBy(String filter) throws Exception
    {
        switch (filter.toLowerCase())
        {
            case "novelty" :
                byNovelty.click();
                Thread.sleep(3000);
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
                apple5s.click();
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
                pageTwo.shouldBe(visible).click();
                break;
            default :
                System.out.println("Page with this number doesn't exist!");
                break;
        }
    }
}