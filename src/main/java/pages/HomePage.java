package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    private final By searchBar = By.id(":rh:");
    private final By datePicker = By.xpath("//button[@data-testid='date-display-field-start']");
    private final By popUpCloseButton = By.xpath("//div[@class='dd5dccd82f']//button");
    private final By searchButton = By.xpath("//button[@type='submit']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closePopUp() {
        handleOptionalPopup(popUpCloseButton);
    }

    public void enterNeededCityInSearch(String city) throws InterruptedException {
        type(searchBar, city);
        Thread.sleep(1000);
        clickEnter(searchBar,city);
    }

    public void clickOnDatePickerButton() {
        click(datePicker);
    }

    public void chooseDateByDay(String day) {
        By dayPicker = By.xpath("(//table[contains(@class, 'eb03f3f27f')])[2]//td[normalize-space()=" + day + "]");
        click(dayPicker);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

}
