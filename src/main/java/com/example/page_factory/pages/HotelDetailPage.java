package com.example.page_factory.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.HotelDetailObjectRepository;

public class HotelDetailPage extends AbstractComponent {
    private HotelDetailObjectRepository hotelDetailObject;
    private WebDriver driver;

    public HotelDetailPage(WebDriver driver) {
        super(driver);
        hotelDetailObject = new HotelDetailObjectRepository(driver);
        this.driver = driver;
    }

    public String versionCardRoomVisible() {
        List<WebElement> cardRoomsNew = driver.findElements(hotelDetailObject.cardRoomNewVersion);
        List<WebElement> cardRoomsOld = driver.findElements(hotelDetailObject.cardRoomOldVersion);
        String version = "";
        if (!cardRoomsNew.isEmpty() && cardRoomsNew.get(0).isDisplayed()) {
            version = "New";
        } else if (!cardRoomsOld.isEmpty() && cardRoomsOld.get(0).isDisplayed()) {
            version = "Old";
        }
        return version;
    }

    public void clickViewThisDealButton() {
        visibilityElement(hotelDetailObject.navBarHotel);
        hotelDetailObject.buttonViewThisDeal.click();
    }

    public void clickBookNowButtonOnTheFirstRoom() throws InterruptedException {
        Thread.sleep(2000);
        if (versionCardRoomVisible().equalsIgnoreCase("New")) {
            hotelDetailObject.buttonBookNowNewVersion.click();
        } else if (versionCardRoomVisible().equalsIgnoreCase("Old")) {
            hotelDetailObject.buttonBookNowOldVersion.click();
        }
    }
}
