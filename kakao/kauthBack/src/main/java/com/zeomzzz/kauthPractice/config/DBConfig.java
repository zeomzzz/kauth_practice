package com.zeomzzz.kauthPractice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.zeomzzz.kauthPractice.model.dao")
public class DBConfig {
}