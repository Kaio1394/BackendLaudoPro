package com.kaiosantiago.laudopro.exceptions;

public class WorkOrderNumberAlreadyExists extends RuntimeException{
    public WorkOrderNumberAlreadyExists(String message){
        super(message);
    }
}
