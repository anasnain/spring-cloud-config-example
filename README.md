# spring-cloud-config-example
Demo application for Spring cloud config 

Spring Cloud Config (http://projects.spring.io/spring-cloud/) has the client – server communication architecture. It has both server and client modules. server will be responsible for maintaining the properties and client will retrieve them.

Spring Cloud Config Server can be used to centralize all the applications configuration. Then the Spring Cloud Config Client module can be used by service applications to consume configuration properties from Config Server. It is possible to update the configuration properties at runtime without restarting or redeploying the application.

# Steps to run the project:
1. First build the project using mvn command: 
   mvn clean install
2. Run config server module: 
java -jar spring-cloud-config-server/target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar

3. Run config client module: 
java -jar -Dspring.profiles.active=dev -Dconfig.server=http://localhost:9080 spring-boot-config-client/target/spring-boot-config-client-0.0.1-SNAPSHOT.jar

Here we are passing profiles, config server location in java start command

# Access config server configurations
Generally we use below http resource to acees config server configurations
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

application: config client application name
profile: like dev, qa, prod etc
label[optional]: branch name in git

For example, we have created a client module whose appliaction name (check spring.application.name property value in bootstrap file) is spring-boot-config-client, and to acess dev profiles configurations, use below url
- http://localhost:9080/spring-boot-config-client/dev/master

# Access client module application
We have create 2 endpoints to test if we are able to fetch property value from config server
1. http://localhost:9081/userType

2. http://localhost:9081/errorType

# Update property value in git and commit the change and see if the property got updated without restarting client/server app
- Commit the changes in configuration repo
- Call Actuator refresh endpoint to refresh the property without restarting the client app:  
curl -X POST "http://localhost:9081/actuator/refresh"
- Now call the above 2 endpoints /userType and /errorType to see the latest updates


