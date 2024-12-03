package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailsPage;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.FileReader;

import java.io.IOException;

public class DetailsTest {

    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private DetailsPage detailsPage;
    private FileReader fileReader;

    @BeforeMethod
    public void setup() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        detailsPage = new DetailsPage(driver);
        fileReader = new FileReader("BookingTestDATA.xlsx", "sheet1");

    }

    @Test
    public void VerifyCheckInDate() throws InterruptedException {
        homePage.closePopUp();
        homePage.enterNeededCityInSearch(fileReader.getData(1, 0));
        homePage.clickOnDatePickerButton();
        homePage.chooseDateByDay(fileReader.getData(1, 1));
        homePage.chooseDateByDay(fileReader.getData(1, 2));
        homePage.clickSearchButton();
        searchResultsPage.clickOnSeeAvailabilityButton(fileReader.getData(1, 3));
        Assert.assertEquals(detailsPage.getCheckInDate(), fileReader.getData(1, 1));
    }

    @Test
    public void VerifyCheckOutDate() throws InterruptedException {
        homePage.closePopUp();
        homePage.enterNeededCityInSearch(fileReader.getData(1, 0));
        homePage.clickOnDatePickerButton();
        homePage.chooseDateByDay(fileReader.getData(1, 1));
        homePage.chooseDateByDay(fileReader.getData(1, 2));
        homePage.clickSearchButton();
        searchResultsPage.clickOnSeeAvailabilityButton(fileReader.getData(1, 3));
        Assert.assertEquals(detailsPage.getCheckOutDate(), fileReader.getData(1, 2));
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
