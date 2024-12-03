package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservationPage extends BasePage {

    private final By hotelName = By.xpath("//h1[@class='e1eebb6a1e']");

    public ReservationPage(WebDriver driver) {
        super(driver);
    }

    public String getTheHotelName() {
        return getText(hotelName);
    }
}
