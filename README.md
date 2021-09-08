# RestAssured

This project is to test API of weatherbit (https://www.weatherbit.io/)

The Mission

This is to implement a test to automate finding the best beaches which meet the below criteria.

-Surf in any of 2 beaches Out of top ten in Sydney
-surf on Monday & Friday in next 16 days
-I look up the the weather forecast for the next 16 days with POSTAL CODES
-The temperature is between <12℃ and 30℃>
-The wind speed to be between 3 and 9
-UV index is less or equal to 12
-Pick best suitable spot out of top two spots, based upon suitable weather forecast for the day

How to Run
Please find WhereToSurf.feature and right click scenario outline and run as as Cucumber feature.
This consists of the below.
1. feature file:  src/test/resources/Feature/WhereToSurf.feature
2. Step definition file: src/test/java/StepDefinitions/whereToSurfSteps.java
3. Main file: src/test/java/main/weatherbit.java
4. Pojo files 
   src/test/java/pojo/Weatherbit.java
   src/test/java/pojo/Datum.java
   src/test/java/pojo/Weather.java
