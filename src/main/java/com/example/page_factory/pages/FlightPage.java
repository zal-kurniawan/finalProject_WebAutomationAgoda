package com.example.page_factory.pages;

import org.openqa.selenium.WebDriver;
import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.FlightObjectRepository;

public class FlightPage extends AbstractComponent {
    private FlightObjectRepository flightObject;

    public FlightPage(WebDriver driver) {
        super(driver);
        flightObject = new FlightObjectRepository(driver);
    }

    public void clickCheapestTab() {
        visibilityElement(flightObject.tabFlightsQuickSort);
        flightObject.buttonCheapestFlight.click();
    }

    public void clickFastestTab() {
        visibilityElement(flightObject.tabFlightsQuickSort);
        flightObject.buttonFastestFlight.click();
    }

    public void selectFistFlightOnList() {
        flightObject.cardFirstFlight.click();
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
