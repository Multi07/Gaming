package com.example.gaming;

import java.text.MessageFormat;
import java.time.LocalDate;

public class Player {
    String name;
    int level;
    String playerClass;
    String email;
    LocalDate registrationDate;

    @Override
    public String toString() {
        return MessageFormat.format("{0}", name);
    }

    Player(String name, int level, String playerClass, String email, LocalDate registrationDate){
        this.name = name;
        this.level = level;
        this.playerClass = playerClass;
        this.email = email;
        this.registrationDate = registrationDate;
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

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
