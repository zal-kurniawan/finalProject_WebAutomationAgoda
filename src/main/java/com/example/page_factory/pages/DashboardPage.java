package com.example.page_factory.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.DashboardObjectRepository;

public class DashboardPage extends AbstractComponent {
    private DashboardObjectRepository dashboardObject;
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        dashboardObject = new DashboardObjectRepository(driver);
        this.driver = driver;
    }

    public WebElement getFlyingFrom(String flyFrom) {
        List<WebElement> listFlyingFrom = driver.findElements(dashboardObject.listSuggestionCityFlyingFrom);
        for (WebElement flyingFrom : listFlyingFrom) {
            String flyingFromName = flyingFrom.getAttribute("data-text");
            if (flyingFromName.equals(flyFrom)) {
                return flyingFrom;
            }
        }
        return null;
    }

    public WebElement getFlyingTo(String flyTo) {
        List<WebElement> listFlyingTo = driver.findElements(dashboardObject.listSuggestionCityFlyingTo);
        for (WebElement flyingTo : listFlyingTo) {
            String flyingToName = flyingTo.getAttribute("data-text");
            if (flyingToName.equals(flyTo)) {
                return flyingTo;
            }
        }
        return null;
    }

    public WebElement getDestination(String destination) {
        List<WebElement> listDestination = driver.findElements(dashboardObject.listSuggestionDestionation);
        for (WebElement place : listDestination) {
            String destinationName = place.getAttribute("data-text");
            if (destinationName.equals(destination)) {
                return place;
            }
        }
        return null;
    }

    public String geDateDynamic(int plusDay) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(plusDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return tomorrow.format(formatter);
    }

    public void selectTab(String tabName) {
        if (tabName.equalsIgnoreCase("flights")) {
            dashboardObject.tabFlight.click();
        } else if (tabName.equalsIgnoreCase("hotels")) {
            dashboardObject.tabHotel.click();
        }
    }

    public void selectFlyingToAndFrom(String flyFrom, String flyTo) {
        dashboardObject.inputFlyingFrom.sendKeys(flyFrom);
        visibilityElement(dashboardObject.listSuggestionCityFlyingFrom);
        WebElement from = getFlyingFrom(flyFrom);
        from.findElement(dashboardObject.nameSuggestionCityFlyingFrom).click();
        dashboardObject.inputFlyingTo.sendKeys(flyTo);
        visibilityElement(dashboardObject.listSuggestionCityFlyingTo);
        WebElement to = getFlyingTo(flyTo);
        to.findElement(dashboardObject.nameSuggestionCityFlyingTo).click();
    }

    public void selectDepartureDate() {
        dashboardObject.selectDateDynamic(geDateDynamic(1)).click();
    }

    public void selectFlightClass(String flightClass) {
        if (flightClass.equalsIgnoreCase("economy")) {
            dashboardObject.buttonClassFlightEconomy.click();
        } else if (flightClass.equalsIgnoreCase("premium economy")) {
            dashboardObject.buttonClassFlightPremiumEconomy.click();
        }
    }

    public void clickSearchFlights() {
        dashboardObject.buttonSearchFlights.click();
    }

    public void searchDesination(String destination) {
        dashboardObject.inputDestination.sendKeys(destination);
        visibilityElement(dashboardObject.listSuggestionDestionation);
        WebElement place = getDestination(destination);
        place.findElement(dashboardObject.nameSuggestionDestination).click();
    }

    public void selectCheckInAndCheckOut() {
        dashboardObject.selectDateDynamic(geDateDynamic(1)).click();
        dashboardObject.selectDateDynamic(geDateDynamic(5)).click();
    }

    public void setRoomAndGuest(int rooms, int guests) {
        int totalActualRoom = Integer.parseInt(dashboardObject.textRoomValue.getText());
        if (totalActualRoom != rooms) {
            int add = rooms - totalActualRoom;
            for (int total = 0; total < add; total++) {
                dashboardObject.buttonAddRoom.click();
            }
        }
        int totalActualGuest = Integer.parseInt(dashboardObject.textAdultValue.getText());
        if (totalActualGuest != guests) {
            if (totalActualGuest < guests) {
                int add = guests - totalActualGuest;
                for (int total = 0; total < add; total++) {
                    dashboardObject.buttonAddAdults.click();
                }
            } else if (totalActualGuest > guests) {
                int substract = totalActualGuest - guests;
                for (int total = 0; total < substract; total++) {
                    dashboardObject.buttonSubstractAdults.click();
                }
            }
        }
    }

    public void clickSearchButton() {
        dashboardObject.buttonSearchHotel.click();
    }

    public void verifyFailedFlightSearchPopUp() throws InterruptedException {
        visibilityElement(dashboardObject.popUpFailedFlightSearch);
        WebElement popUpFailure = driver.findElement(dashboardObject.popUpFailedFlightSearch);
        popUpFailure.isDisplayed();
        Thread.sleep(3000);
    }

    public void verifyFailedHotelSearchPopUp() throws InterruptedException {
        visibilityElement(dashboardObject.popUpFailedHotelSearch);
        WebElement popUpFailure = driver.findElement(dashboardObject.popUpFailedHotelSearch);
        popUpFailure.isDisplayed();
        Thread.sleep(3000);
    }

}
