package com.techforce.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	@Value("${endpoints.memberServiceUrl}")
	private String memberServiceUrl;

	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder){
		return builder.routes()
				.route("memberRoute",p -> p.path("/member").uri(memberServiceUrl))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
