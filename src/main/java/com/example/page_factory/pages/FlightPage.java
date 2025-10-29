package com.example.page_factory.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.FlightObjectRepository;

public class FlightPage extends AbstractComponent {
    private FlightObjectRepository flightObject;
    private WebDriver driver;

    public FlightPage(WebDriver driver) {
        super(driver);
        flightObject = new FlightObjectRepository(driver);
        this.driver = driver;
    }

    public boolean badgeVisible(String type) {
        List<WebElement> badgeFlights = new ArrayList<>();
        if (type.equalsIgnoreCase("cheapest")) {
            badgeFlights = driver.findElements(flightObject.badgeCheapest);
        } else if (type.equalsIgnoreCase("fastest")) {
            badgeFlights = driver.findElements(flightObject.badgeFastest);
        }
        if (!badgeFlights.isEmpty() && badgeFlights.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickCheapestTab() {
        visibilityElement(flightObject.tabFlightsQuickSort);
        flightObject.buttonCheapestFlight.click();
    }

    public void clickFastestTab() {
        visibilityElement(flightObject.tabFlightsQuickSort);
        flightObject.buttonFastestFlight.click();
    }

    public void selectAirline(String type) {
        if (type.equalsIgnoreCase("cheapest") && badgeVisible(type)) {
            flightObject.cardFlightCheapest.click();
        } else if (type.equalsIgnoreCase("fastest") && badgeVisible(type)) {
            flightObject.cardFlightFastest.click();
        } else {
            flightObject.cardFirstFlight.click();
        }
    }

    public String getAirlineOfFlight() {
        return flightObject.imageAirline.getAttribute("alt");
    }

    public String getPriceOfFlight() {
        return flightObject.textPrice.getText();
    }

    public void clickSelectButton() {
        flightObject.buttonSelect.click();
    }
}
