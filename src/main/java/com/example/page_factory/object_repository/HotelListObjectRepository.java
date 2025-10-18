package com.example.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelListObjectRepository {
    public HotelListObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By listHotel = By.xpath("//ol[contains(@class, 'hotel-list-container')]//li[@data-selenium = 'hotel-item']");

    @FindBy(xpath = "//button[@data-element-name = 'search-sort-guest-rating']")
    public WebElement buttonSortTopReviewed;

    public By listSortTopReviewed = By.xpath("//div[@data-testid = 'floater-container']//li");

    public By nameSortTopReviewed = By.xpath(".//span[@data-testid = 'title']");

    @FindBy(xpath = "//ol[contains(@class, 'hotel-list-container')][1]//li[@data-selenium = 'hotel-item'][1]//div[@data-element-name = 'PropertyCardBaseJacket']")
    public WebElement cardFirstHotel;
}
