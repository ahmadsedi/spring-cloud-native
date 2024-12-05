package com.ahmadsedighi.cloud;

import org.springframework.boot.SpringApplication;

public class TestCloudNativeApplication {

	public static void main(String[] args) {
		SpringApplication.from(CloudNativeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
