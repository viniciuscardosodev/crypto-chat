package com.vinicardoso.cryptochat.controller;

import com.vinicardoso.cryptochat.entity.ConversationEntity;
import com.vinicardoso.cryptochat.entity.MessageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {

    @PostMapping("/send")
    public ResponseEntity<MessageEntity> sendMessage(@RequestBody MessageEntity message) {
        var conv = ConversationEntity.getConversationById(message.getConversationId());

        if (conv == null) {
            return ResponseEntity.badRequest().build(); // conversa precisa existir
        }

        conv.getMessages().add(message);
        conv.persist();
        return ResponseEntity.ok().body(message);
    }


}
