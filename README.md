### Microservice

1. Here we created one microservice 'Rating Microservice'.
2. This microservice is using PostgreSql database.
3. Swagger UI URL -- http://localhost:9091/swagger-ui/index.html
4. This microservice is also using or used in other two microservices -
    1. [Hotel microservice](https://github.com/ayushdgupta/SpringBoot3-Hotel-Microservice).
    2. [User microservice](https://github.com/ayushdgupta/SpringBoot3-User-Microservice/tree/master). 
5. Now we need to register our microservice with our eureka server, for that we need to follow below steps -
   1. First we need to add below dependencies -
   ```
   implementation 'org.springframework.cloud:spring-cloud-starter'
   implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
   ```
   2. Here we added two dependencies one is for Spring-cloud and another one is for Eureka-client.
   3. Apart from that we need to add few other configuration like depenedency management and Spring cloud version.
   4. We need to add few dependencies in Application.yml file -
   ```yaml
   eureka:
     instance:
       prefer-ip-address: true
     client:
       register-with-eureka: true
       fetch-registry: true
       service-url:                                    # this property will tell our microservice ki kis server ke
        defaultZone: http://localhost:8761/eureka     # paas jake register hona hai.
   ```
6. This Microservice is registerd at below Eureka Server -
   [Eureka Server](https://github.com/ayushdgupta/SpringBoot3-Eureka-Service-Microservice)
7. This API is configured with below API-Gateway --  
   [API Gateway](https://github.com/ayushdgupta/SpringBoot3-APIGateway-Microservice)
8. This API is using Config-server to fetch common configuration - [Config-Server](https://github.com/ayushdgupta/SpringBoot3-ConfigServer-Microservice)
9. Configurations are present on Github - [Common-Configuration](https://github.com/ayushdgupta/SpringBoot3-ConfigFiles-ConfigServer-Microservice)

### Microservice as config-client
1. To use our microservice as config client we need to add below dependency -
```groovy
implementation 'org.springframework.cloud:spring-cloud-starter-config'
```
2. Apart from that we need to add few configurations in our application.yaml file -
```yaml
spring:
  config:                             # this propes is used to connect to the config-server
    import: optional:configserver:http://localhost:9094
```
3. By Adding above two configurations our microservice will act as config-client, so now it can fetch any values
   from config files whatever required internally (eureka server props) or externally (using @Value, System.getProperty()).
4. @RefreshScope