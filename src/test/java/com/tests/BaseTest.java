package com.tests;

import Utilities.ExcelDataLoader;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import static com.testutilities.DriverFactory.initializeDriver;

public class BaseTest {

    public static ExcelDataLoader excelLoader;
    public static Map<String, String> propertiesData = new LinkedHashMap<>();

    static {
        try {
            excelLoader = ExcelDataLoader.getInstance(".\\src\\test\\java\\TestData\\TestData.xlsx");
            FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                propertiesData.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
            initializeDriver().get(getValueFromKey("TESTURL"));


        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValueFromKey(String key) {
        return propertiesData.get(key.toUpperCase());
    }


}
