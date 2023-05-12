package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By countryMenuId = By.xpath("//span[@id='arrow']");
    private By languageId = By.id("translation-btn");
    private By FirstPackageTitle = By.id("name-lite");
    private By SecondPackageTitle = By.id("name-classic");
    private By ThirdPackageTitle = By.id("name-premium");
    private By ActualCurrencyElement = By.xpath("(//div[@class='price']/i)[1]");
    private By FirstPackagePrice = By.xpath("//div[@id='currency-lite']/b");
    private By SecondPackagePrice = By.xpath("//div[@id='currency-classic']/b");
    private By ThirdPackagePrice = By.xpath("//div[@id='currency-premium']/b");


    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getFirstPackageTitle() {
        waitFor(FirstPackageTitle);
        return driver.findElement(FirstPackageTitle).getText();
    }

    public String getSecondPackageTitle() {
        waitFor(SecondPackageTitle);
        return driver.findElement(SecondPackageTitle).getText();
    }

    public String getThirdPackageTitle() {
        waitFor(ThirdPackageTitle);
        return driver.findElement(ThirdPackageTitle).getText();
    }

    public String getActualCurrency() {
        waitFor(ActualCurrencyElement);
        return driver.findElement(ActualCurrencyElement).getText();
    }

    public String getFirstPackagePrice() {
        waitFor(FirstPackagePrice);
        return driver.findElement(FirstPackagePrice).getText();
    }

    public String getSecondPackagePrice() {
        waitFor(SecondPackagePrice);
        return driver.findElement(SecondPackagePrice).getText();
    }

    public String getThirdPackagePrice() {
        waitFor(ThirdPackagePrice);
        return driver.findElement(ThirdPackagePrice).getText();
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
}
