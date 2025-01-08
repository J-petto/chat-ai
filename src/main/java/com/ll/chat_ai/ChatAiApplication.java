package com.ll.chat_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaAuditing
public class ChatAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatAiApplication.class, args);
	}

}
