package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By countryMenuId = By.xpath("//span[@id='arrow']");
    private By languageId = By.id("translation-btn");
    private By expectedPackageType = By.xpath("//div[@class='trial-description']/h4");
    private By mostPopularPackageType = By.xpath("//div[contains(text(),'Most Popular')]/../strong");
    private By currencyLocator = By.xpath("(//div[@class='trial-cost'])[1]");

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void openCountriesMenu() {
        waitFor(countryMenuId);
        driver.findElement(countryMenuId).click();
    }

    public void changeLanguage() {
        waitFor(languageId);
        driver.findElement(languageId).click();
    }

    public void selectCountry(String country) {
        By locator = By.xpath("(//span[contains(text(),'" + country + "')])[1]");
        waitFor(locator);
        driver.findElement(locator).click();
    }

    public String getMostPopularPackageType() {
        waitFor(mostPopularPackageType);
        return driver.findElement(mostPopularPackageType).getText();
    }

    public String getPackageType() {
        return driver.findElement(expectedPackageType).getText();
    }
    public String getCurrency(){
       return driver.findElement(currencyLocator).getText();
    }
}
