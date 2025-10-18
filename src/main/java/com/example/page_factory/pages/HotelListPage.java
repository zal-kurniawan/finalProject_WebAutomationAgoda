package com.example.page_factory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.abstractcomponents.AbstractComponent;
import com.example.page_factory.object_repository.HotelListObjectRepository;

public class HotelListPage extends AbstractComponent {
    private HotelListObjectRepository hotelListObject;
    private WebDriver driver;

    public HotelListPage(WebDriver driver) {
        super(driver);
        hotelListObject = new HotelListObjectRepository(driver);
        this.driver = driver;
    }

    public WebElement getTopReviewedBy(String sort) {
        List<WebElement> listTopReviewed = driver.findElements(hotelListObject.listSortTopReviewed);
        for (WebElement topReviewed : listTopReviewed) {
            String topReviewedName = topReviewed.getText();
            if (topReviewedName.equals(sort)) {
                return topReviewed;
            }
        }
        return null;
    }

    public void sortingByTopReviewed(String sort) {
        visibilityElement(hotelListObject.listHotel);
        hotelListObject.buttonSortTopReviewed.click();
        visibilityElement(hotelListObject.listSortTopReviewed);
        WebElement topReviewd = getTopReviewedBy(sort);
        topReviewd.findElement(hotelListObject.nameSortTopReviewed).click();
    }

    public void selectFistHotelOnList() {
        hotelListObject.cardFirstHotel.click();
    }

}
