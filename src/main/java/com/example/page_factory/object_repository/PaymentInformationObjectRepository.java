package com.example.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationObjectRepository {
    public PaymentInformationObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By sectionContact = By
            .xpath("//div[@data-testid = 'page-grid-container']//div[@data-component = 'contact-summary']");

    @FindBy(xpath = "//div[@data-component = 'passenger-summary-list']/../div[@data-component = 'name-container']//span[@data-component = 'name-container-name']")
    public WebElement textNameContact;

    @FindBy(xpath = "//div[@data-component = 'passenger-summary-list']/../div[@data-component = 'name-container']//div[@data-component = 'name-container-detail'][1]/span")
    public WebElement textEmailContact;

    @FindBy(xpath = "//div[@data-component = 'passenger-summary-list']/../div[@data-component = 'name-container']//div[@data-component = 'name-container-detail'][2]/span")
    public WebElement textPhoneNumberContact;

    @FindBy(xpath = "//div[@data-component = 'passenger-summary-list']//span[@data-component = 'name-container-name']")
    public WebElement textNamePassenger;

    @FindBy(xpath = "//div[@data-component = 'passenger-summary-list']//div[@data-component = 'name-container-detail']/span")
    public WebElement textPassportNumberPassenger;

    @FindBy(xpath = "//div[@data-component = 'mob-flight-price-breakdown-wrapper']//dd[@data-component = 'mob-flight-price-total-desc']/span")
    public WebElement textTotalPriceFlight;

    public By sectionPayment = By.id("payment-details");

}
