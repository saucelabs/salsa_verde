package com.saucelabs.salsaverde.resources;

import com.saucelabs.salsaverde.elements.Element;
import com.saucelabs.salsaverde.pages.OnPage;
import com.saucelabs.salsaverde.pages.PageObject;
import org.openqa.selenium.By;

@OnPage(url="https://www.saucedemo.com/", elements={"usernameField", "notThere"})
public class BadElementsPage extends PageObject {
    private Element usernameField = browser.element(By.id("user-name"));
    private Element notThere = browser.element(By.id("not-there"));
}
