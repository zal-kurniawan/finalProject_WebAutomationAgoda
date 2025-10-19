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

public class CustomerInformationPageStepDef {
    WebDriver driver;
    WebDriverWait wait;
    CustomerInformationPage customerInformationPage;
    CustomerInformationObjectRepository customerInformationObject;
    public String firstNameContact, lastNameContact, email, phoneNumber, firstNamePassenger, lastNamePassenger,
            passportNumber;

    public CustomerInformationPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        this.customerInformationPage = new CustomerInformationPage(driver);
        this.customerInformationObject = new CustomerInformationObjectRepository(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Then("User is navigate to Customer Information page and verify the price")
    public void userIsNavigateToCustomerInformationPageAndVerifyThePrice() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerInformationObject.textTotalPriceFlight));
        String totalPriceActual = driver.findElement(customerInformationObject.textTotalPriceFlight).getText();
        Assert.assertEquals(totalPriceActual, "Rp " + FlightPageStepDef.price, "Total Price is incorrect");
    }

    @When("User fill Contact details data with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillContactDetailsData(String firstNameContact, String lastNameContact, String emailContact,
            String countryContact, String countryCodeContact, String phoneNumberContact) throws InterruptedException {
        this.firstNameContact = firstNameContact;
        this.lastNameContact = lastNameContact;
        this.email = emailContact;
        this.phoneNumber = phoneNumberContact;
        customerInformationPage.fillContactDetails(firstNameContact, lastNameContact, emailContact, countryContact,
                countryCodeContact, phoneNumberContact);
    }

    @And("User fill Passenger data with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillPassengerData(String gender, String firstNamePassenger, String lastNamePassenger,
            String dateOfBirth, String nationality, String passportNumber, String countryPassenger,
            String passportExpiryDate) throws InterruptedException {
        this.firstNamePassenger = firstNamePassenger;
        this.lastNamePassenger = lastNamePassenger;
        this.passportNumber = passportNumber;
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
