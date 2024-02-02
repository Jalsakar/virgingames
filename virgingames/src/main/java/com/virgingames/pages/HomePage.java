package com.virgingames.pages;

import com.virgingames.propertyreader.PropertyReader;
import com.virgingames.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

public class HomePage extends Utility {

    //This code initializes a logger object named log for the HomePage class using Apache Log4j2.
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //========================== Locators ============================//

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Allow all cookies']")
    WebElement manageCookies;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Modern Slavery Statement']")
    WebElement modernSlaveryStatementText;

    //======================== Methods ================================//

    public void clickOnManageAllCookies(){
        clickOnElement(manageCookies);
    }

    public void verifyNavigateToHomePage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = PropertyReader.getInstance().getProperty("baseUrl");
        log.info("verifying homepage url.");
        AssertJUnit.assertEquals(expectedUrl, actualUrl);
    }

    public void scrollDownToFooter() {
        log.info("Scroll Down to Footer");
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(modernSlaveryStatementText);
    }

    public String verifyModernSlaveryStatementTextOnHomePage() {
        log.info("Verify Modern Slavery Statement Text on HomePage" + modernSlaveryStatementText.toString());
        return getTextFromElement(modernSlaveryStatementText);
    }

    public void clickOnModernSlaveryStatement() {
        log.info("Click on Modern Slavery Statement" + modernSlaveryStatementText.toString());
        clickOnElement(modernSlaveryStatementText);
    }

    public void navigateToModernSlaveryPolicyPage() {
        log.info("Verifying Navigated to Modern Slavery Policy Page");
        driver.navigate().to("https://www.virgingames.com/modern-slavery-policy");
    }
}
