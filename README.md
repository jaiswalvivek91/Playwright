# AutomationFramework-Selenium BDD

This is web based UI automation framework created using Java cucumber Playwright with maven.
All Dependencies and plugins are added to POM.xml

Config related data is available in config.properties in "src/test/resources/config/config.properties"
The feature files are in the location: "src/test/resources/features"

To run the automation scripts there are multiple ways.
1.From Runner class(FlightTest.java) available in "src/test/java/TestRunner" as JUnit.
2.By maven command as :
	mvn clean compile
	mvn test

3.The framework is integrated to Jenkins.
// Yet to be done //



The report is shared as email notification with report attachment to valid emailID..