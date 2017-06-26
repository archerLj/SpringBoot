package com.example.demo;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableCaching
@ComponentScan("com.example.demo.domain")
public class DemoApplication {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/getUser")
	public User getUser() {
		User user = userRepository.findByName("archerLj");
		return user;
	}

	@RequestMapping("/save")
	public User save() {
		User user = userRepository.findByName("archerLj");
		user.setAge(102);
		return userRepository.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
