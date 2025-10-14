package com.kaiosantiago.laudopro.exceptions;

public class SafetyValveAlreadyExists extends RuntimeException{
    public SafetyValveAlreadyExists(String message){
        super(message);
    }
}
