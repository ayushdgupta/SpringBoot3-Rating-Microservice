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