package stepdefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.example.page_factory.pages.HotelDetailPage;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelDetailPageStepDef {
    WebDriver driver;
    HotelDetailPage hotelDetailPage;
    WebDriverWait wait;

    public HotelDetailPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.hotelDetailPage = new HotelDetailPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("User is navigate to Hotel Detail page")
    public void userIsNavigateToHotelDetailPage() {
        String secondTab = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        Set<String> allTabs = driver.getWindowHandles();
        for (String tabHandle : allTabs) {
            if (!tabHandle.equals(HotelListPageStepDef.originalTab) && !tabHandle.equals(secondTab)) {
                driver.switchTo().window(tabHandle);
                break;
            }
        }
    }

    @When("User click View This Deal button")
    public void userClickViewThisDealButton() {
        hotelDetailPage.clickViewThisDealButton();
    }

    @And("User click Book Now button on the first room in the list")
    public void userClickBookNowButtonOnTheFirstRoomInTheList() throws InterruptedException {
        hotelDetailPage.clickBookNowButtonOnTheFirstRoom();
    }
}
