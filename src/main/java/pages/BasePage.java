package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void handleOptionalPopup(By closeButtonLocator) {
        try {
            WebElement closeButton = getElement(closeButtonLocator); // Reuse your existing method
            if (closeButton != null && closeButton.isDisplayed()) {
                closeButton.click();
            } else {
                System.out.println("Close button not found, no popup to handle.");
            }
        } catch (Exception e) {
            System.out.println("Error while handling popup: " + e.getMessage());
        }
    }

    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.visibilityOf(getElement(locator))).click();
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOf(getElement(locator))).sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).getText();
    }

    public void clickEnter(By locator, String text) {
        getElement(locator).sendKeys(Keys.ENTER);
    }

    public void selectByVisibleText(By locator, String text) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }
}
