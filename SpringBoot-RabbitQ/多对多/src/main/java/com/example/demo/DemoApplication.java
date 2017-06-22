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
	RabbitSender1 sender1;

	@Autowired
	RabbitSender2 sender2;

	@RequestMapping("/go")
	public void sender() {
		for (int i=0; i<100; i++) {
			sender1.send(i);
			sender2.send(i);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
