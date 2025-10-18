package com.example.page_factory.pages;

import org.openqa.selenium.WebDriver;
import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.HotelDetailObjectRepository;

public class HotelDetailPage extends AbstractComponent {
    private HotelDetailObjectRepository hotelDetailObject;

    public HotelDetailPage(WebDriver driver) {
        super(driver);
        hotelDetailObject = new HotelDetailObjectRepository(driver);
    }

    public void clickViewThisDealButton() {
        visibilityElement(hotelDetailObject.navBarHotel);
        hotelDetailObject.buttonViewThisDeal.click();
    }

    public void clickBookNowButtonOnTheFirstRoom() {
        visibilityElement(hotelDetailObject.cardRoom);
        hotelDetailObject.buttonBookNow.click();
    }
}
