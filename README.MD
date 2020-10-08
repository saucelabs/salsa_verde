# Salsa Verde

Salsa Verde translates to "Green Sauce," and if you are looking to create a greenfield UI testing project that is optimized for usage on Sauce Labs, this is a great choice.

This software is currently in its early stages of development, but we consider it to be a Minimum Viable Product and immediately usable in your UI testing efforts. What this means is that we have a long list of features that we are planning to add, and if you would like to use this software it would greatly help us to get feedback and feature requests so we know what to prioritize.

### Inspiration

Solution Architects at Sauce Labs get to see many testing frameworks built by our clients. The majority of them do not handle synchronization very well, resulting in an excessive number of flaky tests. The teams that do properly manage the necessary synchronization often do so at the expense of performance. While this is always a worthwhile trade-off (optimize for maintenance costs, not execution costs), you can have both.

When executing locally, wire calls are essentially "free," executing in milliseconds, but when running against a remote server, each round trip takes significantly longer, and this overhead adds up quickly. [Watir](https://watir.com) is a Ruby test library that implemented a successful synchronization optimization approach several years ago. Salsa Verde is leveraging this knowledge to a provide a Java solution. Specific implementation ideas for how to do this been pulled from several sources, including [Mineraloil](https://github.com/titusfortner/mineraloil-selenium)

### Usage

Version 0.1.0 has been released on Maven; add this to your `pom.xml` file:

```xml
<dependency>
  <groupId>com.saucelabs</groupId>
  <artifactId>salsa_verde</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Goals

1. Easy to toggle Local & Remote
1. Easy to use with Sauce Bindings
1. Support for Desktop & Mobile
1. Allow automatic relocation of Stale Elements
1. Smart Synchronization Strategy
1. Simple Form Filling
1. Test Runner agnostic
1. Encourage declarative test writing with Useful abstractions 

### Status

1. Accepts Browser Options from Selenium
1. Basic browser wrapper
1. Basic element wrapper
1. Synchronization implementation for element methods
1. Staleness Relocation
1. Collection Support
1. Page Object Implementation
1. Data Object Implementation
1. Nested Elements Supported
1. JavaScript Executor Support
1. Actions Class Wrapper (Scroll, Hover, Right Click, Double Click, Drag & Drop)

### Future Ideas

1. Direct Support for IFrames
1. Subclass Elements for Encapsulation
1. Automatic Form Filling
1. Automatic Data Reading
1. Logging Support
1. API Integration
1. Alert Wrapper
1. Windows Wrapper
1. Screenshot Wrapper
1. Cookies Wrapper
1. Scrolling Support
1. After Hooks

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

### Contributing

If you are interested in helping moving this project forward don't hesitate to contribute. Have a look into our [contribution guidelines](https://github.com/saucelabs/salsa_verde/blob/master/CONTRIBUTING.md) and for question please create an issue. Cheers!