package com.vinicardoso.cryptochat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ConversationEntity {

    private static HashMap<String, ConversationEntity> conversations = new HashMap<>();

    private String id;
    private List<UserEntity> participants;
    private List<MessageEntity> messages;

    public static ConversationEntity getByUsers(String username1, String username2) {
       for (var conv : conversations.values()) {
            var part1 = conv.getParticipants().get(0);
            var part2 = conv.getParticipants().get(1);
            if (
                (part1.getUsername().equals(username1) && part2.getUsername().equals(username2))
                || (part1.getUsername().equals(username2) && part2.getUsername().equals(username1))
            ) {
                return conv;
           }
       }
       return null;
    }

    public static ConversationEntity getConversationById(String id) {
        return conversations.get(id);
    }

    public void persist() {
        conversations.put(id, this);
    }

}
