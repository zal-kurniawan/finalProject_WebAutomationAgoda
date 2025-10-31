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
        /*
         * Bisa ditambahkan verifikasi bahwa element sudah ada, jadi tidak hanya mengandalkan sleep, misal dengan menunggu visibility element tertentu
         */
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

    /*
     * Untuk step definition memilih flight dengan badge tertentu, bisa digabung menjadi satu method dengan parameter badge yang dipilih
     * Misal: public void userSelectsTheFlightWithBadge(String badgeType) { ... }
     * Lalu di dalam method tersebut, panggil flightPage.selectAirline(badgeType);
     * Dengan begitu, tidak perlu membuat dua method terpisah untuk cheapest dan fastest
     * Contoh implementasi:
     * @And("User selects the flight with the {string} badge in the list to see details")
     * public void userSelectsTheFlightWithTheBadgeInTheList(String badgeType) {
     *     flightPage.selectAirline(badgeType);
     *     airline = flightPage.getAirlineOfFlight();
     *     price = flightPage.getPriceOfFlight();
     * }
     */

    @And("User selects the flight with the cheapest badge in the list to see details")
    public void userSelectsTheFlightWithTheCheapestBadgeInTheList() {
        flightPage.selectAirline("cheapest");
        airline = flightPage.getAirlineOfFlight();
        price = flightPage.getPriceOfFlight();
    }

    @And("User selects the flight with the fastest badge in the list to see details")
    public void userSelectsTheFlightWithTheFastestBadgeInTheList() {
        flightPage.selectAirline("fastest");
        airline = flightPage.getAirlineOfFlight();
        price = flightPage.getPriceOfFlight();
    }


    @And("User click button select")
    public void userClickButtonSelect() {
        flightPage.clickSelectButton();
    }
}
