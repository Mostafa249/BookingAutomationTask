package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private final By hotelTitle = By.xpath("//div[@data-testid='title']");
    private final By seeAvailabilityButton = By.xpath("//a[@data-testid='availability-cta-btn']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSeeAvailabilityButton(String hotelName) {
        boolean hotelFound = false;
        while (!hotelFound) {
            List<WebElement> hotelsTitles = getElements(hotelTitle);
            for (WebElement hotelTitle : hotelsTitles) {
                if (hotelTitle.getText().contains(hotelName)) {
                    click(seeAvailabilityButton);
                    hotelFound = true;
                    break;
                }
            }
        }
    }
}
