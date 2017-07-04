package com.example.demo;

import com.example.demo.config.MyExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// 注册统一异常处理bean
	@Bean
	public MyExceptionResolver myExceptionResolver() {
		return new MyExceptionResolver();
	}
}
