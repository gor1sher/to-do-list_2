package ru.todolist.dal.repository;

import ru.todolist.model.Task;

import java.util.List;

public interface TaskRepsitory {
    Task getTaskById(Long id);
    List<Task> getListTasks();
    void save(Task task);
    void update(Task task);
    void delete(Long id);
}
