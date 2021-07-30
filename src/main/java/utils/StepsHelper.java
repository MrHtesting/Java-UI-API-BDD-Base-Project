package utils;

import configuartion.SelectorDefinition;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;


public class StepsHelper {

    private WebDriver driver;
    final private SelectorDefinition definition;

    public StepsHelper(WebDriver driver, SelectorDefinition definition) {
        this.driver = driver;
        this.definition = definition;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPageTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }


    public boolean checkCurrentPageName(String pageName) {
        try {
            driver.findElement(By.xpath("//h4[contains(text(),'" + pageName + "')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(String id) {
        try {
            if (driver.findElement(definition.getLocator(id)).isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void clickAnyButtonByText(String textToClick) {
        driver.findElement(By.xpath("//button[text()='" + textToClick + "']")).click();
    }

    public void clickAnyLinkByText2(String linkToClick) {
        driver.findElement(By.xpath("//a[text()='" + linkToClick + "']")).click();
    }

    public void clickAnyLinkByText3(String linkToClick) {
        driver.findElement(By.xpath("//*[text()='" + linkToClick + "']")).click();
    }

    public void clickAnyLinkByText(String linkToClick) {
        driver.findElement(By.xpath("//a/span[text()='" + linkToClick + "']")).click();
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageHeader(String pageTitle) {
        return driver.findElement(By.xpath("//h3[text()='" + pageTitle + "']")).getText();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getElementText(String Field) {
        WebElement element = driver.findElement(definition.getLocator(Field));
        return element.getText();
    }

    public void mouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void mouseHover(String Field) {
        WebElement element = driver.findElement(definition.getLocator(Field));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void clickAnyTileByText(String tileToClick) {
        driver.findElement(By.xpath("//h2[text()='" + tileToClick + "']")).click();
    }

    public void selectNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public boolean isTitlePresent(String expectedTitle) {
        List<WebElement> list_PopupTitles = driver.findElements(By.xpath("//h4"));
        for (WebElement element : list_PopupTitles) {
            if (element.getText().contains(expectedTitle)) {
                return true;
            }
        }
        return false;
    }

    public void javascriptClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void sendData(WebElement element, String inputData) {
        element.sendKeys(inputData);
    }

    public void sendData(String Field, String inputData) {
        WebElement element = driver.findElement(definition.getLocator(Field));
        sendData(element, inputData);
    }

    public void hoverAndClick(String Field, String click) throws InterruptedException {
        WebElement webElementToHover = driver.findElement(definition.getLocator(Field));
        Actions action = new Actions(driver);
        action.moveToElement(webElementToHover).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText(click)).click();
    }

    public void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public Boolean waitForElementToBeVisible(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean waitForElementToBeVisible(String Field, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(definition.getLocator(Field)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isHeaderTextDisplayed(String title) {
        try {
            if (driver.findElement(By.xpath("//*[contains(text(), '" + title.trim() + "')]")).isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean isListTextDisplayed(String text) {
        return driver.findElement(By.xpath("//li[contains(text(), '" + text.trim() + "')]")).isDisplayed();
    }

    public boolean isLinksDisplayed(String link) {
        return driver.findElement(By.linkText(link)).isDisplayed();
    }

    public String getAnyElementTxt(WebElement element) {
        return element.getText();
    }

    public String getXhtmlPageTitle() {
        return driver.findElement(By.xpath("//xhtml:head//xhtml:title")).getText();
    }

    public String getBoldText(String text) {
        return driver.findElement(By.xpath("//p/strong[contains(text(),'" + text + "')]")).getText();
    }

    public String getAttribute(String Field, String attribute) {
        return driver.findElement(definition.getLocator(Field)).getAttribute(attribute);
    }

    public WebElement getOptions(String Field, int i) {
        WebElement selectElement = driver.findElement(definition.getLocator(Field));
        Select select = new Select(selectElement);
        List<WebElement> allOptions = select.getOptions();
        return allOptions.get(i);
    }

    public void selectOption(String Field, String option) {
        WebElement selectElement = driver.findElement(definition.getLocator(Field));
        Select select = new Select(selectElement);
        select.selectByValue(option);
    }

//    public  void WaitForElement(WebElement element,int time){
//
//        WebDriverWait wait = new WebDriverWait(driver,time);
//
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//
//
//    }

    public void ClickByJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void ClickByJS(String Field) {
        WebElement element = driver.findElement(definition.getLocator(Field));
        ClickByJS(element);
    }


}
	


