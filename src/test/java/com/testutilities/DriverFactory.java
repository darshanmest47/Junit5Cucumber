package com.testutilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.tests.BaseTest.getValueFromKey;

public class DriverFactory {

    public static WebDriver initializeDriver(){
        ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
        if (tlDriver.get() == null) {
            if(getValueFromKey("BROWSER").equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                options.addArguments("--start-maximized", "--disable-infobars");
                tlDriver.set(new ChromeDriver(options));

            }else if(getValueFromKey("BROWSER").equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options= new FirefoxOptions();
                options.setAcceptInsecureCerts(true);
                options.addArguments("--start-maximized", "--disable-infobars");
                tlDriver.set(new FirefoxDriver(options));
            }else if(getValueFromKey("BROWSER").equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                EdgeOptions options= new EdgeOptions();
                options.setAcceptInsecureCerts(true);
                options.addArguments("--start-maximized", "--disable-infobars");
                tlDriver.set(new EdgeDriver(options));
            }else{
                System.out.println("Invalid browser");
            }

        }
        return tlDriver.get();
    }
}
