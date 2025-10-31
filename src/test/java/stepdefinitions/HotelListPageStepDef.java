package stepdefinitions;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.example.page_factory.pages.HotelListPage;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelListPageStepDef {
    WebDriver driver;
    HotelListPage hotelListPage;
    WebDriverWait wait;
    public static String originalTab;

    public HotelListPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.hotelListPage = new HotelListPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("User is navigate to Hotel List page")
    public void userIsNavigateToHotelListPage() {
        originalTab = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allTabs = driver.getWindowHandles();
        for (String tabHandle : allTabs) {
            if (!tabHandle.equals(originalTab)) {
                driver.switchTo().window(tabHandle);
                break;
            }
        }
    }

    /*
     * Stepdefenition ini bisa dibuat lebih general dengan menambahkan parameter sorting yang dipilih
     * karena params top reviewed ada beberapa diantaranya 'All guests', 'Couples', 'Families', dll
     * misal: public void userSortingByTopReviewedBy(String guestType) { ... }
     * lalu di dalam method tersebut, panggil hotelListPage.sortingByTopReviewed(guestType);
     * dengan begitu, tidak perlu membuat method terpisah untuk setiap jenis guest
     */
    @When("User sorting by 'Top reviewed by all guests' on Hotel List page")
    public void userSortingByTopReviewedByAllGuestesOnHotelListPage() {
        hotelListPage.sortingByTopReviewed("All guests");
    }

    /*
     * sorting disini bisa digabung menjadi satu method dengan parameter sorting yang dipilih
     * misal: public void userSortingBy(String sortingType) { ... }
     * lalu di dalam method tersebut, panggil hotelListPage.sortingBy(sortingType);
     * dengan begitu, tidak perlu membuat dua method terpisah untuk 'Lowest Price First' dan 'Top reviewed by all guests'
     */
    @When("User sorting by 'Lowest Price First' on Hotel List page")
    public void userSortingByLowestPriceFirstOnHotelListPage() {
        hotelListPage.sortingByLowestPrice();
    }

    @And("User click the first hotel in the list")
    public void userClickTheFirstHotelInTheList() throws InterruptedException {
        hotelListPage.selectFistHotelOnList();
    }
}
