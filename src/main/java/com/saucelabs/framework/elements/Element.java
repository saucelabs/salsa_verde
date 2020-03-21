package com.saucelabs.framework.elements;

import com.saucelabs.framework.Browser;
import com.saucelabs.framework.exceptions.ElementNotEnabledException;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Element {
    @Getter private By locator;
    @Getter private Browser browser;
    protected WebElement webElement;
    private Synchronizer synchronizer = new Synchronizer();


    public Element(Browser browser, By locator) {
        this.locator = locator;
        this.browser = browser;
    }

    //
    // Predicate Methods
    //

    // This will always make a wire call
    public boolean doesExist() {
        reset();
        locate();
        return isLocated();
    }

    public boolean isPresent() {
        locate();
        return isLocated() && webElement.isDisplayed();
    }

    public boolean isEnabled() {
        validateExistence();
        return webElement.isEnabled();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!this.getClass().isInstance(o)) {
            return false;
        } else {
            try {
                Element c = (Element) o;
                return c.getLocator().equals(locator);
            } catch (ClassCastException e) {
                return false;
            }
        }
    }

    //
    // Information Methods
    //

    public String getText() {
        validateExistence();
        return webElement.getText();
    }

    //
    // Action Methods
    //

    // TODO: Move Enabled Check to a Button subclass
    public void click() {
        synchronizer.act(this, this::validateEnabled);
        synchronizer.act(this, () -> webElement.click());
    }

    //
    // Private Methods
    //

    void locate() {
        if (this.webElement == null) {
            try {
                this.webElement = browser.getDriver().findElement(locator);
            } catch (NoSuchElementException ignored) {
            }
        }
    }

    private boolean isLocated() {
        return this.webElement != null;
    }

    private void reset() {
        this.webElement = null;
    }

    void validateExistence() {
        locate();
        if (!isLocated()) {
            throw new NoSuchElementException("Cannot locate an element using " + locator);
        }
    }

    void validateEnabled() {
        locate();
        if (!isEnabled()) {
            throw new ElementNotEnabledException("Element needs to be enabled to interact with it " + locator);
        }
    }
}
