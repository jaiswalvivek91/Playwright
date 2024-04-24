package com.test.Pages;

import com.microsoft.playwright.Page;
import com.test.utils.BaseTestClass_PW;

public class FlightConfirmationPage extends BaseTestClass_PW {
    public static Page page;

    public FlightConfirmationPage(Page page){
        this.page =page;
    }


    String strThankYouMsg = "Thank you for your purchase today!";
    String strPurchaseId = "xpath=.//td[text()='Id']//following-sibling::td";
    String strStatus = "xpath=.//td[text()='Status']//following-sibling::td";

    public String getPurchaseID(){
        String pid = page.locator(strPurchaseId).textContent();
        return pid;
    }

    public boolean getThankuMsg(){
        return page.getByText(strThankYouMsg).isVisible();
    }

}
