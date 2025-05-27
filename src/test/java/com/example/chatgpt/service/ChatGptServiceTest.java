package com.example.chatgpt.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.chatgpt.config.OpenAIConfig;

public class ChatGptServiceTest {

	@Mock
	private OpenAIConfig config;

	@InjectMocks
	private ChatGptService service;

	@BeforeEach
	public void setup() {
		openMocks(this);
	}

	@Test
	public void testPerguntarRestTemplate() {
		when(config.getApiKey()).thenReturn("test-key");
		String resposta = service.perguntarRestTemplate("Olá");
		assertNotNull(resposta);
	}
}