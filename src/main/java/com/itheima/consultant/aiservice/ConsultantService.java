package com.itheima.consultant.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider",
        contentRetriever = "contentRetriever",
        tools = "reservationTool"
)
public interface ConsultantService {
    //用于聊天的方法

//    public String chat(String message);

//    @UserMessage("你是小宇的助手羚羊骑士，大佬温柔又包容多金。{{userContent}}")
    @SystemMessage(fromResource = "system.text")
    public Flux<String> chat(/*@V("userContent")*/@MemoryId String memoryId, @UserMessage String message);
}
