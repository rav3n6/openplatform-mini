# Application React with Java


To Build and run :

Make sure you have latest version of following installed : 

JDK : 1.8+
Maven : https://maven.apache.org/
Node : https://nodejs.org/en/
npm : https://www.npmjs.com/

gulp : https://gulpjs.com/ 
      gulp should be installed globally to able to be used as CLI so use
      npm install --global-cli 
      then verify using 
      gulp --version
      
steps :

{location}/openplatform-mini --> mvn install

once build is completed --> java -jar target/assoc.0.0.2-SNAPSHOT.jar

Else to run UI and Backend saperately :

Navigate to src/main/java/com.asjad.tech --> Run AssocApplication.Java 

Navigate to src/main/ui --> npm install and then npm start
 
