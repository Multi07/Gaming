package com.example.gaming;

import java.text.MessageFormat;
import java.time.LocalDate;

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

    Player(String name, int level, String playerClass, String email, LocalDate registrationDate){
        this.name = name;
        this.level = level;
        this.playerClass = playerClass;
        this.email = email;
        this.registrationDate = String.valueOf(registrationDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
