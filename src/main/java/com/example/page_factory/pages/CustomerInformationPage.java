package com.example.page_factory.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.CustomerInformationObjectRepository;

public class CustomerInformationPage extends AbstractComponent {
    private CustomerInformationObjectRepository customerInformationObject;
    private WebDriver driver;

    public CustomerInformationPage(WebDriver driver) {
        super(driver);
        customerInformationObject = new CustomerInformationObjectRepository(driver);
        this.driver = driver;
    }

    public String[] splitDate(String date) {
        String[] split = date.split("\\s+");
        return split;
    }

    public WebElement getMonthOfBirth(String month) {
        List<WebElement> listMonthOfBirth = driver.findElements(customerInformationObject.listMonthOfBirth);
        for (WebElement monthOfBirth : listMonthOfBirth) {
            String monthName = monthOfBirth.getText();
            if (monthName.equals(month)) {
                return monthOfBirth;
            }
        }
        return null;
    }

    public WebElement getMonthPassportExipry(String month) {
        scrollDown();
        List<WebElement> listPassportExpiryMonth = driver
                .findElements(customerInformationObject.listPassportExpiryMonth);

        for (WebElement passportExpiryMonth : listPassportExpiryMonth) {
            String monthName = passportExpiryMonth.getText();
            if (monthName.equals(month)) {
                return passportExpiryMonth;
            }
        }
        return null;
    }

    public boolean passportFieldVisible() {
        List<WebElement> passportFields = driver.findElements(customerInformationObject.fieldPassportNumber);
        System.out.println("PASSPORT FIELD: " + passportFields);
        if (!passportFields.isEmpty() && passportFields.get(0).isDisplayed()) {
            System.out.println("TRUE");
            return true;
        } else {
            System.out.println("FALSE");
            return false;
        }

    }

    public void fillContactDetails(String firstNameContact, String lastNameContact, String emailContact,
            String countryContact, String countryCodeContact, String phoneNumberContact) {
        visibilityElement(customerInformationObject.cartContactDetails);
        customerInformationObject.inputFirstNameContact.sendKeys(firstNameContact);
        customerInformationObject.inputLastNameContact.sendKeys(lastNameContact);
        customerInformationObject.inputEmailContact.sendKeys(emailContact);
        customerInformationObject.comboBoxCountryContact.click();
        customerInformationObject.inputSearchCountryContact.sendKeys(countryContact);
        customerInformationObject.radioButtonCountryContact.click();
        customerInformationObject.comboBoxCountryCodeContact.click();
        customerInformationObject.inputSearchCountryCodeContact.sendKeys(countryCodeContact);
        customerInformationObject.radioButtonCountryCodeContact.click();
        customerInformationObject.inputPhoneNumberContact.sendKeys(phoneNumberContact);
    }

    public void fillPassengerDetails(String gender, String firstNamePassenger, String lastNamePassenger,
            String dateOfBirth, String nationality, String passportNumber, String countryPassenger,
            String passportExpiryDate) {
        if (gender.equalsIgnoreCase("Male")) {
            customerInformationObject.radioButtonGenderMale.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            customerInformationObject.radioButtonGenderFemale.click();
        }
        customerInformationObject.inputFirstNamePassenger.sendKeys(firstNamePassenger);
        customerInformationObject.inputLastNamePassenger.sendKeys(lastNamePassenger);
        String[] dateOfBirthSplit = splitDate(dateOfBirth);
        customerInformationObject.inputDayOfBirth.sendKeys(dateOfBirthSplit[0]);
        customerInformationObject.comboBoxMonthDateOfBirth.click();
        WebElement monthBirth = getMonthOfBirth(dateOfBirthSplit[1]);
        monthBirth.findElement(customerInformationObject.textMonthOfBirth).click();
        customerInformationObject.inputYearOfBirth.sendKeys(dateOfBirthSplit[2]);
        customerInformationObject.comboBoxNationalityPassenger.click();
        customerInformationObject.inputSearchNationalityPassenger.sendKeys(nationality);
        customerInformationObject.radioButtonNationalityPassenger.click();
        if (passportFieldVisible()) {
            customerInformationObject.inputPassportNumber.sendKeys(passportNumber);
            customerInformationObject.comboBoxCountryPassenger.click();
            customerInformationObject.inputSearchCountryPassenger.sendKeys(countryPassenger);
            customerInformationObject.radioButtonCountryPassenger.click();
            String[] passportExpiryDateSplit = splitDate(passportExpiryDate);
            customerInformationObject.inputPassportExpiryDay.sendKeys(passportExpiryDateSplit[0]);
            customerInformationObject.comboBoxPassportExpiryMonth.click();
            WebElement monthExpiry = getMonthPassportExipry(passportExpiryDateSplit[1]);
            monthExpiry.findElement(customerInformationObject.textPassportExpiryMonth).click();
            customerInformationObject.inputPassportExpiryYear.sendKeys(passportExpiryDateSplit[2]);
        }
    }

    public void clickContinueToPaymentButton() {
        visibilityElement(customerInformationObject.sectionContinueToPayment);
        customerInformationObject.buttonContinuePayment.click();
    }

    public void closePopUpUpgradeLevel() {
        visibilityElement(customerInformationObject.popUpUpgradeLevel);
        customerInformationObject.buttonClosePopUpUpgradeLevel.click();
    }

    public void fillGuestDetail(String firstName, String lastName, String email, String country, String phoneNumber,
            String specialRequest) throws InterruptedException {
        visibilityElement(customerInformationObject.alertBooking);
        customerInformationObject.buttonCloseAlert.click();
        Thread.sleep(2000);
        customerInformationObject.inputFirstNameContact.sendKeys(firstName);
        customerInformationObject.inputLastNameContact.sendKeys(lastName);
        customerInformationObject.inputEmailGuest.sendKeys(email);
        customerInformationObject.comboBoxCountryGuest.click();
        customerInformationObject.selectCountryDynamic(country);
        customerInformationObject.inputPhoneNumberContact.sendKeys(phoneNumber);
        String[] requests = specialRequest.split(" - ");
        if (requests[0].equalsIgnoreCase("Smoking")) {
            customerInformationObject.radioButtonSmookingRoom.click();
        } else if (requests[0].equalsIgnoreCase("NonSmoking")) {
            customerInformationObject.radioButtonNonSmookingRoom.click();
        }
        if (requests[1].equalsIgnoreCase("LargeBed")) {
            customerInformationObject.radioButtonLargeBed.click();
        } else if (requests[1].equalsIgnoreCase("TwinBed")) {
            customerInformationObject.radioButtonTwinBed.click();
        }
    }

    public void clickButtonNext() throws InterruptedException {
        scrollDown();
        Thread.sleep(1000);
        customerInformationObject.buttonNextFinalStep.click();
    }

}
