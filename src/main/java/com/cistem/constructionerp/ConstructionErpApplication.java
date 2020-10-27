package com.cistem.constructionerp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableTransactionManagement
@ComponentScan({"com.cistem"})
@EnableJpaRepositories({"com.cistem"})
@EntityScan({"com.cistem"})
public class ConstructionErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructionErpApplication.class, args);
	}

}
