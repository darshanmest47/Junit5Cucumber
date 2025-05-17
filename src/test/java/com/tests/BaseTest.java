package com.tests;

import Utilities.ExcelDataLoader;
import com.testutilities.PageObjects;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import static com.testutilities.DriverFactory.initializeDriver;

public class BaseTest {

    protected static ExcelDataLoader excelLoader;
    protected static Map<String, String> propertiesData = new LinkedHashMap<>();
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static PageObjects pageObjects = null;

    protected void initMethod() {
        try {
            excelLoader = ExcelDataLoader.getInstance(".\\src\\test\\java\\TestData\\TestData.xlsx");
            FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                propertiesData.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }

            tlDriver.set(initializeDriver());
            tlDriver.get().get(getValueFromKey("TESTURL"));
            pageObjects = new PageObjects(tlDriver.get());

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriverStatic() {
        return tlDriver.get();
    }

    public static void removeDriver() {
        tlDriver.remove();
    }

    public static String getValueFromKey(String key) {
        return propertiesData.get(key.toUpperCase());
    }


}
