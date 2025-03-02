package com.bolsaideas.datajpa.models.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    private final String API_KEY = "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"; // Reemplaza por tu clave de OpenAI

    public String callOpenAI() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        // Configurar los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json");

        // Cuerpo de la petición
        String requestBody = "{\n" +
            "  \"model\": \"gpt-3.5-turbo\",\n" +
            "  \"messages\": [{\"role\": \"user\", \"content\": \"Hola, ¿cómo estás?\"}],\n" +
            "  \"max_tokens\": 150\n" +
            "}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Hacer la petición
        ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

        // Manejar la respuesta de OpenAI
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody(); // Retornar el cuerpo de la respuesta
        } else {
            throw new Exception("Error en la llamada a OpenAI: " + response.getStatusCode());
        }
    }
}