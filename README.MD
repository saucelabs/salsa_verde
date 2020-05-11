# Salsa Verde

Salsa Verde translates to "Green Sauce," and if you are looking to create a greenfield UI testing project that
is optimized for usage on Sauce Labs, this is a great choice.

This software is currently in its early stages of development, but we consider it to be
a Minimum Viable Product and immediately usable in your UI testing efforts. 
What this means is that we have a long list of features that we are planning to add, 
and if you would like to use this software it would greatly help us to get feedback and 
feature requests so we know what to prioritize.

### Inspiration

Solution Architects at Sauce Labs get to see many testing frameworks built by our clients.
The majority of them do not handle synchronization very well, resulting in an excessive
number of flaky tests. The teams that do properly manage the necessary synchronization
often do so at the expense of performance. While this is always a worthwhile trade-off
(optimize for maintenance costs, not execution costs), you can have both.

When executing locally, wire calls are essentially "free," executing in milliseconds, but
when running against a remote server, each round trip takes significantly longer, and
this overhead adds up quickly. [Watir](https://watir.com) is a Ruby test library that
 implemented a successful synchronization optimization approach several years ago. Salsa Verde is 
 leveraging this knowledge to a provide a Java solution. Specific implementation ideas
 for how to do this been pulled from several sources, including
 [Mineraloil](https://github.com/titusfortner/mineraloil-selenium)

### Usage

Version 0.1.0 has been released on Maven; add this to your `pom.xml` file:
```
<dependency>
  <groupId>com.saucelabs</groupId>
  <artifactId>salsa_verde</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Goals

1. Easy to toggle Local & Remote
2. Easy to use with Sauce Bindings
3. Support for Desktop & Mobile
4. Allow automatic relocation of Stale Elements
5. Smart Synchronization Strategy
6. Simple Form Filling
7. Test Runner agnostic
8. Encourage declarative test writing with Useful abstractions 


### Status
1. Accepts Browser Options from Selenium
2. Basic browser wrapper
3. Basic element wrapper
4. Synchronization implementation for element methods
5. Staleness Relocation
6. Collection Support
7. Page Object Implementation
8. Data Object Implementation
9. Nested Elements Supported
10. JavaScript Executor Support
11. Actions Class Wrapper (Scroll, Hover, Right Click, Double Click, Drag & Drop)


### Future Ideas
1. Direct Support for IFrames
2. Subclass Elements for Encapsulation
3. Automatic Form Filling
4. Automatic Data Reading
5. Logging Support
6. API Integration
7. Alert Wrapper
8. Windows Wrapper
9. Screenshot Wrapper
10. Cookies Wrapper
11. Scrolling Support
12. After Hooks


### Example Code

 The test directory has a number of examples to demonstrate usage, but basically the syntax looks like:
 
 ```java
Browser browser = new Browser();
PageObject.setBrowser(browser);
browser.goTo("https://www.saucedemo.com/");

userName userName = browser.element(By.id("user-name"));
userName.setText("standard_user");
Element password = browser.element(By.id("password"));
password.setText("secret_sauce");
Element submitButton = browser.element(By.className("btn_action"));
submitButton.click();

Assert.assertEquals("https://www.saucedemo.com/inventory.html", browser.getCurrentUrl())

browser.quit();
```

There are also a basic `DataObject` and `PageObject` classes that will allow you to
remove unnecessary details from the text of your tests allowing them to focus on 
the actual business logic.
