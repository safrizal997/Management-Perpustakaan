package com.safrizal.managementperpustakaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ManagementPerpustakaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementPerpustakaanApplication.class, args);
	}

}
