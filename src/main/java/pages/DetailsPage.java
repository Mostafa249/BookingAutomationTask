package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DetailsPage extends BasePage {

    private final By bedRadioButton = By.name("bedPreference_78883120");
    private final By dropdownAmount = By.xpath("//select[@data-testid='select-room-trigger']");
    private final By willReserveButton = By.id("b_tt_holder_1");
    private final By checkIn = By.xpath("(//button[@data-testid='date-display-field-start'])[2]");
    private final By checkOut = By.xpath("(//button[@data-testid='date-display-field-end'])[2]");

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBedRadioButton(String value) {
        List<WebElement> radioButtonOptions = getElements(bedRadioButton);

        for (WebElement option : radioButtonOptions) {
            if (option.getAttribute("value").equals(value)) {
                option.click();
                break;
            }
        }
    }

    public void selectTheAmount(String amountValue) {
        selectByVisibleText(dropdownAmount, amountValue);
    }

    public void clickIWillReserveButton() {
        click(willReserveButton);
    }

    public String getCheckInDate() {
        return getText(checkIn);
    }

    public String getCheckOutDate() {
        return getText(checkOut);
    }

}
