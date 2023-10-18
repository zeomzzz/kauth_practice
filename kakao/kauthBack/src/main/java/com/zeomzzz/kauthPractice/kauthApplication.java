package com.zeomzzz.kauthPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class kauthApplication{
	public static void main(String[] args) {
		SpringApplication.run(kauthApplication.class, args); 
	}
}