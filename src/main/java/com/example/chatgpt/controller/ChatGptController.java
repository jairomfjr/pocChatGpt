package com.example.chatgpt.controller;

import com.example.chatgpt.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
public class ChatGptController {

	@Autowired
	private ChatGptService service;

	@GetMapping("/sync")
	public String perguntarSync(@RequestParam String pergunta) {
		return service.perguntarRestTemplate(pergunta);
	}

	@GetMapping("/async")
	public Mono<String> perguntarAsync(@RequestParam String pergunta) {
		return service.perguntarWebClient(pergunta);
	}
}