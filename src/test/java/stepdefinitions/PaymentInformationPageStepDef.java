package stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.example.page_factory.object_repository.PaymentInformationObjectRepository;
import hook.Hooks;
import io.cucumber.java.en.Then;

public class PaymentInformationPageStepDef {
    WebDriver driver;
    WebDriverWait wait;
    PaymentInformationObjectRepository paymentObject;

    public PaymentInformationPageStepDef(Hooks hooks) {
        this.driver = Hooks.getDriver();
        paymentObject = new PaymentInformationObjectRepository(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Then("User can verify price, contact, and passenger detail in Payment Information Page with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userCanVerifyPriceContactPassengerDetailInPaymentInformationPage(String firstNameContact,
            String lastNameContact, String emailContact, String phoneNumberContact, String firstNamePassenger,
            String lastNamePassenger) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentObject.sectionContact));
        String nameContact = paymentObject.textNameContact.getText();
        Assert.assertEquals(nameContact, (firstNameContact.toUpperCase() + " " + lastNameContact.toUpperCase()),
                "Contact Name is incorrect");
        String email = paymentObject.textEmailContact.getText();
        Assert.assertEquals(email, emailContact, "Email Contact is incorrect");
        String[] phoneNumber = paymentObject.textPhoneNumberContact.getText().split(" ");
        Assert.assertEquals(phoneNumber[1], phoneNumberContact, "Phone Number Contact is incorrect");
        String namePassenger = paymentObject.textNamePassenger.getText();
        Assert.assertEquals(namePassenger, (firstNamePassenger.toUpperCase() + " " + lastNamePassenger.toUpperCase()),
                "Passenger Name is incorrect");
    }

    @Then("User is navigate to Payment Information page")
    public void userIsNavigateToPaymentInformationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentObject.sectionPayment));
        Thread.sleep(3000);
    }
}
