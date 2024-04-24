package com.test.utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import com.test.Pages.BaseFlight;


public class BaseTestClass_PW extends BaseFlight {


    public static Playwright playwright;
    public static BrowserType browserType;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;


    public void launchBrowser(String browserName){
        try(Playwright pw = Playwright.create() ){

            switch (browserName) {
                case "chrome":
                    browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                    break;
                case "chromium":
                    browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                case "firefox":
                    browser = pw.firefox().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                    break;
                case "safari":
                    browser = pw.webkit().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                    break;
                default:
                    break;
            }
            page = browser.newPage();

        }


    }

    public void launchPlaywright(String browserName, String headless) {
        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("msedge")
                || browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }
        if (headless.equalsIgnoreCase("true")) {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
        }
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 700));
        context.close();
        page = browser.newPage();
        System.out.println("**** Project Browser Name and Version is : " + browserName + " : " + browser.version());
    }

    public void launchApplication(String url) {
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }

    public boolean verifyVMOApplicationLoginScreen() {
        page.waitForSelector("[data-qa='cemaxumuwu']");
        return true;

        /** or
         page.waitForSelector("[data-qa='cemaxumuwu']");
         return page.isVisible("[data-qa='cemaxumuwu']");
         **/
    }

    public void closePlaywright() {
        page.close();
        browser.close();
        playwright.close();
    }

}
