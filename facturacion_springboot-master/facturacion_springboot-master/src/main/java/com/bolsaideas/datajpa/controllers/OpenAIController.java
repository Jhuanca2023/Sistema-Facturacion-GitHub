package com.bolsaideas.datajpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsaideas.datajpa.models.service.OpenAIService;

@RestController
public class OpenAIController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/openai")
    public String getResponse() {
        try {
            // Llama al servicio y obtiene la respuesta de OpenAI
            String response = openAIService.callOpenAI();
            return response; // Devolver la respuesta obtenida
        } catch (Exception e) {
            // Manejo básico de errores
            return "Error al obtener la respuesta de OpenAI: " + e.getMessage();
        }
    }
}
