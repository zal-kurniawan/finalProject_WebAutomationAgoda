package com.example.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjectRepository {
    WebDriver driver;

    public DashboardObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@id = 'tab-all-rooms-tab']")
    public WebElement tabHotel;

    @FindBy(xpath = "//li[@id = 'tab-flight-tab']")
    public WebElement tabFlight;

    @FindBy(xpath = "//input[@data-selenium = 'flight-origin-search-input']")
    public WebElement inputFlyingFrom;

    @FindBy(xpath = "//input[@data-selenium = 'flight-destination-search-input']")
    public WebElement inputFlyingTo;

    public By listSuggestionCityFlyingFrom = By.xpath("//li[@data-selenium = 'autosuggest-item']");

    public By nameSuggestionCityFlyingFrom = By.xpath(".//span[@data-selenium = 'suggestion-text']");

    public By listSuggestionCityFlyingTo = By.xpath("//li[@data-selenium = 'autosuggest-item']");

    public By nameSuggestionCityFlyingTo = By.xpath(".//span[@data-selenium = 'suggestion-text']");

    @FindBy(xpath = "//div[@data-selenium = 'flight-date-selector']/div")
    public WebElement buttonDeparture;

    @FindBy(xpath = "//div[@data-selenium = 'range-picker-date']")
    public WebElement dateDeparture;

    public WebElement selectDateDynamic(String date) {
        return driver.findElement(By.xpath("//span[@data-selenium-date = '" + date + "']"));
    }

    @FindBy(xpath = "//button[@data-element-object-id = 'economy']")
    public WebElement buttonClassFlightEconomy;

    @FindBy(xpath = "//button[@data-element-object-id = 'premium-economy']")
    public WebElement buttonClassFlightPremiumEconomy;

    @FindBy(xpath = "//button[@data-selenium = 'searchButton']")
    public WebElement buttonSearchFlights;

    @FindBy(xpath = "//input[@data-selenium = 'textInput']")
    public WebElement inputDestination;

    public By listSuggestionDestionation = By.xpath("//li[@data-selenium = 'autosuggest-item']");

    public By nameSuggestionDestination = By.xpath(".//span[@data-selenium = 'suggestion-text']/span");

    @FindBy(xpath = "//div[@data-selenium = 'desktop-occ-room-value']/p")
    public WebElement textRoomValue;

    @FindBy(xpath = "//div[@data-selenium = 'desktop-occ-adult-value']/p")
    public WebElement textAdultValue;

    @FindBy(xpath = "//button[@data-element-name = 'occupancy-selector-panel-rooms' and @data-selenium = 'plus']")
    public WebElement buttonAddRoom;

    @FindBy(xpath = "//button[@data-element-name = 'occupancy-selector-panel-adult' and @data-selenium = 'plus']")
    public WebElement buttonAddAdults;

    @FindBy(xpath = "//button[@data-element-name = 'occupancy-selector-panel-adult' and @data-selenium = 'minus']")
    public WebElement buttonSubstractAdults;

    @FindBy(xpath = "//button[@data-selenium = 'searchButton']")
    public WebElement buttonSearchHotel;

    public By popUpFailedFlightSearch = By.xpath("//div[@data-component = 'flight-error-modal']");

    public By popUpFailedHotelSearch = By.xpath("//div[@data-element-name = 'search-box-modal-message']");
}
