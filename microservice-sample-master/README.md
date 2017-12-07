# microservice-sample

This is a proof-of-concept application, which demonstrates [Microservice Architecture Pattern](http://martinfowler.com/microservices/) using Spring Boot, Spring Cloud, Spring Config.

<hr/>
## Functional services

Decomposed into two core microservices. All of them are independently deployable applications, organized around certain business capability.

#### Login service

Method: POST<br/>
Path : /authenticate<br/>
Description: Validate userid password.<br/>
Curl Command: curl -H "Content-Type: application/json" -X POST -d '{"loginId":"xyz","password":"xyz"}' http://localhost:1112/loginservice/authenticate<br/>

Note: Business logic is hard coded, If userid/password are sample its authenticated.

<hr/>

## Edge Server

This is entry point to outside world.

In theory, a client could make requests to each of the microservices directly. But obviously, there are challenges and limitations with this option, like necessity to know all endpoints addresses, perform http request for each peace of information separately, merge the result on a client side. Another problem is non web-friendly protocols, which might be used on the backend.

It can be used for authentication, insights, stress and canary testing, service migration, static response handling, active traffic management.

<b>With Spring Cloud we can enable it with one @EnableZuulProxy annotation</b>

@EnableZuulProxy
public class Config {
}

<b>Route requests to appropriate microservices, defined in application.properties</b> 

zuul.prefix=/api<br/>
zuul.ignoredServices='*'<br/>
zuul.routes.auth-service.path=/auth-service/**<br/>
zuul.routes.auth-service.serviceId=AUTH-SERVICE<br/>
zuul.ribbon.restclient.enabled=true<br/>
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000<br/>

Note: Detail code for edge server can be found in edge-server project
<hr>

## Service Discovery

The key part of Service discovery is Registry. I use Netflix Eureka in this project. Eureka is a good example of the client-side discovery pattern, when client is responsible for determining locations of available service instances (using Registry server) and load balancing requests across them.

With Spring Boot, you can easily build Eureka Registry with spring-cloud-starter-eureka-server dependency, @EnableEurekaServer annotation and simple configuration properties.

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}

Every service will get register to Eureka server on its starup and provide all required info like URL, Host etc.

application.properties for eureka server.

spring.application.name=eureka-service<br/>
server.port=1111<br/>
eureka.instance.client.register-with-eureka=false<br/>
eureka.instance.client.fetch-registry=false<br/>
logging.level.com.netflix.eureka=OFF<br/>
logging.level.com.netflix.discover=OFF<br/>

Note: Detail code for eureka server can be found in eureka-server project

<hr/>

##Load balancer, Circuit breaker and Http client

####Ribbon

Ribbon is a client side load balancer which gives you a lot of control over the behaviour of HTTP and TCP clients. Compared to a traditional load balancer, there is no need in additional hop for every over-the-wire invocation - you can contact desired service directly.

Out of the box, it natively integrates with Spring Cloud and Service Discovery. Eureka Client provides a dynamic list of available servers so Ribbon could balance between them.

####Hystrix

Hystrix is the implementation of Circuit Breaker pattern, which gives a control over latency and failure from dependencies accessed over the network. The main idea is to stop cascading failures in a distributed environment with a large number of microservices. That helps to fail fast and recover as soon as possible - important aspects of fault-tolerant systems that self-heal.

Besides circuit breaker control, with Hystrix you can add a fallback method that will be called to obtain a default value in case the main command fails.

####Feign

Feign is a declarative Http client, which seamlessly integrates with Ribbon and Hystrix. Actually, with one spring-cloud-starter-feign dependency and @EnableFeignClients annotation you have a full set of Load balancer, Circuit breaker and Http client with sensible ready-to-go default configuration.

public interface LoginService {<br/>
	@RequestMapping(value="/authenticate", method=RequestMethod.POST, produces="application/json")<br/>
	public MessageWrapper<Object> authenticate(@RequestBody Object loginBean);<br/>
}<br/>

@FeignClient(value="login-service", fallback=LoginServiceFallBack.class)<br/>
public interface LoginServiceClient extends LoginService<br/>
{<br/>
}<br/>

NOTE: PLEASE LOOK INTO AUTH-CLIENT PROJECT FOR FEIGN<br/>


<hr>

## Notes
Once you download code and its setup in standard ID starts the application in following sequence.

1 - Eureka Server - You might get error at console saying replica server is not configure, we can ignore for development purpose.<br/>
2 - Login Service<br/>
3 - Auth Client<br/>
4 - Edge Server<br/>

Use following curl command to test<br/>

curl -H "Content-Type: application/json" -X POST -d '{"loginId":"xyz","password":"xyssssz"}' http://localhost:1114/api/auth-service/login/authenticate<br/>

curl -H "Content-Type: application/json" -X POST -d '{"loginId":"xyz","password":"xyz"}' http://localhost:1114/api/auth-service/login/authenticate<br/>

If you want to check FALLBACK mechanism, stop login/token service and execute above commands again.<br/>

Once fallback scenario is tested start the login/token service and execute above commands. Wait for 1 Minute once server are started as hystrix default isolation for thread is set to 1min.

<hr/>




