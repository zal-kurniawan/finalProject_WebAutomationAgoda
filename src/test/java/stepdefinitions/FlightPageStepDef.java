package stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.example.page_factory.pages.FlightPage;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightPageStepDef {
    WebDriver driver;
    private FlightPage flightPage;
    public static String price, airline;

    public FlightPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.flightPage = new FlightPage(driver);
    }

    @Then("User is navigate to Flights List page")
    public void userIsNavigateToFlightsListPage() throws InterruptedException {
        Thread.sleep(2000);
    }

    @When("User click Cheapest tab")
    public void userClickCheapestTab() {
        flightPage.clickCheapestTab();
    }

    @When("User click Fastest tab")
    public void userClickFastestTab() {
        flightPage.clickFastestTab();
    }

    @And("User selects the first flight in the list to see details")
    public void userSelectTheFirstFlightInTheList() {
        flightPage.selectFistFlightOnList();
        airline = flightPage.getAirlineOfFlight();
        price = flightPage.getPriceOfFlight();
    }

    @And("User click button select")
    public void userClickButtonSelect() {
        flightPage.clickSelectButton();
    }
}
