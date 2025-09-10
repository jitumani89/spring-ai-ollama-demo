package com.jitu.ai.springaidemo.controller;

import com.jitu.ai.springaidemo.dto.ChatRequestDto;
import com.jitu.ai.springaidemo.dto.ChatResponseDto;
import com.jitu.ai.springaidemo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    public ChatService chatService;

    /*@PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chat(@RequestBody ChatRequestDto request){
        return chatService.getChatResponse(request);
    }*/

    @PostMapping
    public ChatResponseDto chat(@RequestBody ChatRequestDto request){
        return chatService.getChatResponse(request);
    }
}
