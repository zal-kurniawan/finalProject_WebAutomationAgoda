package stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.example.page_factory.pages.DashboardPage;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardPageStepDef {
    WebDriver driver;
    DashboardPage dashboardPage;

    public DashboardPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.dashboardPage = new DashboardPage(driver);
    }

    @When("User select tab {string}")
    public void userSelectTheFlightsTab(String tab) {
        dashboardPage.selectTab(tab);
    }

    @Then("The flight search form should be displayed")
    public void theFlightSearchFromShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(1000);
    }

    @When("User searches for a flight from {string} to {string}")
    public void userSearchesForAFlightFromTo(String flyFrom, String flyTo) {
        dashboardPage.selectFlyingToAndFrom(flyFrom, flyTo);
    }

    @And("User select Departure date")
    public void userSelectDepartureDate() {
        dashboardPage.selectDepartureDate();
    }

    @And("User select flight class {string}")
    public void userSelectFlightClass(String flightClass) {
        dashboardPage.selectFlightClass(flightClass);
    }

    @And("User click Search Flights button")
    public void userClickSearchFlightsButton() {
        dashboardPage.clickSearchFlights();
    }

    @Then("The hotel search form should be displayed")
    public void theHotelSearchFromShouldBeDisplayed() throws InterruptedException {

    }

    @When("User search destination {string}")
    public void userSearchDestination(String destination) {
        dashboardPage.searchDesination(destination);
    }

    @And("User selects the check in and check out date")
    public void userSelectCheckInAndCheckOutDate() {
        dashboardPage.selectCheckInAndCheckOut();
    }

    @And("User set rooms {string} and guests {string}")
    public void userSetRoomsAndGuests(String rooms, String guests) {
        dashboardPage.setRoomAndGuest(Integer.parseInt(rooms), Integer.parseInt(guests));
    }

    @And("User click Search button")
    public void userClickSearchButton() {
        dashboardPage.clickSearchButton();
    }
}
