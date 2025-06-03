package com.vinicardoso.cryptochat.entity;

import lombok.Data;

@Data
public class MessageEntity {

    private String id;
    private String conversationId;
    private int[][] content;
    private UserEntity sender;
    private UserEntity recipient;
    private boolean read;

}
