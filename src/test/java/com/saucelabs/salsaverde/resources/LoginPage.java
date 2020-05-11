package com.saucelabs.salsaverde.resources;

import com.saucelabs.salsaverde.elements.Element;
import com.saucelabs.salsaverde.pages.OnPage;
import com.saucelabs.salsaverde.pages.PageObject;
import org.openqa.selenium.By;

@OnPage(url="https://www.saucedemo.com/", title="Swag Labs", elements={"usernameField", "passwordField"})
public class LoginPage extends PageObject {
    private Element usernameField = browser.element(By.id("user-name"));
    private Element passwordField = browser.element(By.id("password"));
    private Element submitButton = browser.element(By.className("btn_action"));

    public void login(String username, String password) {
        usernameField.setText(username);
        passwordField.setText(password);
        submitButton.click();
    }

    public void login(UserData user) {
        usernameField.setText(user.getUsername());
        passwordField.setText(user.getPassword());
        submitButton.click();
    }
}
