package RequiredTests;

import Base.TestBase;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.util.Locale;

import static org.testng.AssertJUnit.assertTrue;

public class RequiredTests extends TestBase {

    @BeforeMethod
    public void setConfig() {
        homePage.changeLanguage();
        homePage.openCountriesMenu();

    }

    @DataProvider(name = "testData")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONdata
                (System.getProperty("user.dir") + "/data/Assignment_Data.json"
                        , "Tasks Data", 8);
    }

    // ******************** Validate The Packages Types ********************
    @Test(dataProvider = "testData", priority = 1)
    public void validatePackageTypes(String country, String currency, String firstPackage,
                                     String secondPackage, String thirdPackage, String LitePrice,
                                     String ClassicPrice, String PremiumPrice) {

        homePage.selectCountry(country);

        // Validate the first Subscription Package Type
        String ActualFirstPackage = homePage.getFirstPackageTitle();
        Assert.assertEquals(firstPackage, ActualFirstPackage, "incorrect First package type");

        // Validate the Second Subscription Package Type
        String ActualSecondPackage = homePage.getSecondPackageTitle();
        Assert.assertEquals(secondPackage, ActualSecondPackage, "incorrect Second package type");

        // Validate the Third Subscription Package Type
        String ActualThirdPackage = homePage.getThirdPackageTitle();
        Assert.assertEquals(thirdPackage, ActualThirdPackage, "incorrect Third package type");

    }


    // ******************** Validate Currency of Each Country ********************
    @Test(dataProvider = "testData", priority = 2)
    public void validateCurrency(String country, String currency, String firstPackage,
                                 String secondPackage, String thirdPackage, String LitePrice,
                                 String ClassicPrice, String PremiumPrice) {

        homePage.selectCountry(country);

        // Validate the first Subscription Package Currency
        String ActualCurrency = homePage.getActualCurrency();
        assertTrue(ActualCurrency.contains(currency));

    }

    // ******************** Validate The Price for each Country ********************
    @Test(dataProvider = "testData", priority = 3)
    public void validatePrice(String country, String currency, String firstPackage,
                              String secondPackage, String thirdPackage, String LitePrice,
                              String ClassicPrice, String PremiumPrice) {

        homePage.selectCountry(country);

        // Validate the first Subscription Package Price
        String ActualFirstPackagePrice = homePage.getFirstPackagePrice();
        System.out.println("******************** LITE Package Price > " + ActualFirstPackagePrice);
        Assert.assertEquals(LitePrice, ActualFirstPackagePrice, "incorrect First package Price");

        // Validate the Second Subscription Package Price
        String ActualSecondPackagePrice = homePage.getSecondPackagePrice();
        System.out.println("******************** CLASSIC Package Price > " + ActualSecondPackagePrice);
        Assert.assertEquals(ClassicPrice, ActualSecondPackagePrice, "incorrect Second package Price");

        // Validate the Third Subscription Package Price
        String ActualThirdPackagePrice = homePage.getThirdPackagePrice();
        System.out.println("******************** PREMIUM Package Price > " + ActualThirdPackagePrice);
        Assert.assertEquals(PremiumPrice, ActualThirdPackagePrice, "incorrect Third package Price");

    }
}
