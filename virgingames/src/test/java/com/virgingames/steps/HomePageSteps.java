package com.virgingames.steps;

import com.virgingames.pages.HomePage;
import com.virgingames.pages.ModernSlaveryPolicyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps {
    @Given("I Launch browser")
    public void iLaunchBrowser() {
    }

    @When("I Navigate to URL {string}")
    public void iNavigateToURL(String baseUrl) {
        System.out.println(baseUrl);
    }

    @And("I click on Manage All Cookies button")
    public void iClickOnManageAllCookiesButton() {
        new HomePage().clickOnManageAllCookies();
    }

    @Then("I Verify that home page is visible successfully")
    public void iVerifyThatHomePageIsVisibleSuccessfully() {
        new HomePage().verifyNavigateToHomePage();
    }

    @When("I Scroll down to footer")
    public void iScrollDownToFooter() {
        new HomePage().scrollDownToFooter();
    }

    @Then("I Verify text {string}")
    public void iVerifyTextModernSlaveryStatement(String text) {
        Assert.assertEquals(new HomePage().verifyModernSlaveryStatementTextOnHomePage(), text, "Error Message");
    }

    @And("I click on Modern Slavery Statement")
    public void iClickOnModernSlaveryStatement() {
        new HomePage().clickOnModernSlaveryStatement();
    }

    @Then("I Navigate to Modern Slavery Policy Page")
    public void iNavigateToModernSlaveryPolicyPage() {
        new HomePage().navigateToModernSlaveryPolicyPage();
    }

    @Then("I Verify header message {string} is visible on page")
    public void iVerifyHeaderMessageMODERNSLAVERYACTTRANSPARENCYSTATEMENTIsVisibleOnPage(String message) {
        String expectedText = "MODERN SLAVERY ACT TRANSPARENCY STATEMENT";
        Assert.assertEquals(new ModernSlaveryPolicyPage().verifyHeaderMessage(), expectedText);
    }
}
