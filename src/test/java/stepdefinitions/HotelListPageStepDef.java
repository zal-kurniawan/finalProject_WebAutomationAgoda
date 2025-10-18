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

    @When("User sorting by 'Top reviewed by all guests' on Hotel List page")
    public void userSortingByTopReviewedByAllGuestesOnHotelListPage() {
        hotelListPage.sortingByTopReviewed("All guests");
    }

    @And("User click the first hotel in the list")
    public void userClickTheFirstHotelInTheList() {
        hotelListPage.selectFistHotelOnList();
    }
}
