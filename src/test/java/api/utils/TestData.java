package api.utils;

import org.testng.annotations.DataProvider;

import static api.utils.Constants.BagData.SKUID_MEN;
import static api.utils.Constants.BagData.SKUID_WOMEN;

public class TestData {

    @DataProvider(name = "dataShipping")
    public static Object[][] freeShipping() {
        return new Object[][]{{1, 7.95}, {2, 0.0}};
    }

    @DataProvider(name = "dataUpdate")
    public static Object[][] update() {
        return new Object[][]{{SKUID_MEN, 1}, {SKUID_WOMEN, 11}};
    }
}
