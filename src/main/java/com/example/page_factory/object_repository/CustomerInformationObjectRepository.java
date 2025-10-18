package com.example.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInformationObjectRepository {
    WebDriver driver;

    public CustomerInformationObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public By cartContactDetails = By.xpath("//div[@data-testid = 'form-card-contact-0']");

    @FindBy(id = "contact.contactFirstName")
    public WebElement inputFirstNameContact;

    @FindBy(id = "contact.contactLastName")
    public WebElement inputLastNameContact;

    @FindBy(id = "contact.contactEmail")
    public WebElement inputEmailContact;

    @FindBy(xpath = "//div[@data-testid = 'contact.contactCountryOfResidenceId']//button")
    public WebElement comboBoxCountryContact;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@placeholder = 'Search']")
    public WebElement inputSearchCountryContact;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@type = 'radio']")
    public WebElement radioButtonCountryContact;

    @FindBy(xpath = "//div[@data-element-name = 'contact-calling-code-input']//button")
    public WebElement comboBoxCountryCodeContact;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@placeholder = 'Search']")
    public WebElement inputSearchCountryCodeContact;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@type = 'radio']")
    public WebElement radioButtonCountryCodeContact;

    @FindBy(id = "contact.contactPhoneNumber")
    public WebElement inputPhoneNumberContact;

    @FindBy(xpath = "//div[@data-element-name = 'passenger-gender-input']//input[@type = 'radio' and @aria-label = 'Male']")
    public WebElement radioButtonGenderMale;

    @FindBy(xpath = "//div[@data-element-name = 'passenger-gender-input']//input[@type = 'radio' and @aria-label = 'Female']")
    public WebElement radioButtonGenderFemale;

    @FindBy(id = "flight.forms.i0.units.i0.passengerFirstName")
    public WebElement inputFirstNamePassenger;

    @FindBy(id = "flight.forms.i0.units.i0.passengerLastName")
    public WebElement inputLastNamePassenger;

    @FindBy(xpath = "//input[@datatestid = 'flight.forms.i0.units.i0.passengerDateOfBirth-DateInputDataTestId']")
    public WebElement inputDayOfBirth;

    @FindBy(xpath = "//div[@data-testid = 'flight.forms.i0.units.i0.passengerDateOfBirth-MonthInputDataTestId']//button")
    public WebElement comboBoxMonthDateOfBirth;

    public By listMonthOfBirth = By.xpath("//div[@data-testid = 'floater-container']//li");

    public By textMonthOfBirth = By.xpath(".//span");

    @FindBy(xpath = "//input[@datatestid = 'flight.forms.i0.units.i0.passengerDateOfBirth-YearInputDataTestId']")
    public WebElement inputYearOfBirth;

    @FindBy(xpath = "//div[@data-testid = 'flight.forms.i0.units.i0.passengerNationality']//button")
    public WebElement comboBoxNationalityPassenger;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@placeholder = 'Search']")
    public WebElement inputSearchNationalityPassenger;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@type = 'radio']")
    public WebElement radioButtonNationalityPassenger;

    public By fieldPassportNumber = By.id("flight.forms.i0.units.i0.passportNumber");

    @FindBy(id = "flight.forms.i0.units.i0.passportNumber")
    public WebElement inputPassportNumber;

    @FindBy(xpath = "//div[@data-testid = 'flight.forms.i0.units.i0.passportCountryOfIssue']//button")
    public WebElement comboBoxCountryPassenger;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@placeholder = 'Search']")
    public WebElement inputSearchCountryPassenger;

    @FindBy(xpath = "//div[@data-testid = 'floater-container']//input[@type = 'radio']")
    public WebElement radioButtonCountryPassenger;

    @FindBy(xpath = "//input[@datatestid = 'flight.forms.i0.units.i0.passportExpiryDate-DateInputDataTestId']")
    public WebElement inputPassportExpiryDay;

    @FindBy(xpath = "//div[@data-testid = 'flight.forms.i0.units.i0.passportExpiryDate-MonthInputDataTestId']//button")
    public WebElement comboBoxPassportExpiryMonth;

    public By listPassportExpiryMonth = By.xpath("//div[@data-testid = 'floater-container']//li");

    public By textPassportExpiryMonth = By.xpath(".//span");

    @FindBy(xpath = "//input[@datatestid = 'flight.forms.i0.units.i0.passportExpiryDate-YearInputDataTestId']")
    public WebElement inputPassportExpiryYear;

    public By sectionContinueToPayment = By.xpath("//div[@data-component = 'ContinueToPayment']");

    @FindBy(xpath = "//button[@data-testid = 'continue-to-payment-button']")
    public WebElement buttonContinuePayment;

    public By popUpUpgradeLevel = By.xpath("//div[@datatestid = 'addon-last-chance-CEG_UPSELL']");

    @FindBy(xpath = "//div[@datatestid = 'addon-last-chance-CEG_UPSELL']//button[@aria-label = 'close']")
    public WebElement buttonClosePopUpUpgradeLevel;

    public By textTotalPriceFlight = By.xpath(
            "//div[@data-component = 'mob-flight-price-breakdown-wrapper']//dd[@data-component = 'mob-flight-price-total-desc']/span");

    public By alertBooking = By.xpath("//div[@data-testid = 'bf-user-drop-off-alert-modal']");

    @FindBy(xpath = "//button[@data-element-name = 'bf-user-drop-off-alert-close-button']")
    public WebElement buttonCloseAlert;

    @FindBy(xpath = "//input[@data-testid = 'contact.contactEmail']")
    public WebElement inputEmailGuest;

    @FindBy(xpath = "//select[@datatestid = 'contact.contactCountryOfResidenceId']")
    public WebElement comboBoxCountryGuest;

    public WebElement selectCountryDynamic(String country) {
        return driver.findElement(
                By.xpath(
                        "//select[@datatestid = 'contact.contactCountryOfResidenceId']/optgroup[@label = 'Most Selected Countries']/option[contains(text(), '"
                                + country + "')]"));
    }

    @FindBy(xpath = "//label[@data-element-name = 'Smoking']//input")
    public WebElement radioButtonSmookingRoom;

    @FindBy(xpath = "//label[@data-element-name = 'NonSmoking']//input")
    public WebElement radioButtonNonSmookingRoom;

    @FindBy(xpath = "//label[@data-element-name = 'LargeBed']//input")
    public WebElement radioButtonLargeBed;

    @FindBy(xpath = "//label[@data-element-name = 'TwinBed']//input")
    public WebElement radioButtonTwinBed;

    @FindBy(xpath = "//button[@data-testid = 'shimmer-cta']")
    public WebElement buttonNextFinalStep;

}
