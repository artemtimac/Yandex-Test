package com.datateh.pages;

/**
 * Created by atugushev on 07.04.2016.
 */
import com.codeborne.selenide.Screenshots;
import ru.yandex.qatools.allure.annotations.Attachment;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;

public abstract class Page
{
    public static HomePage homePage;
    public static MarketPage marketPage;
    public static PhonesPage phonesPage;
    public static PhonesSearchPage phonesSearchPage;
    public static PhonePage phonePage;

    @Attachment(value = "{0}", type = "text/plain")
    public static String printToAllure(String attachName, String message)
    {
        System.out.println(message);
        return message;
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] imageToAllure(String attachName) throws IOException
    {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}
