package ru.todolist.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private long id;
    private String name;
    private String description;
    private LocalDateTime localDateBegin;
    private LocalDateTime localDateEnd;
    private Status status;
}
