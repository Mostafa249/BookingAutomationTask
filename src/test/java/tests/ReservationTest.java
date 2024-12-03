package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailsPage;
import pages.HomePage;
import pages.ReservationPage;
import pages.SearchResultsPage;
import utils.FileReader;

import java.io.IOException;

public class ReservationTest {

    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private DetailsPage detailsPage;
    private ReservationPage reservationPage;
    private FileReader fileReader;

    @BeforeMethod
    public void setup() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        detailsPage = new DetailsPage(driver);
        reservationPage = new ReservationPage(driver);
        fileReader = new FileReader("BookingTestDATA.xlsx", "sheet1");
    }

    @Test
    public void verifyTheDisplayedHotelName() throws InterruptedException {
        homePage.closePopUp();
        homePage.enterNeededCityInSearch(fileReader.getData(1, 0));
        homePage.clickOnDatePickerButton();
        homePage.chooseDateByDay(fileReader.getData(1, 1));
        homePage.chooseDateByDay(fileReader.getData(1, 2));
        homePage.clickSearchButton();
        searchResultsPage.clickOnSeeAvailabilityButton(fileReader.getData(1, 3));
        detailsPage.clickBedRadioButton("1");
        detailsPage.selectTheAmount(fileReader.getData(1, 4));
        detailsPage.clickIWillReserveButton();
        Assert.assertEquals(reservationPage.getTheHotelName(), fileReader.getData(1, 3));

    }
}
