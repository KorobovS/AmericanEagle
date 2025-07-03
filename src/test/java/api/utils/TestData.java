package api.utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "dataShipping")
    public static Object[][] freeShipping() {
        return new Object[][]{{1, 7.95}, {2, 0.0}};
    }
}
