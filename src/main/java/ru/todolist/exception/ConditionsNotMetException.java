package ru.todolist.exception;

public class ConditionsNotMetException extends RuntimeException{

    public ConditionsNotMetException(String str) {
        super(str);
    }
}
