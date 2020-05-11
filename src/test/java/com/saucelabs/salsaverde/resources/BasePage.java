package com.saucelabs.salsaverde.resources;

import com.saucelabs.salsaverde.pages.PageObject;
import lombok.Getter;

public class BasePage extends PageObject {
    @Getter private String baseUrl = "https://www.saucedemo.com";
}
