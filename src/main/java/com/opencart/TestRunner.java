package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowsName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-firefox-driver/4.9.1");
        driver.close();

        driver.switchTo().window(currentWindowsName);
        manager.getDriver().get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-edge-driver/4.9.1");
        driver.quit();

        System.out.println("The driver is closed");
    }
}
