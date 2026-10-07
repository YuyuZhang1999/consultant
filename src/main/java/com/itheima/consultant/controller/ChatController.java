package com.itheima.consultant.controller;

import com.itheima.consultant.aiservice.ConsultantService;
import dev.langchain4j.model.chat.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

//    @Autowired
//    private ChatModel chatModel;

    @Autowired
    private ConsultantService consultantService;

//    @RequestMapping("/chat")
//    public String chat(@RequestParam("message") String message) {
//        return chatModel.chat(message);
//    }

//    @RequestMapping("/chat")
//    public String chat(@RequestParam("message") String message){
//        String result =  consultantService.chat(message);
//        return result;
//    }

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestParam("memoryId") String memoryId, @RequestParam("message") String message){
        return consultantService.chat(memoryId, message);
    }
}
