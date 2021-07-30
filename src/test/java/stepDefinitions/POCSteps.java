package stepDefinitions;

import configuartion.ConfigurationType;
import configuartion.SelectorConfigurationFactory;
import configuartion.SelectorDefinition;
import gherkin.lexer.Pa;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.RandomUtils;
import utils.StepsHelper;
import utils.WebBrowser;
import utils.readPropFile;


import java.util.List;

public class POCSteps {

    WebDriver driver;
    public StepsHelper helper;
    private SelectorDefinition selectorDefinition;
    private String Path = System.getProperty("user.dir");

    public POCSteps() throws Throwable {

        this.driver = WebBrowser.getDriver();
    }

    @Before
    public void setUp(Scenario scenario) {

        selectorDefinition = SelectorConfigurationFactory
                .getConfiguration(ConfigurationType.CSV)
                .readDefinition(Path + "/Elements.csv");
        helper = new StepsHelper(WebBrowser.getDriver(), selectorDefinition);
    }

    @When("I click element {}")
    public void i_click_xyz(String Element) throws Throwable {

        WebElement element = driver.findElement(selectorDefinition.getLocator(Element));
        element.click();

    }


    @When("I click on {} using JS")
    public void i_clickByJS(String Element) throws Throwable {

        helper.ClickByJS(Element);
    }

    @When("I enter {} in {}")
    public void iEnterAbcInXyz(String data, String Field) throws Throwable {

        helper.sendData(Field, data);
    }

    @When("I enter random Email in {}")
    public void iEnterEmail(String Field) throws Throwable {

        helper.sendData(Field, RandomUtils.generateEmail());
    }

    @When("I enter random {} of {} in {}")
    public void iEnterRandomInXyz(String data, int length, String Field) throws Throwable {

        if (data.equals("String")) {
            helper.sendData(Field, RandomUtils.generateString(length, "char"));
        } else if (data.equals("Number")) {
            helper.sendData(Field, RandomUtils.generateString(length, "num"));
        }
    }

    @Then("I should see current page URL contains {}")
    public void iShouldSeeCurrentPageURLContainsXyz(String URL) throws Throwable {

        Assert.assertTrue(helper.getCurrentPageURL().contains(URL));
    }

    @Then("I should see {} text is {}")
    public void iShouldSeeAbcFieldTextIsAbc(String Field, String text) throws Throwable {

        Assert.assertEquals(helper.getElementText(Field), text);
    }

    @Then("I should see {} is displayed")
    public void iShouldSeeAbcIsDisplayed(String element) throws Throwable {

        Assert.assertTrue(helper.isElementDisplayed(element));
    }

    @When("I select {} from {}")
    public void iSelectXyzFromAbc(String text, String Field) throws Throwable {
        //dropdown
        helper.selectOption(Field, text);
    }

    @Then("I should see elements are displayed")
    public void iShouldSeeElementsAreDisplayed(DataTable table) throws Throwable {

        List<String> element = table.asList(String.class);
        for (String s : element) {
            Assert.assertTrue(helper.isElementDisplayed(s));
        }
    }

    @When("I scroll to {}")
    public void iScrollToAbc(String element) throws Throwable {
    }

    @Then("I should see {} is selected")
    public void iShouldSeeXyzIsSelected(String element) throws Throwable {
        // element.isSelected();
    }

    @And("I wait for {}")
    public void iWaitForElement(String Element) throws Throwable {

        helper.waitForElementToBeVisible(Element, 60);
    }

    @When("I hover over {}")
    public void iHoverOverElement(String element) throws Throwable {

        helper.mouseHover(element);
    }

    @When("I get {} from {}")
    public void iGetPlaceholderFromElement(String Attribute, String Element) throws Throwable {

        helper.getAttribute(Element, Attribute);
    }

    @And("I select current window")
    public void iSelectCurrentWindow() throws Throwable {

        helper.selectNewWindow();
    }

    @Then("I should see element text are")
    public void iShouldSeeElementTextAre(DataTable table) {

        for (int i = 0; i < table.height(); i++) {

            Assert.assertEquals(readPropFile.getText(table.column(1).get(i)), helper.getElementText(table.column(0).get(i)));

        }


    }
}
