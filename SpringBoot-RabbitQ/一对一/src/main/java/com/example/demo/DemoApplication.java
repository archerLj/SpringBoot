package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Autowired
	HelloSender helloSender;

	@RequestMapping("/go")
	public void sender() {
		helloSender.send();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
