package RequiredTests;

import Base.Base;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.util.Locale;

import static org.testng.Assert.*;

public class Tests extends Base {

    @BeforeMethod
    public void setConfig(){
        homePage.changeLanguage();
        homePage.openCountriesMenu();

    }
    @DataProvider(name = "testData")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONdata
                (System.getProperty("user.dir") + "/data/TasksData.json"
                        , "Tasks Data", 2);
    }

    @Test(dataProvider = "testData")
    public void validatePackageType(String country,String currency){
        homePage.selectCountry(country);
        String expectedPackageType= homePage.getMostPopularPackageType();
        String actualPackageType= homePage.getPackageType();
        Assert.assertEquals(expectedPackageType.toUpperCase(Locale.ROOT),actualPackageType,"incorrect package type");
    }
    @Test(dataProvider="testData")
    public void validateCurrency(String country,String currency){
        homePage.selectCountry(country);
        String cost=homePage.getCurrency();
        System.out.println("currency  "+cost);
        Assert.assertTrue(cost.contains(currency));
    }
}
