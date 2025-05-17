package com.testutilities;

import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.tests.BaseTest.*;

import java.time.Duration;

public class WaitUtilities extends BaseTest {
    private static WebDriverWait webDriverWait = null;

    public static void waitForVisibilityOfElementInSeconds(WebElement element, int seconds) {
        /* Method overloading Duration.ofSeconds,Duration.ofMinutes*/
        webDriverWait = new WebDriverWait(getDriverStatic(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForSeconds(int milliSeconds) throws Throwable {
        Thread.sleep(milliSeconds);
    }

    public static void waitForPageLoad(String url,int seconds){
        webDriverWait = new WebDriverWait(getDriverStatic(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.urlContains(url));
    }
}
