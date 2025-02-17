package com.example.gaming;

import java.text.MessageFormat;

public class Player {
    String name;
    int level;
    String playerClass;
    String email;
    String registrationDate;

    @Override
    public String toString() {
        return MessageFormat.format("{0}, {1}, {2}, {3}, {4}", name, level, playerClass, email, registrationDate);
    }

    Player(String name, int level, String playerClass, String email, String registrationDate){
        this.name = name;
        this.level = level;
        this.playerClass = playerClass;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
