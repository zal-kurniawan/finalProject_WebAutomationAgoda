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

    @FindBy(xpath = "//div[@data-component = 'flight-card-container']//div[contains(@class , 'Grid__GridStyled')]/div[1]//button[@aria-label = 'Expand flight details']")
    public WebElement cardFirstFlight;

    @FindBy(xpath = "//span[text() = 'Cheapest']/ancestor::div[@data-testid = 'flightCard-flight-detail']")
    public WebElement cardFlightCheapest;

    public By badgeCheapest = By.xpath("//span[text() = 'Cheapest']");

    @FindBy(xpath = "//span[text() = 'Fastest']/ancestor::div[@data-testid = 'flightCard-flight-detail']")
    public WebElement cardFlightFastest;

    public By badgeFastest = By.xpath("//span[text() = 'Fastest']");

    @FindBy(xpath = "//button[@data-component = 'flight-card-bookButton']")
    public WebElement buttonSelect;

    @FindBy(xpath = "//button[@aria-expanded = 'true']//div[@data-testid = 'flightCard-flight-detail']//img")
    public WebElement imageAirline;

    @FindBy(xpath = "//button[@aria-expanded = 'true']//span[@data-element-name = 'flight-price-breakdown']/div/div[3]/span[2]")
    public WebElement textPrice;

}
