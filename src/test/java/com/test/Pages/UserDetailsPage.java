package com.test.Pages;

import com.microsoft.playwright.Page;
import com.test.utils.BaseTestClass_PW;

public class UserDetailsPage extends BaseTestClass_PW {
    public static Page page;

    public UserDetailsPage(Page page){
        this.page = page;
    }

    String inputName = "#inputName";
    String inputAddress = "#address";
    String inputCity = "#city";
    String inputState = "#state";
    String inputZipCode = "#zipCode";
    String lstCardType = "#cardType";
    String inputCreditCardNumber = "#creditCardNumber";
    String inputMonth = "#creditCardMonth";
    String inputYear = "#creditCardYear";
    String inputNameOnCard = "#nameOnCard";
//    String btnPurchaseFlight = ".btn btn-primary";
    String btnPurchaseFlight = "xpath=.//input[@class='btn btn-primary']";

    public void enterName(String strName){
        //page.locator(inputName).fill(strName);
        page.click(inputName);
        page.keyboard().type(strName);
    }
    public void enterAddress(String strAddress){
        page.fill(inputAddress,strAddress);
    }
    public void enterCity(String strCity){
        page.fill(inputCity,strCity);
    }
    public void enterState(String strState){
        page.fill(inputState,strState);
    }
    public void enterZipCode(String strZipCode){
        page.fill(inputZipCode,strZipCode);
    }
    public void selectCardType(String strCardType){
        page.selectOption(lstCardType,strCardType);
    }
    public void enterCCNumber(String strCreditCardNumber){
        page.fill(inputCreditCardNumber,strCreditCardNumber);
    }
    public void enterCCMonth(String strMonth){
        page.fill(inputMonth,strMonth);
    }
    public void enterCCYear(String strYear){
        page.fill(inputYear,strYear);
    }
    public void enterNameOnCard(String strNameOnCard){
        page.fill(inputNameOnCard,strNameOnCard);
    }
    public void clickPurchaseFlight(){
        page.click(btnPurchaseFlight);
    }
}
