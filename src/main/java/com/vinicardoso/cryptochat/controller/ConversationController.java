package com.vinicardoso.cryptochat.controller;

import com.vinicardoso.cryptochat.entity.ConversationEntity;
import com.vinicardoso.cryptochat.entity.MessageEntity;
import com.vinicardoso.cryptochat.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("conversation/") //
@CrossOrigin
public class ConversationController {

    @GetMapping("/messages")
    public ResponseEntity<List<MessageEntity>> getConversationMessages(@RequestParam String id) {
        var conv = ConversationEntity.getConversationById(id);
        if (conv == null) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(conv.getMessages());
    }

    @PostMapping("/getId")
    public ResponseEntity<String> getConversationId(@RequestBody List<UserEntity> users) {
        if (users.size() != 2) {
            return ResponseEntity.badRequest().body("Devem ser exatamente dois usuários.");
        }

        String userA = users.get(0).getUsername();
        String userB = users.get(1).getUsername();

        var conv = ConversationEntity.getByUsers(userA, userB);
        if (conv == null) {
            String id = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
            conv = new ConversationEntity(id, users, new ArrayList<>());
            conv.persist();
        }
        return ResponseEntity.ok(conv.getId());
    }



}
