package com.example.config;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages = "com.example")
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean   
	public JavaMailSender getMailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();     
		//Using gmail     
		mailSender.setHost("smtp.gmail.com");   
		mailSender.setPort(587);      
		mailSender.setUsername("nguyenhongson31011997@gmail.com");
		mailSender.setPassword("nam31011997");          
		Properties javaMailProperties = new Properties();      
		javaMailProperties.put("mail.smtp.starttls.enable", "true");   
		javaMailProperties.put("mail.smtp.auth", "true");    
		javaMailProperties.put("mail.transport.protocol", "smtp");     
		javaMailProperties.put("mail.debug", "true");//Prints out everything on screen      
		mailSender.setJavaMailProperties(javaMailProperties);   
		return mailSender;    
	}
	
	
}
