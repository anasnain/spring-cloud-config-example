# spring-cloud-config-example
Demo application for Spring cloud config 

The one of the most challenge in the distributed application environment (or rather microservices environment) is to maintain and manage the configuration related properties in the microservices.

In microservice environment, there may be hundred of isolated services and each service may have different configuration properties depending on the environment (eg:- qa, dev, prod, uat etc…).

Some of the properties are shared among services and some of the properties are specific/private to that service. Those properties may be changed or updated in later and the update need to be reflected. If the configuration maintaining and management is not properly planned, you have to face for a difficult time when those update happens

