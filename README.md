# tests-weather-shopper
This projects aims to automate the test case below:

TC1: Check if items can be bought successfuly in weather shopper

Preconditions:
1. User has connection to Internet
2. Chrome and Edge browsers are installed in the computer

Steps:
1. Open the https://weathershopper.pythonanywhere.com
2. Check the temperature and click on "Buy sunscreens" button if temperature > 34 OR "Buy moisturizer" if temperature < 19
3. In case of moisturizers:
  - Search the the cheapest item in which the name contains "Aloe" and click on "Add" button 
  - Search the the cheapest item in which the name contains "Almond" and click on "Add" button
  In case of sunscreens:
  - Search the the cheapest item in which the name contains "SPF-50" and click on "Add" button 
  - Search the the cheapest item in which the name contains "SPF-30" and click on "Add" button
4. Click on Cart button
5. Click on Pay With Card button
6. Insert the data card related (Mock card - number :"4242424242424242", expiration date "1022", cvc "123")
7. Insert valids email and a zip code
8. Click on Submit button

Expetected results:
1. Page is opened without errors
2. "Buy sunscreens" and "Buy moisturizer" should be clickable
3. The options should be available and added to the cart without issues
4. The Two cheapest items should be listed properly (name and price) and the sum of two items prices should be correct
5. Checkoupt pgae shoudl be displayed
6. 7. The input fields should be available and the data can be inserted with no errors
8. The PAYMENT SUCCESS message should be displayed in confirmation page

## Getting started
These instructions will get you a copy of the project up and running on your local machine

### Prerequisites
- IntelliJ IDEA
- Java
- Chrome 
- Edge 

If you don't it installed, please visit:

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
