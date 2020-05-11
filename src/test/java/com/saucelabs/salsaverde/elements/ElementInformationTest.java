package com.saucelabs.salsaverde.elements;

import com.saucelabs.salsaverde.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.time.Instant;

import static junit.framework.TestCase.fail;

public class ElementInformationTest extends BaseTest {
    @Test
    public void getTextElementExistsAndVisible() {
        browser.goTo("http://watir.com/examples/non_control_elements.html");
        Element element = browser.element(By.id("footer"));

        Assert.assertEquals("This is a footer.", element.getText());
    }

    @Test
    public void getTextElementWhenStale() {
        browser.goTo("http://watir.com/examples/non_control_elements.html");
        Element element = browser.element(By.id("footer"));
        element.doesExist();
        browser.refresh();

        try {
            element.getText();
            Assert.assertTrue(true);
        } catch (StaleElementReferenceException e) {
            Assert.fail("Getting text should re-look up stale elements");
        }
   }

    @Test()
    public void getTextErrorsWhenElementNeverExistsAfterWait() {
        Element element = browser.element(By.id("not-there"));

        Instant start = Instant.now();
        try {
            element.getText();
            fail("Expected a NoSuchElementException that was never thrown");
        } catch (NoSuchElementException e) {
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            Assert.assertTrue(duration > 5000);
        }
    }

    // TODO - need to update testing site to just add exists not exists & visible combo
    @Test()
    public void getTextElementEventuallyExistsAfterWait() {
        browser.goTo("http://watir.com/examples/wait.html");
        Element element = browser.element(By.id("foobar"));

        Instant start = Instant.now();
        browser.element(By.id("add_foobar")).click();
        String text = element.getText();
        Instant finish = Instant.now();
        long duration = Duration.between(start, finish).toMillis();

        Assert.assertEquals("", text);
        Assert.assertTrue(duration > 600);
        Assert.assertTrue(duration < 5000);
    }

    @Test
    public void getTextIsEmptyWhenElementExistsAndNotVisibleWithoutWaiting() {
        browser.goTo("http://watir.com/examples/wait.html");
        Element element = browser.element(By.id("bar"));

        Instant start = Instant.now();
        String text = element.getText();
        Instant finish = Instant.now();
        long duration = Duration.between(start, finish).toMillis();

        Assert.assertTrue(text.isEmpty());
        Assert.assertTrue(duration < 5000);
    }

    @Test
    public void getAttribute() {
        browser.goTo("http://watir.com/examples/data_attributes.html");
        Element element = browser.element(By.tagName("p"));

        Assert.assertEquals("ruby-library", element.getAttribute("data-type"));
    }

    @Test
    public void getAttributeWhenStale() {
        browser.goTo("http://watir.com/examples/data_attributes.html");
        Element element = browser.element(By.tagName("p"));
        element.doesExist();
        browser.refresh();

        try {
            element.getAttribute("whatever");
            Assert.assertTrue(true);
        } catch (StaleElementReferenceException e) {
            Assert.fail("Getting attribute should re-look up stale elements");
        }
    }

    @Test
    public void getAttributeNullWhenMissing() {
        browser.goTo("http://watir.com/examples/data_attributes.html");
        Element element = browser.element(By.tagName("p"));

        Assert.assertNull(element.getAttribute("foo"));
    }

    @Test
    public void getAttributeElementDisabled() {
        browser.goTo("http://watir.com/examples/forms_with_input_elements.html");
        Element element = browser.element(By.id("new_user_species"));

        Assert.assertEquals("new_user_species", element.getAttribute("name"));
    }

    @Test
    public void getAttributeElementHidden() {
        browser.goTo("http://watir.com/examples/forms_with_input_elements.html");
        Element element = browser.element(By.id("new_user_interests_dolls"));

        Assert.assertEquals("new_user_interests", element.getAttribute("name"));
    }

    @Test
    public void getAttributeElementNotExist() {
        Element element = browser.element(By.id("not-there"));

        Instant start = Instant.now();
        try {
            element.getAttribute("anything");
            fail("Expected a NoSuchElementException that was never thrown");
        } catch (NoSuchElementException e) {
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            Assert.assertTrue(duration > 5000);
        }
    }

    @Test
    public void getValue() {
        browser.goTo("http://watir.com/examples/forms_with_input_elements.html");
        Element element = browser.element(By.id("new_user_occupation"));

        Assert.assertEquals("Developer", element.getValue());
    }

    @Test
    public void getValueElementReadOnly() {
        browser.goTo("http://watir.com/examples/forms_with_input_elements.html");
        Element element = browser.element(By.id("new_user_code"));

        Assert.assertEquals("HE2FF8", element.getValue());
    }
}
