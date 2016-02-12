package com.bong.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bong.calculator.model.Calculator;
import com.bong.calculator.model.UserManager;

@Configuration
public class CalculatorConfig {

	@Bean
	public Calculator calculator() {
		return new Calculator();
	}

	@Bean
	public UserManager userManager() {
		return new UserManager();
	}
}
