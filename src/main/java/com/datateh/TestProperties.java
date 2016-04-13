package com.datateh;

/**
 * Created by atugushev on 11.04.2016.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestProperties
{
    private static Properties properties;

    static
    {
        properties = new Properties();
        URL url = ClassLoader.getSystemResource("test.properties");

        try
        {
            properties.load(url.openStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getTestProperty(String key) {
        return properties.getProperty(key);
    }
}
