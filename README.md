# spring-cloud-config-example
Demo application for Spring cloud config 

Spring Cloud Config (http://projects.spring.io/spring-cloud/) has the client – server communication architecture. It has both server and client modules. server will be responsible for maintaining the properties and client will retrieve them.

Spring Cloud Config Server can be used to centralize all the applications configuration. Then the Spring Cloud Config Client module can be used by service applications to consume configuration properties from Config Server. It is possible to update the configuration properties at runtime without restarting or redeploying the application.

# Steps to run the project:
- First build the project using mvn command
mvn clean install
- Run config server module
java -jar spring-cloud-config-server/target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar

- Run config client module
java -jar -Dspring.profiles.active=dev -Dconfig.server=http://localhost:9080 spring-boot-config-client/target/spring-boot-config-client-0.0.1-SNAPSHOT.jar

Here we are passing profiles, config server location in java start command


