package com.example.chatgpt.service;

import com.example.chatgpt.config.OpenAIConfig;
import com.example.chatgpt.dto.ChatMessage;
import com.example.chatgpt.dto.ChatRequest;
import com.example.chatgpt.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ChatGptService {

	@Autowired
	private OpenAIConfig config;

	@Autowired
	private WebClient openAiWebClient;

	private final RestTemplate restTemplate = new RestTemplate();
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";

	public String perguntarRestTemplate(String pergunta) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(config.getApiKey());

		ChatRequest body = new ChatRequest("gpt-3.5-turbo", List.of(new ChatMessage("user", pergunta)));
		HttpEntity<ChatRequest> request = new HttpEntity<>(body, headers);

		ResponseEntity<ChatResponse> response = restTemplate.postForEntity(API_URL, request, ChatResponse.class);
		return response.getBody().getChoices().get(0).getMessage().getContent();
	}

	public Mono<String> perguntarWebClient(String pergunta) {
		ChatRequest request = new ChatRequest("gpt-3.5-turbo", List.of(new ChatMessage("user", pergunta)));

		return openAiWebClient.post().uri("/chat/completions").bodyValue(request).retrieve()
				.bodyToMono(ChatResponse.class).map(resp -> resp.getChoices().get(0).getMessage().getContent());
	}
}