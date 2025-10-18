package com.example.abstractcomponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void visibilityElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollDown() {
        if (driver instanceof JavascriptExecutor) {
            System.out.println("Driver bisa menjalankan JavaScript ");
            String script = "window.scrollBy(0, 500);";
            ((JavascriptExecutor) driver).executeScript(script);
        }
    }
}
