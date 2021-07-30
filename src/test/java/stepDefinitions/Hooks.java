package stepDefinitions;

import io.cucumber.java.After;
import utils.WebBrowser;


public class Hooks extends WebBrowser {


    @After
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
