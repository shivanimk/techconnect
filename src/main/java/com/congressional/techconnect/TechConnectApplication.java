package com.congressional.techconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TechConnectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TechConnectApplication.class, args);
		Object datasource = context.getBean("dataSource");
		System.out.println(datasource);
	}

}

