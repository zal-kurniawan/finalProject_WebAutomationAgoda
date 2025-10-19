package com.example.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightObjectRepository {
    public FlightObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By tabFlightsQuickSort = By.xpath("//div[@data-testid = 'flights-quick-sort']");

    @FindBy(xpath = "//button[@data-testid = 'flights-quick-sort-item-Price-button']")
    public WebElement buttonCheapestFlight;

    @FindBy(xpath = "//button[@data-testid = 'flights-quick-sort-item-Duration-button']")
    public WebElement buttonFastestFlight;

    @FindBy(xpath = "//div[contains(@class, 'GridItem')][1]//div[@data-testid = 'web-refresh-flights-card']")
    public WebElement cardFirstFlight;

    @FindBy(xpath = "//button[@data-component = 'flight-card-bookButton']")
    public WebElement buttonSelect;

    @FindBy(xpath = "//button[@aria-expanded = 'true']//span[@data-element-name = 'flight-price-breakdown']/div/div[3]/span[2]")
    public WebElement textPrice;

}
