# 💻 My Automation Project 

#### This is a testing automation project that tests a real site called: www.ryanair.com/gb/en

## 📖 Overview

This repository contains a comprehensive automated testing project built with Java, TestNG, and Allure Reports. 
The project follows the Page Object Model (POM) design pattern for a modular and maintainable test suite.

<p>
  <img src="images/ryanair.jpg" width="70%" title="Example for screenshot on failure"  />
</p>

## 📑 Technologies & Skill & Features
| Technologies      | Description |
| ----------- | ----------- |
| **Java:**      | The project is developed using Java, providing a robust and widely used programming language for automation.       |
| **TestNG:**   | TestNG is used as the testing framework, offering powerful test configuration options, parallel execution, and detailed reporting.        |
| **Selenium WebDriver:**   | The project includes Selenium WebDriver for automating browser interactions        |
| **Page Object Model (POM):**   | The project follows the POM design pattern, enhancing test maintainability and reusability by separating page elements and actions.        |
| **Allure Reports:**   | Test results are documented using Allure Reports, providing a clear and interactive visualization of test execution.        |
| **Jenkins:**   | Continuous integration and continuous delivery (CI/CD) platform for automated builds and deployments.        |
| **Logging:**   | The project includes logging capabilities to capture and document important events during test execution.       |


## 📊 Reports

  ```bash
  mvn allure:serve
  ```

<img src="https://github.com/yuvaldd/finalProject/blob/main/OverView.png"> 
<img src="https://github.com/yuvaldd/finalProject/blob/main/Graphs.png">

## 🚀 Getting Started

1. **Clone the Repository:**
 ```bash
git clone "https://github.com/yuvaldd/finalProject.git"
```

## 📁 Project Structure
```
├───.allure
│   └───allure-2.8.1
│       ├───bin
│       ├───config
│       ├───lib
│       │   └───config
│       └───plugins
│           ├───behaviors-plugin
│           │   └───static
│           ├───custom-logo-plugin
│           │   └───static
│           ├───jira-plugin
│           │   └───lib
│           ├───junit-xml-plugin
│           ├───packages-plugin
│           │   └───static
│           ├───screen-diff-plugin
│           │   └───static
│           ├───trx-plugin
│           ├───xctest-plugin
│           │   └───lib
│           ├───xray-plugin
│           │   └───lib
│           └───xunit-xml-plugin
├───.settings
├───allure-results
├───ScreenShots
├───src
│   ├───main
│   │   ├───java
│   │   └───resources
│   └───test
│       ├───java
│       │   ├───pageobjects
│       │   └───tests
│       └───resources
├───target
│   ├───allure-results
│   ├───classes
│   ├───generated-sources
│   │   └───annotations
│   ├───generated-test-sources
│   │   └───test-annotations
│   ├───maven-status
│   │   └───maven-compiler-plugin
│   │       ├───compile
│   │       │   └───default-compile
│   │       └───testCompile
│   │           └───default-testCompile
│   ├───surefire-reports
│   │   ├───junitreports
│   │   ├───old
│   │   │   └───Suite
│   │   └───Suite
│   └───test-classes
│       ├───pageobjects
│       └───tests
└───test-output
    ├───Default suite
    ├───junitreports
    ├───old
    │   ├───Default suite
    │   └───Suite
    └───Suite

```

Thanks for visiting my GitHub profile! 😊
Yuval Haddy


