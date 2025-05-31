package com.vinicardoso.cryptochat.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity sender;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity recipient;

}
