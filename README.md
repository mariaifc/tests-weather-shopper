# tests-weather-shopper
This repo was built using Java + Selenium + Maven + TestNG and it shows an example how to run tests in paralel using two browsers (Chrome and Edge). It is focused on https://weathershopper.pythonanywhere.com/ website.

## Getting started
These instructions will get you a copy of the project up and running on your local machine

### Prerequisites
- IntelliJ IDEA
- Java
- Chrome browser
- Edge browser

If you don't have it installed, please visit:

- IntelliJ IDEA : https://www.jetbrains.com/idea/download/#section=mac
- Java : https://www.oracle.com/java/technologies/javase-downloads.html

### Import the project
- Clone the github project
- Open the IDE
- Import the project

### Running the tests locally
- Open sanity.xml file
- Right button click on "Run '.../sanity.xml'

In the terminal:

- mvn clean test -DsuiteXmlFile=sanity.xml

### Report available at
- After executing the project, go to target/surefire-reports
- Right button click on emailable-report.html > Open in > Browser > Chrome (or any other available)

### Built with
- Maven - Dependency Management
- TestNG - Testing Framework
