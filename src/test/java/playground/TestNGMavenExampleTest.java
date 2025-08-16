package playground;

import data.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities_qatek.SqlConnector;

import java.sql.ResultSet;

public class TestNGMavenExampleTest {
    private static final Logger LOGGER = LogManager.getLogger(TestNGMavenExampleTest.class);

    @Test(dataProvider = "MultipleColumnValues", dataProviderClass = DataStore.class)
    public void run(String name, String state, int zipCode){
        System.out.println("Name is: " + name);
        System.out.println("State is: " + state);
        System.out.println("Zip Code is: " + zipCode);
    }
}
