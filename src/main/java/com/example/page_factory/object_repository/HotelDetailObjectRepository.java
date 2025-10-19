package com.example.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailObjectRepository {
    public HotelDetailObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By navBarHotel = By.id("hotelNavBar");

    @FindBy(xpath = "//div[@id = 'hotelNavBar']//button[@data-element-name = 'jump-nav-cheapest-room-btn']")
    public WebElement buttonViewThisDeal;

    public By cardRoom = By.xpath("//div[@data-selenium = 'RoomGrid-content']");

    @FindBy(xpath = "//div[@data-selenium = 'RoomGrid-content']//div[@data-selenium = 'MasterRoom'][1]//div[@data-selenium = 'ChildRoomsList-room'][1]//button[@data-selenium = 'ChildRoomsList-bookButtonInput']")
    public WebElement buttonBookNow;

}
