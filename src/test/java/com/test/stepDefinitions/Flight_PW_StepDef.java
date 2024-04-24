package com.test.stepDefinitions;

import com.test.Pages.*;
import com.test.utils.BaseTestClass_PW;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;

public class Flight_PW_StepDef extends BaseTestClass_PW {

    LoginVWOPage loginPage = new LoginVWOPage(page);
    WelcomeFlightPage welcomeFlightPage = new WelcomeFlightPage(page);
    AllFlightPage allFlightPage = new AllFlightPage(page);
    UserDetailsPage userDetailsPage = new UserDetailsPage(page);
    FlightConfirmationPage flightConfirmationPage =  new FlightConfirmationPage(page);


    @Before
    public void setUp(){
        launchPlaywright(prop.getProperty("browser"),prop.getProperty("headless"));
    }

    @After
    public void closeBrowser(){
        closePlaywright();
    }

    @Given("User navigate to VMO site")
    public void userNavigateToVMOSite() {
        launchApplication("https://app.vwo.com/#/login");
    }

    @And("user check if VMO site is loaded or not")
    public void userCheckIfVMOSiteIsLoadedOrNot() {
        Assert.assertTrue(verifyVMOApplicationLoginScreen());
    }

    @When("user enter username and password")
    public void userEnterUsernameAndPassword() {
        loginPage = new LoginVWOPage(page);
        boolean isLoginSuccess = loginPage.login("93npu2yyb0@esiix.com","Wingify@123");
        Assert.assertEquals(isLoginSuccess, true);
    }


    @And("user close the browser")
    public void userCloseTheBrowser() {
        closePlaywright();
    }

    @Given("User navigates to flight booking application")
    public void userNavigatesToFlightBookingApplication() {
        launchApplication(prop.getProperty("url"));
    }

    @And("user check if flight booking application is loaded or not")
    public void userCheckIfFlightBookingApplicationIsLoadedOrNot() {
        welcomeFlightPage.loginIsSuccessful();
    }

    @When("user selects {string} and {string} city")
    public void userSelectsAndCity(String fromCity, String toCity) {
        welcomeFlightPage.selectFromCity(fromCity);
        welcomeFlightPage.selectToCity(toCity);
    }

    @And("click on Find Flights button")
    public void clickOnFindFlightsButton() {
        welcomeFlightPage.clickFlighSearchButton();
    }

    @And("user choose flight to reserve ticket")
    public void userChooseFlightToReserveTicket() {
        allFlightPage.clickChooseThisFlightButton();
    }

    @And("user enters all passenger details")
    public void userEntersAllPassengerDetails() {
        userDetailsPage.enterName("Vivek Jaiswal");
        userDetailsPage.enterAddress("123 street");
        userDetailsPage.enterCity("Bangalore");
        userDetailsPage.selectCardType("American Express");
        userDetailsPage.enterCCNumber("12345");
        userDetailsPage.enterCCMonth("12");
        userDetailsPage.enterCCYear("2021");
        userDetailsPage.enterZipCode("12344");
        userDetailsPage.enterNameOnCard("Jaiswal");
        userDetailsPage.enterState("Karnataka");
    }

    @And("clicks on Purchase Flight button")
    public void clicksOnPurchaseFlightButton() {
        userDetailsPage.clickPurchaseFlight();
    }

    @Then("user validates purchase details")
    public void userValidatesPurchaseDetails() {
        String pid=flightConfirmationPage.getPurchaseID();
        Assert.assertTrue("purchase ID generated= "+pid,pid!=null);
        Assert.assertTrue(flightConfirmationPage.getThankuMsg());
    }

    @Then("User validates {string} and {string} cities available")
    public void userValidatesAndCitiesAvailable(String fromCities, String toCities) {
        welcomeFlightPage.verifyFromDropDownOptions(fromCities);
        welcomeFlightPage.verifyToDropDownOptions(toCities);
    }
}
