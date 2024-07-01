package com.dh.middleware.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource({ "classpath:spring/camel-context.xml" })
@ComponentScan("com.dh.middleware.account.*")
public class MidddlewareAccountApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidddlewareAccountApIsApplication.class, args);
	}

}
