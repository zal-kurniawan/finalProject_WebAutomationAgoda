package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.example.page_factory.object_repository.CustomerInformationObjectRepository;
import com.example.page_factory.pages.CustomerInformationPage;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.example.utils.AssertUtils.*;

public class CustomerInformationPageStepDef {
    WebDriver driver;
    WebDriverWait wait;
    CustomerInformationPage customerInformationPage;
    CustomerInformationObjectRepository customerInformationObject;
    // public String firstNameContact, lastNameContact, email, phoneNumber, firstNamePassenger, lastNamePassenger,
    //         passportNumber;

    public CustomerInformationPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.customerInformationPage = new CustomerInformationPage(driver);
        this.customerInformationObject = new CustomerInformationObjectRepository(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // wait ini bisa dipake di semua step definition jadi better dibuat di abstract component 
    }

    @Then("User is navigate to Customer Information page and verify airline and total price")
    public void userIsNavigateToCustomerInformationPageAndVerifyAirlineAndToalPrice() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerInformationObject.textTotalPrice)); // wait element ini bisa dibuat di CustomerPage, nanti call abstract component yang visibilityElement
        String airlineActual = customerInformationObject.imageAirline.getAttribute("alt"); // untuk get text ini bisa diimplement di CustomerInformationPage, buat method getAirline() return airlineActual
        
        // Untuk assertion bisa dibuat general fuction sehingga bisa dipakai di semua step definition, karena biasanya assertion itu sering dipakai di semua step definition
        assertEquals(airlineActual, FlightPageStepDef.airline, "Airline");
        // Assert.assertEquals(airlineActual, FlightPageStepDef.airline, "Airline is incorrect");
        String totalPriceActual = driver.findElement(customerInformationObject.textTotalPrice).getText(); // untuk get text ini bisa diimplement di CustomerInformationPage, buat method getTotalPrice() return totalPriceActual
        // Assert.assertEquals(totalPriceActual, "Rp " + FlightPageStepDef.price, "Total Price is incorrect");
        assertEquals(totalPriceActual, "Rp " + FlightPageStepDef.price, "Total Price is incorrect");
    }

    @When("User fill Contact details data with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillContactDetailsData(String firstNameContact, String lastNameContact, String emailContact,
            String countryContact, String countryCodeContact, String phoneNumberContact) throws InterruptedException {
        /*
         * Kalau mau dipakai di step definition lain, simpan di variable global tapi kalau tidak dipakai di step definition lain, tidak usah disimpan di variable global
         */
        // this.firstNameContact = firstNameContact;
        // this.lastNameContact = lastNameContact;
        // this.email = emailContact;
        // this.phoneNumber = phoneNumberContact;
        customerInformationPage.fillContactDetails(firstNameContact, lastNameContact, emailContact, countryContact,
                countryCodeContact, phoneNumberContact);
    }

    @And("User fill Passenger data with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillPassengerData(String gender, String firstNamePassenger, String lastNamePassenger,
            String dateOfBirth, String nationality, String passportNumber, String countryPassenger,
            String passportExpiryDate) throws InterruptedException {
        /*
         * Kalau mau dipakai di step definition lain, simpan di variable global tapi kalau tidak dipakai di step definition lain, 
         * tidak usah disimpan di variable global, karena kita sudah dapat data itu dari parameter method
         */
        // this.firstNamePassenger = firstNamePassenger;
        // this.lastNamePassenger = lastNamePassenger;
        // this.passportNumber = passportNumber;
        customerInformationPage.fillPassengerDetails(gender, firstNamePassenger, lastNamePassenger, dateOfBirth,
                nationality, passportNumber, countryPassenger, passportExpiryDate);
    }

    @And("User click Continue to Payment button")
    public void userClickContinueToPaymentButton() {
        customerInformationPage.clickContinueToPaymentButton();
    }

    @And("User close pop up")
    public void userClosePopUp() {
        customerInformationPage.closePopUpUpgradeLevel();
    }

    @Then("User is navigate to Customer Information")
    public void userIsNavigateToCustomerInformation() throws InterruptedException {
        /*
         * Bisa ditambahkan verifikasi bahwa sudah berada di halaman Customer, jadi tidak hanya mengandalkan sleep
         */
        Thread.sleep(3000);
    }

    @When("User fill guest detail with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillGuestDetail(String firstName, String lastName, String email, String country, String phoneNumber,
            String specialRequest) throws InterruptedException {
        customerInformationPage.fillGuestDetail(firstName, lastName, email, country, phoneNumber, specialRequest);
    }

    @And("User click button Next Final Step")
    public void userClickButtonNextFinalStep() throws InterruptedException {
        customerInformationPage.clickButtonNext();
    }
}
