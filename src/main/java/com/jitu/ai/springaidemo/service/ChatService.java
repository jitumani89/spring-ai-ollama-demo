package com.jitu.ai.springaidemo.service;

import com.jitu.ai.springaidemo.dto.ChatRequestDto;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Autowired
    public OllamaChatModel ollamaChatModel;

    /*public ChatResponseDto getChatResponse(ChatRequestDto request) {
        Prompt prompt = new Prompt(request.getMessage());
        ChatResponse chatResponse = ollamaChatModel.call(prompt);
        return new ChatResponseDto(chatResponse.getResult().getOutput().getText());
    }*/

    public Flux<String> getChatResponse(ChatRequestDto request) {
        Prompt prompt = new Prompt(request.getMessage());
        ChatResponse chatResponse = ollamaChatModel.call(prompt);
        return ollamaChatModel.stream(prompt).map(chunk->chunk.getResult().getOutput().getText());
    }
    @PostConstruct
    public void logModel() {
        System.out.println("******Ollama model in use: "
                + ollamaChatModel.getDefaultOptions().getModel());
    }


}
