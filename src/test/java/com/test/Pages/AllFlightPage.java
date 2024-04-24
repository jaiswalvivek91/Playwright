package com.test.Pages;

import com.microsoft.playwright.Page;
import com.test.utils.BaseTestClass_PW;

public class AllFlightPage extends BaseTestClass_PW {
    public static Page page;

    String btnChooseThisFlight = "[value='Choose This Flight']";


    public AllFlightPage(Page page){
        this.page = page;
    }

    public void clickChooseThisFlightButton(){
        page.click(btnChooseThisFlight);
    }

}
