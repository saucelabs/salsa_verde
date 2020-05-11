package com.saucelabs.salsaverde;

import com.saucelabs.salsaverde.elements.Executor;
import com.saucelabs.salsaverde.junit.BaseTestWatcher;
import com.saucelabs.salsaverde.junit.SauceTestWatcher;
import com.saucelabs.salsaverde.pages.PageObject;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
    public Browser browser;

    @Rule
    public BaseTestWatcher testWatcher = new SauceTestWatcher();

    @Before
    public void setup() {
//        browser = new Browser();
        browser = new Browser((RemoteWebDriver) testWatcher.getDriver());
        PageObject.setBrowser(browser);
        Executor.waitTime = 5;
    }

//    @After
//    public void tearDown() {
//        browser.quit();
//    }
}
