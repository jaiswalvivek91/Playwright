package com.test.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.test.utils.BaseTestClass_PW;
import org.junit.Assert;

import java.util.List;


public class WelcomeFlightPage extends BaseTestClass_PW {

    public static Page page;

    String strWelcomeMsg = "Welcome to the Simple Travel Agency!";
    String lstFromPort = "[name='fromPort']";
    String lstToPort = "[name='toPort']";
    String btnFindFlights = "[value='Find Flights']";

    String lstFromPortOptions = "xpath=.//select[@name='fromPort']/option";
    String lstToPortOptions = "xpath=.//select[@name='toPort']/option";

    public WelcomeFlightPage(Page page) {
        this.page = page;
    }

    public boolean loginIsSuccessful() {
        boolean isLoginSuccess = false;

        page.waitForSelector(lstFromPort).isVisible();
        Assert.assertTrue(page.getByText(strWelcomeMsg).isVisible());

        boolean isEnabled = page.isEnabled(lstFromPort);
        if (isEnabled) {
            isLoginSuccess = true;
        }
        return isLoginSuccess;
    }

    public void selectFromCity(String strFromCity){
        page.locator(lstFromPort).selectOption(strFromCity);
    }
    public void selectToCity(String strToCity){
        page.locator(lstToPort).selectOption(strToCity);
    }
    public void clickFlighSearchButton(){
        page.click(btnFindFlights);
    }
    public void verifyDropDownOptions(String strSelectOption, String strDropDown){
        Locator loc = page.locator(strSelectOption);
        List<String> fromOptions = loc.allTextContents();
        boolean flagFail = false;

        String[] optionsFrom= strDropDown.split(",");
        for (String option:optionsFrom) {
            if(fromOptions.contains(option)){
                Assert.assertTrue("all options available",true);
            }
            else{
                System.out.println(option+" options NOT available");
                flagFail = true;
            }

        }

        if (flagFail) {
            Assert.assertTrue(false);
        }
    }

    public void verifyFromDropDownOptions(String strFromDropDownOptions){
        verifyDropDownOptions(lstFromPortOptions, strFromDropDownOptions);
    }
    public void verifyToDropDownOptions(String strToDropDownOptions){
        verifyDropDownOptions(lstToPortOptions, strToDropDownOptions);
    }
}
