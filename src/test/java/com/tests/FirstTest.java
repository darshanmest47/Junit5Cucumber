package com.tests;

import java.util.Map;

import static com.tests.BaseTest.excelLoader;
import static com.tests.BaseTest.getValueFromKey;

public class FirstTest  {
    public static void main(String[] args) {
        Map<String, String> value = excelLoader.getRowDataBySheet("Sheet1");
        System.out.println(value.get("UserName"));
        System.out.println(value.get("Password"));
        System.out.println(getValueFromKey("broWser"));
    }
}
